package com.PSI.EventService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false)
    private String label;

    @Column(nullable = true)
    private Integer capacity = null;
}
