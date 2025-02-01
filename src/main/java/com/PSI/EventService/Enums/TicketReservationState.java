package com.PSI.EventService.Enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TicketReservationState {
    @JsonProperty("RESERVED")
    Reserved,
    @JsonProperty("UNRESERVED")
    Available,
    @JsonProperty("PAID")
    Paid
}
