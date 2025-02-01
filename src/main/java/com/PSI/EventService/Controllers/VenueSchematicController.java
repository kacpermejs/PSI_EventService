package com.PSI.EventService.Controllers;

import com.PSI.EventService.Clients.TicketClient;
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
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/venue-schematic")
public class VenueSchematicController {

    @Autowired
    private VenueSchematicService venueSchematicService;

    @Autowired
    private VenueSchematicMetadataExtender metadataExtender;

    @Autowired
    private TicketClient ticketClient;

    @GetMapping("/{id}")
    public Mono<VenueSchematicDTO> getVenueSchematic(@PathVariable Long id) {
        // Run both operations in parallel
        Mono<VenueSchematicDTO> venueSchematicMono = Mono.fromCallable(() -> venueSchematicService.getVenueSchematicById(id))
                .subscribeOn(Schedulers.boundedElastic()); // Moves to a separate thread

        Mono<List<TicketDTO>> ticketsMono = ticketClient.findAllById(id)
                .subscribeOn(Schedulers.boundedElastic()); // API call is already non-blocking

        // Combine results and process them in `metadataExtender`
        return Mono.zip(venueSchematicMono, ticketsMono)
                .map(tuple -> {
                    VenueSchematicDTO venueSchematic = tuple.getT1();
                    List<TicketDTO> tickets = tuple.getT2();
                    metadataExtender.extend(venueSchematic, tickets);
                    return venueSchematic;
                });
    }
}

