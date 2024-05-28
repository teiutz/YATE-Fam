package com.wad.firstmvc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private String store;
    private String importance;
    private boolean status;
    /*
    - Urgent
    - Essential
    - High priority
    - Medium priority
    - Optional
//     */

    @ManyToMany(mappedBy = "shoppingItems")
    private List<User> users;

    public ShoppingItem(String name, int quantity, String store, String importance, boolean status) {
        this.name = name;
        this.quantity = quantity;
        this.store = store;
        this.importance = importance;
        this.status = status;
    }
}
