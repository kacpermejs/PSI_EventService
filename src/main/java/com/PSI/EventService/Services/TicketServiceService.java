package com.PSI.EventService.Services;

import com.PSI.EventService.DTOs.EventDetailsDTO;
import com.PSI.EventService.DTOs.SchematicObjectDTO;
import com.PSI.EventService.DTOs.TicketService.EventTicketDTO;
import com.PSI.EventService.DTOs.TicketService.SchematicTicketDTO;
import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Models.Venue;
import com.PSI.EventService.Models.VenueSchematic;
import com.PSI.EventService.Repositories.EventRepository;
import com.PSI.EventService.Repositories.VenueSchematicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventDetailsService eventDetailsService;

    @Autowired
    private VenueSchematicService venueSchematicService;


    private void processSchematic(SchematicObjectDTO schematic, List<SchematicTicketDTO> schematicTicketDTOS) {
        SchematicTicketDTO schematicTicketDTO = new SchematicTicketDTO();
        schematicTicketDTO.setId(schematic.getId());
        schematicTicketDTO.setName(schematic.getName());

        schematicTicketDTOS.add(schematicTicketDTO);

        if (schematic.getChildren() != null) {
            for (SchematicObjectDTO child : schematic.getChildren()) {
                processSchematic(child, schematicTicketDTOS);
            }
        }
    }

    public EventTicketDTO getSomeEventInfo(long eventId) {

        EventTicketDTO eventTicketDTO = new EventTicketDTO();

        System.out.println("D.........................");
        // get Event Info
        EventDetailsDTO eventDetailsDTO = eventDetailsService.getEventById(eventId).get();
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
        VenueSchematicDTO venueSchematicDTO = venueSchematicService.getVenueSchematicById(venue_schematic_id);
        List<SchematicObjectDTO> schematicObjects = venueSchematicDTO.getSchematicObjects();

        System.out.println("G.........................");
        System.out.println(venue_schematic_id);
        System.out.println(venueSchematicDTO);
        System.out.println("H.........................");

        List<SchematicTicketDTO> schematicTicketDTOS = new ArrayList<>();

        for (SchematicObjectDTO schematic: schematicObjects) {
            processSchematic(schematic, schematicTicketDTOS);
        }

        eventTicketDTO.setSchematicTicketDTOs(schematicTicketDTOS);

        System.out.println("I.........................");
        System.out.println(eventTicketDTO);
        System.out.println("J.........................");

        return eventTicketDTO;
    }

}
