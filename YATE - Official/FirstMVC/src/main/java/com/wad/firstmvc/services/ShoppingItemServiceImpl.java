package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.ShoppingItem;
import com.wad.firstmvc.repository.ShoppingItemRepository;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemServiceImpl implements ShoppingItemService {
    private final ShoppingItemRepository shoppingItemRepository;

    public ShoppingItemServiceImpl(ShoppingItemRepository shoppingItemRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
    }

    @Override
    public List<ShoppingItem> findAll(){
        return shoppingItemRepository.findAll();
    }

    @Override
    public ShoppingItem save(ShoppingItem shoppingItem) {
       return shoppingItemRepository.save(shoppingItem);
    }

//    @Override
//    public List<ShoppingItem> findByUserIdAndImportance(Long userId, String importance){
//        return shoppingItemRepository.findByUserIdAndImportance(userId, importance);
//    }

    @Override
    public List<ShoppingItem> findByImportance(String importance){
        return shoppingItemRepository.findByImportance(importance);
    }


}
