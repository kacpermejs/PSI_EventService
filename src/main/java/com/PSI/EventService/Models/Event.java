package com.PSI.EventService.Models;

import com.PSI.EventService.Enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_schematic_id")
    private VenueSchematic venueSchematic;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "event")
    private EventPost post;

    @Enumerated(EnumType.ORDINAL)
    private EventStatus status;
    private Timestamp saleStartDate;
    private Timestamp eventStartDate;
    private Timestamp saleEndDate;
}
