package com.PSI.EventService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Address {
    @Id
    private long id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String addressLine1;
    @Column(nullable = false)
    private String addressLine2;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String postalCode;

    private String stateOrRegion;
}
