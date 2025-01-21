package com.PSI.EventService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private long id;
    @Column(nullable = false)
    private String city;

    //Street Address
    @Column(nullable = false)
    private String addressLine1;
    @Column(nullable = true)
    private String addressLine2; //Optional

    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String postalCode;

    private String stateOrRegion;
}
