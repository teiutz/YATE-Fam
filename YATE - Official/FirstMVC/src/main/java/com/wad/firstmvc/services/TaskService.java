package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Task;
import com.wad.firstmvc.domain.User;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    //List<Task> findByUserId(User user);
    List<Task> findByStatus(boolean status);
    List<Task> findByImportance(String importance);

    List<Task> findAll();
}
