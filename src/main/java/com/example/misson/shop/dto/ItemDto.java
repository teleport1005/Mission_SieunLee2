package com.example.misson.shop.dto;


import com.example.misson.shop.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ItemDto {
    private String name;
    private Integer price;
    private Integer stock;

    public ItemDto(
            String name,
            Integer price,
            Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static ItemDto fromEntity(Item entity) {
        return new ItemDto(
                entity.getName(),
                entity.getPrice(),
                entity.getStock()
        );
    }

}
