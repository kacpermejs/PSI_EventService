package com.PSI.EventService.DTOs.TicketService;

import com.PSI.EventService.Models.Address;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Data
public class EventTicketDTO {

    private String eventName;
    private Timestamp eventStart;
    private String venueName;
    private String venueFacilityName;
    private Address venueAddress;
    private List<SchematicTicketDTO> schematicTicketDTOs;

}
