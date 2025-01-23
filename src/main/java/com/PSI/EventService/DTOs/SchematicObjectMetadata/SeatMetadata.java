package com.PSI.EventService.DTOs.SchematicObjectMetadata;

import com.PSI.EventService.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SeatMetadata implements SchematicObjectMetadata {
    public static final String TYPE = "seat";

    private long id;
    private String label;
    private String name;
    private SeatType seatType;
    private String row;
    private String column;
    private int capacity = 0;

    SeatMetadata() {}

    @Override
    public String getType() {
        return TYPE;
    }
}
