package com.wad.firstmvc.repository;

import com.wad.firstmvc.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    Event save(Event event);
    //List<Event> findByUserId(Long userId);
    //List<Event> findEventsByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    //List<Event> findByUserIdAndDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);

    List<Event> findByType(String type);
    List<Event> findAll();


}
