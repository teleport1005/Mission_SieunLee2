package com.example.misson.shop.service;

import com.example.misson.shop.dto.ItemOrderDto;
import com.example.misson.shop.entity.Item;
import com.example.misson.shop.entity.ItemOrder;
import com.example.misson.shop.entity.Shop;
import com.example.misson.shop.repo.ItemRepository;
import com.example.misson.shop.repo.OrderRepository;
import com.example.misson.user.dto.UserDto;
import com.example.misson.user.entity.UserEntity;
import com.example.misson.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    // 재고 반영
    private final ItemRepository itemRepository;
    // 주문 저장
    private final OrderRepository orderRepository;
    // 고객 주문
    private final UserRepository userRepository;


    public ItemOrderDto itemOrderDto(Long orderId, String username) {
        // 주문 조회
        ItemOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        // 주문에 해당하는 상품 정보 조회
        Item item = itemRepository.findById(order.getItem().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));

        // 주문자 정보 조회
        Optional<UserEntity> user = userRepository.findByUsername(username);

        List<ItemOrder> orderList = new ArrayList<>();

        return null;


    }





}
