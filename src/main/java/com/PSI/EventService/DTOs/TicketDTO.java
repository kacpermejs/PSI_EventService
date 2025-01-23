package com.PSI.EventService.DTOs;

import com.PSI.EventService.Enums.TicketReservationState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketDTO {
    private long id;
    private TicketReservationState reservationState;
    private long seatId;
    private String price;
}
