package com.PSI.EventService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class VenueSchematic {
    @Id
    private long id;
    private String name;
    @ManyToOne
    private Venue venue;
    @OneToMany
    private SchematicObject[] schematicObjects;

    public VenueSchematic() {}
}
