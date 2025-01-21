package com.PSI.EventService.DTOs;

import com.PSI.EventService.Enums.EventStatus;
import com.PSI.EventService.Models.VenueSchematic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDetailsDTO {
    private long id;
    private String description;
    private String location;
    private EventStatus status;
    private Timestamp saleStartDate;
    private Timestamp eventStartDate;
    private Timestamp saleEndDate;
    private VenueSchematic venueSchematic;
}

