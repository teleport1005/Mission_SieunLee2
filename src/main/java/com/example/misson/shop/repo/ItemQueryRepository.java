package com.example.misson.shop.repo;

import com.example.misson.shop.dto.ItemSearchParams;
import com.example.misson.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemQueryRepository {
    List<Item> searchDynamic(ItemSearchParams searchParams);

    Page<Item> searchDynamic(ItemSearchParams searchParams, Pageable pageable);
}
