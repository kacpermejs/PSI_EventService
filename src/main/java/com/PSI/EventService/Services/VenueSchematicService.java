package com.PSI.EventService.Services;

import com.PSI.EventService.DTOs.SchematicObjectDTO;
import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Models.SchematicObject;
import com.PSI.EventService.Models.VenueSchematic;
import com.PSI.EventService.Repositories.VenueSchematicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VenueSchematicService {

    @Autowired
    private VenueSchematicRepository venueSchematicRepository;

    public VenueSchematicDTO getVenueSchematicById(Long id) {
        VenueSchematic venueSchematic = venueSchematicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VenueSchematic not found"));

        return mapToDTO(venueSchematic);
    }

    private VenueSchematicDTO mapToDTO(VenueSchematic venueSchematic) {
        return VenueSchematicDTO.builder()
                .id(venueSchematic.getId())
                .name(venueSchematic.getName())
                .schematicObjects(venueSchematic.getSchematicObjects()
                        .stream()
                        .filter(obj -> obj.getParent() == null) // Only root objects
                        .map(this::mapToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    private SchematicObjectDTO mapToDTO(SchematicObject obj) {
        return SchematicObjectDTO.builder()
                .id(obj.getId())
                .name(obj.getName())
                .showLabel(obj.getShowLabel())
                .label(obj.getLabel())
                .x(obj.getX())
                .y(obj.getY())
                .angle(obj.getAngle())
                .layer(obj.getLayer())
                .children(obj.getChildren()
                        .stream()
                        .map(this::mapToDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
