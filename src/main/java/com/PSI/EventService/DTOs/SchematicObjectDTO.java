package com.PSI.EventService.DTOs;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class SchematicObjectDTO {
    private long id;
    private String name;
    private String label;
    private Boolean showLabel;
    private float x;
    private float y;
    private float angle;
    private int layer;
    private List<SchematicObjectDTO> children;
}
