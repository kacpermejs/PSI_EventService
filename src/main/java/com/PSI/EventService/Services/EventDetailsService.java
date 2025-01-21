package com.PSI.EventService.Services;

import com.PSI.EventService.DTOs.EventDetailsDTO;
import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Models.EventFacility;
import com.PSI.EventService.Models.Venue;
import com.PSI.EventService.Models.VenueSchematic;
import com.PSI.EventService.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventDetailsService {
    @Autowired
    EventRepository eventRepository;

    public Optional<EventDetailsDTO> getEventById(long id) {
        return eventRepository.findById(id).map(obj -> {
            return EventDetailsDTO.builder()
                    .id(obj.getId())
                    .title(obj.getPost().getTitle())
                    .description(obj.getPost().getDescription())
                    .location(obj.getPost().getLocation())
                    .status(obj.getStatus())
                    .saleStartDate(obj.getSaleStartDate())
                    .saleEndDate(obj.getSaleEndDate())
                    .eventStartDate(obj.getEventStartDate())
                    .venueSchematic(VenueSchematic.builder()
                            .id(obj.getVenueSchematic().getId())
                            .name(obj.getVenueSchematic().getName())
                            //.schematicObjects(obj.getVenueSchematic().getSchematicObjects()) // we don't want that but entity graph did not make it disappear
                            .venue(Venue.builder()
                                    .id(obj.getVenueSchematic().getVenue().getId())
                                    .name(obj.getVenueSchematic().getVenue().getName())
                                    .eventFacility(EventFacility.builder()
                                            .id(obj.getVenueSchematic().getVenue().getEventFacility().getId())
                                            .name(obj.getVenueSchematic().getVenue().getEventFacility().getName())
                                            .address(obj.getVenueSchematic().getVenue().getEventFacility().getAddress())
                                            .build())
                                    .build())
                            .build())
                    .build();
        });
    }
}
