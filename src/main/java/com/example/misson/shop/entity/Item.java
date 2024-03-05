package com.example.misson.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item extends Base{
    private String name;
    private String imagePath;
    private String description;
    private Integer price;
    private String category;
    private String subCategory;
    private Integer count;
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    public void removeStock(int stock) {
        int restStock = this.stock - count;
        if (restStock < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.stock = restStock;
    }



}
