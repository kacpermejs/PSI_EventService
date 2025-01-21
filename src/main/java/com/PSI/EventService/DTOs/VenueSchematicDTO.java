package com.PSI.EventService.DTOs;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class VenueSchematicDTO {
    private long id;
    private String name;
    private List<SchematicObjectDTO> schematicObjects;
}
