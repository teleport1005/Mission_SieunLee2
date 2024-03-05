package com.example.misson.shop.service;


import com.example.misson.shop.dto.ItemDto;
import com.example.misson.shop.entity.Item;
import com.example.misson.shop.entity.Shop;
import com.example.misson.shop.repo.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public Item registerItem(Item entity, Shop shop) {
        Item item = new Item();
        item.setName(entity.getName());
        item.setImagePath(entity.getImagePath());
        item.setDescription(entity.getDescription());
        item.setPrice(entity.getPrice());
        item.setCategory(entity.getCategory());
        item.setSubCategory(entity.getSubCategory());
        item.setStock(entity.getStock());
        item.setShop(shop);

        return itemRepository.save(item);
    }

    public Item updateItem(Long itemId, Item item) {
        Item itemEntity = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + itemId));

        item.setName(item.getName());
        item.setDescription(item.getDescription());
        item.setPrice(item.getPrice());
        item.setCategory(item.getCategory());
        item.setSubCategory(item.getSubCategory());
        item.setStock(item.getStock());

        return itemRepository.save(itemEntity);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
