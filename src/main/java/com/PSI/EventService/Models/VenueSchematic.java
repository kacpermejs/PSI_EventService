package com.PSI.EventService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenueSchematic {
    @Id
    private long id;
    private String name;
    @ManyToOne
    private Venue venue;
    @OneToMany(mappedBy = "schematic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SchematicObject> schematicObjects;

    @OneToMany(mappedBy = "schematic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VenueSection> venueSections;

    @OneToMany(mappedBy = "schematic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;
}
