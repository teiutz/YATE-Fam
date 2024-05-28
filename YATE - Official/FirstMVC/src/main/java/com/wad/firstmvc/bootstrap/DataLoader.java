package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.Event;
import com.wad.firstmvc.domain.ShoppingItem;
import com.wad.firstmvc.domain.Task;
import com.wad.firstmvc.repository.TaskRepository;
import com.wad.firstmvc.repository.ShoppingItemRepository;
import com.wad.firstmvc.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

  private TaskRepository taskRepository;
  private ShoppingItemRepository shoppingItemRepository;

  private EventRepository eventRepository;

  public DataLoader(TaskRepository taskRepository, ShoppingItemRepository shoppingItemRepository,EventRepository eventRepository ){
    this.taskRepository = taskRepository;
    this.shoppingItemRepository = shoppingItemRepository;
    this.eventRepository = eventRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Event event1 = new Event("Birthday Party", LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 16), "Celebration", "High");
    Event event2 = new Event("Conference", LocalDate.of(2024, 7, 20), LocalDate.of(2024, 7, 22), "Professional", "Medium");
    Event event3 = new Event("Holiday Trip", LocalDate.of(2024, 8, 10), LocalDate.of(2024, 8, 15), "Vacation", "High");
    eventRepository.saveAll(List.of(event1,event2,event3));

    // Example objects for ShoppingItem class
    ShoppingItem item1 = new ShoppingItem("Milk", 2, "Grocery Store", "Essential", false);
    ShoppingItem item2 = new ShoppingItem("Phone Charger", 1, "Electronics Store", "Urgent", false);
    ShoppingItem item3 = new ShoppingItem("Book", 1, "Bookstore", "Optional", true);
    shoppingItemRepository.saveAll(List.of(item1, item2,item3));


    // Example objects for Task class
    Task task1 = new Task("Write Report", "Complete the quarterly report for the board meeting.", LocalDate.of(2024, 6, 30), "High priority", false);
    Task task2 = new Task("Exercise", "Go for a run in the morning.", LocalDate.of(2024, 6, 10), "Medium priority", true);
    Task task3 = new Task("Read Book", "Finish reading 'To Kill a Mockingbird'.", LocalDate.of(2024, 7, 15), "Optional", false);
    taskRepository.saveAll(List.of(task1,task2,task3));

    //System.out.println(p1.toString());
  }
}
