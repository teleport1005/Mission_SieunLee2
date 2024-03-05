package com.example.misson.shop.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class ItemDtoProj {
    private String name;
    private Integer price;
    private Integer stock;

    @QueryProjection
    public ItemDtoProj(
            String name,
            Integer price,
            Integer stock
    ) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
