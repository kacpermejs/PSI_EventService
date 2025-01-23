package com.PSI.EventService.Controllers;

import com.PSI.EventService.DTOs.SchematicObjectMetadata.VenueSchematicMetadataExtender;
import com.PSI.EventService.DTOs.TicketDTO;
import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Enums.TicketReservationState;
import com.PSI.EventService.Services.VenueSchematicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/venue-schematic")
public class VenueSchematicController {

    @Autowired
    private VenueSchematicService venueSchematicService;

    @Autowired
    private VenueSchematicMetadataExtender metadataExtender;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public VenueSchematicDTO getVenueSchematic(@PathVariable Long id) {
        VenueSchematicDTO venueSchematic = venueSchematicService.getVenueSchematicById(id);

//        String url = "http://other-microservice/api/" + id;
//        ResponseEntity<List<TicketDTO>> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<TicketDTO>>() {}
//        );

        // List<TicketDTO> tickets = response.getBody();
        var tickets = new ArrayList<TicketDTO>();
        for (long i = 1; i <= 16; i++) {
            TicketDTO ticket = TicketDTO.builder()
                    .id(i)
                    .reservationState(TicketReservationState.Available) // Assuming a default state
                    .seatId(i) // Assuming seatId matches the id for simplicity
                    .price("$50") // Assuming a default price
                    .build();

            tickets.add(ticket);
        }

        metadataExtender.extend(venueSchematic, tickets);

        return venueSchematic;
    }
}

