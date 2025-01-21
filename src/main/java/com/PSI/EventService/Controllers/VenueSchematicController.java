package com.PSI.EventService.Controllers;

import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Services.VenueSchematicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venue-schematic")
public class VenueSchematicController {

    @Autowired
    private VenueSchematicService venueSchematicService;

    @GetMapping("/{id}")
    public VenueSchematicDTO getVenueSchematic(@PathVariable Long id) {
        return venueSchematicService.getVenueSchematicById(id);
    }
}
