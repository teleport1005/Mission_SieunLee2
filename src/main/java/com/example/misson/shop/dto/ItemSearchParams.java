package com.example.misson.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemSearchParams {
    private String name;
    private Integer priceFloor;
    private Integer priceCeil;
}