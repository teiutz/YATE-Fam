package com.wad.firstmvc.controllers;
import com.wad.firstmvc.domain.Event;
import com.wad.firstmvc.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    //-populate the model with the retrieved events!
    //-select the appropriate view (navigation)
    @GetMapping
    public String viewEvents(Model model){
        model.addAttribute("events",eventService.findAll());
        return "all";
    }

    @GetMapping("/new")
    public String showAddEventForm(Model model){
        model.addAttribute("event",new Event());
        return "addevents";
    }

    @PostMapping("/new")
    public String addEvent(Event event){
        if(event.getId()==null)
            event.setId(new Random().nextLong());
        eventService.save(event);
        return "redirect:/all";
    }


    @GetMapping("/findevents")
    public String showFindEventForm(Model model)
    {
        return "findevents";
    }

    @PostMapping("/findevents")
    public String findEvent(@RequestParam("type") String type, Model model) {
        List<Event> foundEvents = eventService.findByType(type);
        if (foundEvents.size() != 0) {
            model.addAttribute("foundEvent", foundEvents);
            return "foundevent";
        } else {
            model.addAttribute("errorMessage", "Event not found");
            return "error";
        }
    }



}
