package com.example.misson.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Setter
    private String username;
    @Setter
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
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserEntity(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserEntity(String nickname, String name, int age, String email, String phone, String imagePath, String authorities, String businessNum) {
        this.nickname = nickname;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.imagePath = imagePath;
        this.authorities = authorities;
        this.businessNum = businessNum;
    }
}
