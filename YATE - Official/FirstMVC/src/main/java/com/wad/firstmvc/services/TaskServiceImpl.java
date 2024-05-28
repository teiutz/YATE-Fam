package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Task;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findByStatus(boolean status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> findByImportance(String importance){
        return taskRepository.findByImportance(importance);
    }

//    @Override
//    public List<Task> findByUserId(User user){
//        return taskRepository.findByUserId(user);
//    }
}
