package com.PSI.EventService.Controllers;

import com.PSI.EventService.DTOs.EventDetailsDTO;
import com.PSI.EventService.DTOs.EventPostDTO;
import com.PSI.EventService.DTOs.TicketService.EventTicketDTO;
import com.PSI.EventService.Services.EventDetailsService;
import com.PSI.EventService.Services.EventPostService;
import com.PSI.EventService.Services.TicketServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/events")
public class TicketServiceController {

    @Autowired
    private TicketServiceService ticketServiceService;

    @GetMapping("/event_ticket/{eventId}")
    public EventTicketDTO getEventTicket(@PathVariable long eventId) {

        System.out.println("C.........................");

        EventTicketDTO eventTicketDTO = ticketServiceService.getSomeEventInfo(eventId);

        System.out.println("D.........................");

        return eventTicketDTO;
    }

}
