package com.PSI.EventService.DTOs.SchematicObjectMetadata;

import com.PSI.EventService.DTOs.SchematicObjectDTO;
import com.PSI.EventService.DTOs.TicketDTO;
import com.PSI.EventService.DTOs.VenueSchematicDTO;
import com.PSI.EventService.Enums.TicketReservationState;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VenueSchematicMetadataExtender {

    public static Map<Long, TicketDTO> convertListToMap(List<TicketDTO> seatAvailability) {
        return seatAvailability.stream()
                .collect(Collectors.toMap(TicketDTO::getSeatId, ticket -> ticket));
    }

    void addSeatAvailability(SchematicObjectDTO obj, Map<Long, TicketDTO> map) {
        obj.getMetadata().stream()
                .filter( d -> d instanceof SeatMetadata )
                .findFirst()
                .ifPresent( e -> {

                    var result = map.get(((SeatMetadata) e).getId());
                    if (result != null) {
                        obj.addMetadata(mapToMetadata(result));
                    }
                });

        obj.getChildren().forEach(c -> addSeatAvailability(c, map));
    }

    private SchematicObjectMetadata mapToMetadata(TicketDTO dto) {
        return TicketMetadata.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .available(dto.getReservationState() == TicketReservationState.Available)
                .build();
    }

    public void extend(VenueSchematicDTO venueSchematic, List<TicketDTO> seatAvailability) {

        var map = convertListToMap(seatAvailability);

        venueSchematic.getSchematicObjects()
                .forEach(obj -> addSeatAvailability(obj, map));
    };

}
