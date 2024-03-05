package com.example.misson.user.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class ActiveUserDto {
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

}
