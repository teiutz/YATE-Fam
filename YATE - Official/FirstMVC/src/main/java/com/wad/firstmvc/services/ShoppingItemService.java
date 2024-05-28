package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.ShoppingItem;

import java.util.List;

public interface ShoppingItemService {
    ShoppingItem save(ShoppingItem shoppingItem);
   // List<ShoppingItem> findByUserId(Long userId);
    List<ShoppingItem> findByImportance(String importance);
    //List<ShoppingItem> findByUserIdAndImportance(Long userId, String importance);
    List<ShoppingItem> findAll();
}
