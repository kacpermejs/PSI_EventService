package com.PSI.EventService.Services;

import com.PSI.EventService.DTOs.EventDetailsDTO;
import com.PSI.EventService.DTOs.SchematicObjectDTO;
import com.PSI.EventService.DTOs.TicketService.EventTicketDTO;
import com.PSI.EventService.DTOs.TicketService.SchematicTicketDTO;
import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Models.Venue;
import com.PSI.EventService.Models.VenueSchematic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceService {

    @Autowired
    EventDetailsService eventDetailsService;

    @Autowired
    private SeatService seatService;

    public EventTicketDTO getSomeEventInfo(long eventId) {

        EventTicketDTO eventTicketDTO = new EventTicketDTO();

        System.out.println("D.........................");
        // get Event Info
        EventDetailsDTO eventDetailsDTO = eventDetailsService.getEventById(eventId).orElseThrow();
        eventTicketDTO.setEventName(eventDetailsDTO.getTitle());
        eventTicketDTO.setEventStart(eventDetailsDTO.getEventStartDate());

        VenueSchematic venueSchematic = eventDetailsDTO.getVenueSchematic();
        Venue venue = venueSchematic.getVenue();

        eventTicketDTO.setVenueName(venue.getName());
        eventTicketDTO.setVenueFacilityName(venue.getEventFacility().getName());
        eventTicketDTO.setVenueAddress(venue.getEventFacility().getAddress());

        System.out.println("E.........................");
        System.out.println(eventTicketDTO);
        System.out.println("F.........................");

        // get schematic info
        long venue_schematic_id = eventDetailsDTO.getVenueSchematic().getId();
        var seats = seatService.getSeatsBySchematicId(venue_schematic_id);

        List<SchematicTicketDTO> schematicTicketDTOS = new ArrayList<>();

        seats.forEach((seat) -> {
            schematicTicketDTOS.add(SchematicTicketDTO.builder()
                    .id(seat.getId())
                    .name(seat.getName())
                    .label(seat.getLabel())
                    .seatRow(seat.getRow())
                    .seatColumn(seat.getColumn())
                    .sectionLabel(seat.getVenueSection().getLabel())
                    .build());
        });

        eventTicketDTO.setSchematicTicketDTOs(schematicTicketDTOS);

        return eventTicketDTO;
    }

}
