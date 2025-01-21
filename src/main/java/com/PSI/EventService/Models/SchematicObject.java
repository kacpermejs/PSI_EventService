package com.PSI.EventService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchematicObject {
    @Id
    private long id;
    private String name = "New Schematic Object";

    @ManyToOne
    @JoinColumn(name = "schematicId")
    private VenueSchematic schematic;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private SchematicObject parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SchematicObject> children = new ArrayList<>();

    private String label = "";
    private Boolean showLabel = false;
    private float x;
    private float y;
    private float angle;
    private int layer;
}
