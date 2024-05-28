package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Event;
import com.wad.firstmvc.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

//    @Override
//    public List<Event> findEventsByDateBetween(LocalDateTime startDate, LocalDateTime endDate){
//        return eventRepository.findEventsByDateBetween(startDate, endDate);
//    }

    @Override
    public List<Event> findByType(String type){
        return eventRepository.findByType(type);
    }


}
