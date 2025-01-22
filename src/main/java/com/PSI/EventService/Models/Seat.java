package com.PSI.EventService.Models;

import com.PSI.EventService.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VenueSchematic schematic;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VenueSection venueSection;

    @OneToOne
    @JoinColumn
    private SchematicObject schematicObject;

    @Column(nullable = false)
    private String label;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private SeatType type;

    @Column(name = "seat_row")
    private String row;
    @Column(name = "seat_column")
    private String column;
    private int capacity = 0;
}

