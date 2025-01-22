package com.PSI.EventService.Services;

import com.PSI.EventService.DTOs.SchematicObjectDTO;
import com.PSI.EventService.DTOs.SchematicObjectMetadata.SchematicObjectMetadata;
import com.PSI.EventService.DTOs.SchematicObjectMetadata.SeatMetadata;
import com.PSI.EventService.DTOs.SchematicObjectMetadata.SectionMetadata;
import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Models.SchematicObject;
import com.PSI.EventService.Models.Seat;
import com.PSI.EventService.Models.VenueSchematic;
import com.PSI.EventService.Models.VenueSection;
import com.PSI.EventService.Repositories.VenueSchematicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    static class SchematicMappingContext {
        private final Map<Long, VenueSection> sectionMap;
        private final Map<Long, Seat> seatMap;

        public static SchematicMappingContext fromVenueSchematic(VenueSchematic venueSchematic) {
            Map<Long, VenueSection> sectionMap = venueSchematic.getVenueSections()
                    .stream()
                    .collect(Collectors.toMap(s -> s.getSchematicObject().getId(), s -> s));

            Map<Long, Seat> seatMap = venueSchematic.getSeats()
                    .stream()
                    .collect(Collectors.toMap(s -> s.getSchematicObject().getId(), s -> s));

            return new SchematicMappingContext(sectionMap, seatMap);
        }

        public SchematicMappingContext(Map<Long, VenueSection> sectionMap, Map<Long, Seat> seatMap) {
            this.sectionMap = sectionMap;
            this.seatMap = seatMap;
        }

        public VenueSection getSection(Long id) {
            return sectionMap.get(id);
        }

        public Seat getSeat(Long id) {
            return seatMap.get(id);
        }
    }

    private VenueSchematicDTO mapToDTO(VenueSchematic venueSchematic) {

        SchematicMappingContext context = SchematicMappingContext.fromVenueSchematic(venueSchematic);

        return VenueSchematicDTO.builder()
                .id(venueSchematic.getId())
                .name(venueSchematic.getName())
                .schematicObjects(venueSchematic.getSchematicObjects()
                        .stream()
                        .filter(obj -> obj.getParent() == null) // Only root objects
                        .map(obj -> mapToDTO(obj, context))
                        .collect(Collectors.toList()))
                .build();
    }

    private SchematicObjectDTO mapToDTO(SchematicObject obj, SchematicMappingContext context) {
        List<SchematicObjectMetadata> metadata = new ArrayList<>();
        boolean isSection = false;

        VenueSection section = context.getSection(obj.getId());
        if (section != null) {
            metadata.add(convertToSectionDTO(section));
            isSection = true;
        }

        if (!isSection) {
            Seat seat = context.getSeat(obj.getId());
            if (seat != null) {
                metadata.add(convertToSeatDTO(seat));
            }
        }

        // Map the SchematicObject to DTO with children and metadata
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
                        .map(child -> mapToDTO(child, context)) // Recursively map children
                        .collect(Collectors.toList()))
                .metadata(metadata)
                .build();
    }

    private SeatMetadata convertToSeatDTO(Seat seat) {
        return SeatMetadata.builder()
                .id(seat.getId())
                .name(seat.getName())
                .label(seat.getLabel())
                .seatType(seat.getType())
                .row(seat.getRow())
                .column(seat.getColumn())
                .capacity(seat.getCapacity())
                .build();
    }

    private SectionMetadata convertToSectionDTO(VenueSection section) {
        return SectionMetadata.builder()
                .id(section.getId())
                .label(section.getLabel())
                .capacity(section.getCapacity())
                .build();
    }
}
