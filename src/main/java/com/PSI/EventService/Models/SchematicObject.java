package com.PSI.EventService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class SchematicObject {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "schematicId")
    private VenueSchematic schematic;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private SchematicObject parent;
    private float x;
    private float y;
    private float angle;
    private int layer;
}
