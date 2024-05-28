package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
   // List<Event> findAll();
    void save(Event event);
    //List<Event> findEventsByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Event> findByType(String type);
    List<Event> findAll();
}
