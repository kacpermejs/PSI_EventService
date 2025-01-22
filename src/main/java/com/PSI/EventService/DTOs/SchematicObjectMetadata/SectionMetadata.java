package com.PSI.EventService.DTOs.SchematicObjectMetadata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SectionMetadata implements SchematicObjectMetadata {
    private long id;
    private String label;
    private Integer capacity = null;

    @Override
    public String getType() {
        return "section";
    }
}
