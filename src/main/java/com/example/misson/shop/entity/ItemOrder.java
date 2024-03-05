package com.example.misson.shop.entity;

import com.example.misson.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    private Item item;

    @Setter
    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    private String tossPaymentKey;
    private String tossOrderId;
    @Setter
    private String status;

    public static ItemOrder createOrder(Item item, int count) {
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setItem(item);
        itemOrder.setCount(count);
        itemOrder.item.setPrice(item.getPrice());

        item.removeStock(count);
        return itemOrder;
    }

    public int getTotalPrice() {
        return item.getPrice() * count;
    }

}
