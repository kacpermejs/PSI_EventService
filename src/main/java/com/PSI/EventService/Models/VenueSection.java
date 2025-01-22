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
public class VenueSection {
    @Id
    private long id;
    @OneToOne
    private SchematicObject schematicObject;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private VenueSchematic schematic;

    @OneToMany(mappedBy = "venueSection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;

    @Column(nullable = false)
    private String label;

    @Column(nullable = true)
    private Integer capacity = null;
}
