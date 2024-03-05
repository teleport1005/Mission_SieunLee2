package com.example.misson.shop.repo;

import com.example.misson.shop.dto.ItemSearchParams;
import com.example.misson.shop.entity.Item;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ItemQueryImpl implements ItemQueryRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Item> searchDynamic(ItemSearchParams searchParams) {
        return null;
    }

    @Override
    public Page<Item> searchDynamic(ItemSearchParams searchParams, Pageable pageable) {
        return null;
    }
}
