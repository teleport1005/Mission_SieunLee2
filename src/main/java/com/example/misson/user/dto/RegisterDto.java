package com.example.misson.user.dto;

import lombok.Data;


// 비활성 회원 권한 분류 dto
@Data
public class RegisterDto {
    private String username;
    private String password;
}
