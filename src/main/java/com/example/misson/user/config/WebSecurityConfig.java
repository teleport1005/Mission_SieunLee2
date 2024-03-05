package com.example.misson.user.config;

import com.example.misson.user.jwt.JwtTokenFilter;
import com.example.misson.user.jwt.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtTokenUtils jwtTokenUtils;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/users/home"
                        )
                        // 모든 사용자 접근 권한 url
                        .permitAll()
                        .requestMatchers(
                                "/users/login",
                                "/users/register"
                        )
                        // 익명 사용자 접근 권한 url
                        .anonymous()

                        .requestMatchers(
                                "/users/my-profile"
                        )
                        // 인증 사용자 접근 권한 url
                        .authenticated()
                )
                // 보안 세션 해제
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(
                        new JwtTokenFilter(
                                jwtTokenUtils
                        ),
                        AuthorizationFilter.class
                );

        return  http.build();
    }
}
