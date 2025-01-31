package com.PSI.EventService.DTOs.TicketService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SchematicTicketDTO {
    private long id;
    private String name;
    private String label;
    private String seatRow;
    private String seatColumn;
    private String sectionLabel;
}
