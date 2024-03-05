package com.example.misson.shop.service;


import com.example.misson.shop.entity.Shop;
import com.example.misson.shop.repo.ShopRepository;
import com.example.misson.user.entity.UserEntity;
import com.example.misson.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;


    // Shop Open
    public void createShop(Shop shop, Long userId) {
        UserEntity businessUser = userRepository.findById(userId)
                .orElseThrow();

        shopRepository.save(Shop.builder()
                .name(shop.getName())
                .description(shop.getDescription())
                .businessUser(businessUser)
                .build());
    }
}
