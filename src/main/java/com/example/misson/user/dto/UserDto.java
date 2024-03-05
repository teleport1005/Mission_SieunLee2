package com.example.misson.user.dto;

import com.example.misson.user.entity.UserEntity;
import lombok.*;



@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;

    @Setter
    private String nickname;
    @Setter
    private String name;
    @Setter
    private int age;
    @Setter
    private String email;
    @Setter
    private String phone;
    @Setter
    private String imagePath;
    @Setter
    private String authorities;
    @Setter
    private String businessNum;
    @Setter
    private String role;

    public UserDto(Long id, String username, String password, int age, String email, String phone, String imagePath, String authorities, String businessNum, String role) {
    }

    public static UserDto fromEntity(UserEntity entity) {
        return new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getAge(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getImagePath(),
                entity.getAuthorities(),
                entity.getBusinessNum(),
                entity.getRole().name()
        );
    }

}
