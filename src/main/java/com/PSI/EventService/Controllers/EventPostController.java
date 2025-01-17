package com.PSI.EventService.Controllers;

import com.PSI.EventService.DTOs.EventPostDTO;
import com.PSI.EventService.Services.EventPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventPostController {

    @Autowired
    private EventPostService eventPostService;

    @GetMapping("/event-posts")
    public List<EventPostDTO> getEventPosts() {
        return eventPostService.getSortedEventPostDTOs();
    }
}
