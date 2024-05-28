package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);

   // List<User> findByLastName(String lastName);
    List<User> findAll();
}
