package com.wad.firstmvc.repository;

import com.wad.firstmvc.domain.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {

    ShoppingItem save(ShoppingItem shoppingItem);
   // List<ShoppingItem> findByUserId(Long userId);
    List<ShoppingItem> findByImportance(String importance);
    //List<ShoppingItem> findByUserIdAndImportance(Long userId, String importance);

    List<ShoppingItem> findAll();



}
