package com.wad.firstmvc.repository;

import com.wad.firstmvc.domain.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User save(User user);
    User findByUsername(String usernamme);
    //List<User> findByLastName(String lastName);

    List<User> findAll();


}
