package com.example.misson.user.config;

import com.example.misson.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ClientConfig {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // Admin 계정 생성




}
