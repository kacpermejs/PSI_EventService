package com.PSI.EventService.Clients;

import com.PSI.EventService.DTOs.TicketDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TicketClient {
    @GetExchange("/tickets/events_availability/{id}")
    Mono<List<TicketDTO>> findAllById(@PathVariable Long id);
}
