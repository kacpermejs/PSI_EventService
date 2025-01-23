package com.PSI.EventService.DTOs;

import com.PSI.EventService.DTOs.SchematicObjectMetadata.SchematicObjectMetadata;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class SchematicObjectDTO {
    private long id;
    private String name;
    private String label;
    private Boolean showLabel;
    private float x;
    private float y;
    private float width;
    private float height;
    private float angle;
    private int layer;
    private List<SchematicObjectDTO> children;

    private List<SchematicObjectMetadata> metadata;
}
