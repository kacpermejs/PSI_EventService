package com.PSI.EventService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
public class EventPostDTO {

    private long id;
    private String title;
    private String description;
    private String location;
    private String thumbnailUrl;
    private Timestamp eventStartDate;
}
