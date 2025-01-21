package com.PSI.EventService.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventPost {
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id") // Foreign key column for the Event entity
    private Event event;

    @ManyToMany
    private Tag[] tags;

    @ManyToMany
    private Performer[] performers;

    private String title;
    private String description;
    private String location;
    private String thumbnailUrl;
}
