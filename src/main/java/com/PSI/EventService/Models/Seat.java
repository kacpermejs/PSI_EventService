package com.PSI.EventService.Models;

import com.PSI.EventService.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Seat {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "venue_section_id", nullable = false)  // Explicitly name the column
    private VenueSection section;

    @OneToOne
    @JoinColumn(name = "schematic_object_id")  // Explicitly name the column
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

