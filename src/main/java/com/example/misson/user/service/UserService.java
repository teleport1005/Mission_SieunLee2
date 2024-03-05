package com.example.misson.user.service;

import com.example.misson.AuthenticationFacade;
import com.example.misson.user.dto.ActiveUserDto;
import com.example.misson.user.dto.RegisterDto;
import com.example.misson.user.dto.UserDto;
import com.example.misson.user.entity.UserEntity;
import com.example.misson.user.entity.UserRole;
import com.example.misson.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    // 기본 회원가입
    public UserDto createUser(RegisterDto user) {
        // 중복 에러
        if (userExists(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        UserEntity entity = UserEntity.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(UserRole.ROLE_INACTIVE) // 비활성화 권한 부여
                .build();

        return UserDto.fromEntity(userRepository.save(entity));

    }

    // 일반 사용자 전환
    public UserDto activeUser(ActiveUserDto activeUser, UserEntity entity) {

        UserEntity user = userRepository.findById(entity.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User"));

        // 이메일 중복 에러
        if (emailExists(activeUser.getEmail()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        user.setNickname(activeUser.getNickname());
        user.setNickname(activeUser.getName());
        user.setAge(activeUser.getAge());
        user.setEmail(activeUser.getEmail());
        user.setPhone(activeUser.getPhone());
        user.setRole(UserRole.ROLE_USER); // 사용자 권한 부여
        return UserDto.fromEntity(userRepository.save(user));

    }

    // TODO 일반 사용자 프로필 이미지 추가하기

    // TODO 비즈니스 계정 전환 신청하기

    // TODO 관리자가 신청한 리스트 확인 후 승인 / 거절하기






    public void updateUser(UserDetails user) {
        if (userExists(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

    }


    public void deleteUser(String username) {

    }


    public void changePassword(String oldPassword, String newPassword) {

    }


    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }


    public UserDetails loadUserByUsername(String userId)
            throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser
                = userRepository.findByUsername(userId);
        if (optionalUser.isEmpty())
            throw new UsernameNotFoundException(userId);

        UserEntity userEntity = optionalUser.get();
        return null;
    }
}
