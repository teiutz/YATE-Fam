package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
       return userRepository.save(user);
    }


//    @Override
//   // public List<User> findByLastName(String lastName){
//        return userRepository.findByLastName(lastName);
//    }
}
