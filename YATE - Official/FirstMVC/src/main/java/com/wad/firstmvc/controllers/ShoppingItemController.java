package com.wad.firstmvc.controllers;
import com.wad.firstmvc.domain.ShoppingItem;
import com.wad.firstmvc.services.ShoppingItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/shoppingItems")
public class ShoppingItemController {
    private final ShoppingItemService shoppingItemService;

    public ShoppingItemController(ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }
    //-populate the model with the retrieved shoppingItems!
    //-select the appropriate view (navigation)
    @GetMapping
    public String viewShoppingItems(Model model){
        model.addAttribute("shoppingItems",shoppingItemService.findAll());
        return "all";
    }

    @GetMapping("/new")
    public String showAddShoppingItemForm(Model model){
        model.addAttribute("shoppingItem",new ShoppingItem());
        return "addshoppingItems";
    }

    @PostMapping("/new")
    public String addShoppingItem(ShoppingItem shoppingItem){
        if(shoppingItem.getId()==null)
            shoppingItem.setId(new Random().nextLong());
        shoppingItemService.save(shoppingItem);
        return "redirect:/all";
    }


    @GetMapping("/findshoppingItems")
    public String showFindShoppingItemForm(Model model)
    {
        return "findshoppingItems";
    }

    @PostMapping("/findshoppingItems")
    public String findShoppingItem(@RequestParam("importance") String importance, Model model) {
        List<ShoppingItem> foundShoppingItem = shoppingItemService.findByImportance(importance);
        if (!foundShoppingItem.isEmpty()) {
            model.addAttribute("foundShoppingItem", foundShoppingItem);
            return "foundshoppingItem";
        } else {
            model.addAttribute("errorMessage", "ShoppingItem not found");
            return "error";
        }
    }



}
