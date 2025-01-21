package com.PSI.EventService.Services;

import com.PSI.EventService.DTOs.EventPostDTO;
import com.PSI.EventService.Models.EventPost;
import com.PSI.EventService.Repositories.EventPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventPostService {
    @Autowired
    private EventPostRepository eventPostRepository;

    public List<EventPostDTO> getSortedEventPostDTOs() {
        // Fetch EventPosts sorted by eventStartDate using the JPQL query
        List<EventPost> eventPosts = eventPostRepository.findAllEventPostsSortedByEventStartDate();

        return eventPosts.stream()
                .map(ep -> EventPostDTO.builder()
                        .id(ep.getId())
                        .title(ep.getTitle())
                        .description(ep.getDescription())
                        .location(ep.getLocation())
                        .thumbnailUrl(ep.getThumbnailUrl())
                        .eventStartDate(ep.getEvent().getEventStartDate())
                        .build())
                .collect(Collectors.toList());
    }

}
