package com.PSI.EventService.Services;

import com.PSI.EventService.DTOs.EventPostDTO;
import com.PSI.EventService.Models.EventPost;
import com.PSI.EventService.Repositories.EventPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventPostService {
    @Autowired
    private EventPostRepository eventPostRepository;

    public List<EventPostDTO> getSortedEventPostDTOs() {
        // Fetch EventPosts sorted by eventStartDate using the JPQL query
        List<EventPost> eventPosts = eventPostRepository.findAllEventPostsSortedByEventStartDate();

        List<EventPostDTO> eventPostDTOs = new ArrayList<>();

        // Map EventPost to EventPostDTO using a traditional loop
        for (EventPost ep : eventPosts) {
            EventPostDTO dto = new EventPostDTO(
                    ep.getId(),
                    ep.getTitle(),
                    ep.getDescription(),
                    ep.getThumbnailUrl(),
                    ep.getEvent().getEventStartDate()
            );
            eventPostDTOs.add(dto);
        }

        return eventPostDTOs;
    }

}
