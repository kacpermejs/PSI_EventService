package com.PSI.EventService.Models;

import com.PSI.EventService.Enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Event {
    @Id
    private long id;
    @ManyToOne
    private VenueSchematic venueSchematic;
    private String description;
    private String location;
    @Enumerated(EnumType.ORDINAL)
    private EventStatus status;
    private Timestamp saleStartDate;
    private Timestamp eventStartDate;
    private Timestamp saleEndDate;

    public Event() {}
}
