package com.example.misson.shop.entity;

import com.example.misson.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Shop extends Base{
    // 쇼핑몰 이름과 쇼핑몰 정보(설명)
    private String name;
    private String description;

    @OneToOne
    private UserEntity businessUser;

}
