package com.PSI.EventService.Controllers;

import com.PSI.EventService.DTOs.EventDetailsDTO;
import com.PSI.EventService.DTOs.EventPostDTO;
import com.PSI.EventService.Models.Event;
import com.PSI.EventService.Services.EventDetailsService;
import com.PSI.EventService.Services.EventPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/events")
public class EventPostController {

    @Autowired
    private EventPostService eventPostService;
    @Autowired
    private EventDetailsService eventDetailsService;

    @GetMapping("")
    public List<EventPostDTO> getEventPosts() {
        return eventPostService.getSortedEventPostDTOs();
    }

    @GetMapping("/{id}")
    public EventDetailsDTO getEventDetails(@PathVariable long id) {
        return eventDetailsService.getEventById(id)
                .orElseThrow(() -> new NoSuchElementException("Event with id " + id + " not found"));
    }
}
