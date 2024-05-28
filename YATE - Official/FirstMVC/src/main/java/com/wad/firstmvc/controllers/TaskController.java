package com.wad.firstmvc.controllers;
import com.wad.firstmvc.domain.Task;
import com.wad.firstmvc.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    //-populate the model with the retrieved tasks!
    //-select the appropriate view (navigation)
    @GetMapping
    public String viewTasks(Model model){
        model.addAttribute("tasks",taskService.findAll());
        return "all";
    }

    @GetMapping("/new")
    public String showAddTaskForm(Model model){
        model.addAttribute("task",new Task());
        return "addtasks";
    }

    @PostMapping("/new")
    public String addTask(Task task){
        if(task.getId()==null)
            task.setId(new Random().nextLong());
        taskService.save(task);
        return "redirect:/all";
    }


    @GetMapping("/findtasks")
    public String showFindTaskForm(Model model)
    {
        return "findtasks";
    }

    @PostMapping("/findtasks")
    public String findTask(@RequestParam("importance") String importance, Model model) {
        List<Task> foundTask = taskService.findByImportance(importance);
        if (!foundTask.isEmpty()) {
            model.addAttribute("foundTask", foundTask);
            return "foundtask";
        } else {
            model.addAttribute("errorMessage", "Task not found");
            return "error";
        }
    }



}
