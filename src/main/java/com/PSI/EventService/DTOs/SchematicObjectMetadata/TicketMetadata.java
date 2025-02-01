package com.PSI.EventService.DTOs.SchematicObjectMetadata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketMetadata implements SchematicObjectMetadata {
    @Override
    public String getType() {
        return "ticket";
    }
    private long id;
    private boolean available;
    private double price;
}
