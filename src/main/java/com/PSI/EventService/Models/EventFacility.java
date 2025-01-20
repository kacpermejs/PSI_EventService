package com.PSI.EventService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class EventFacility {
    @Id
    private long id;
    private String name;
    @OneToOne
    private Address address;
    @OneToMany( mappedBy = "eventFacility",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                orphanRemoval = true)
    private List<Venue> venues;
}
