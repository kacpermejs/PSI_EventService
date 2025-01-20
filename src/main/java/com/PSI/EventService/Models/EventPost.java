package com.PSI.EventService.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
public class EventPost {
    @Id
    private long id;
    @OneToOne
    private Event event;

    @ManyToMany
    private Tag[] tags;

    @ManyToMany
    private Performer[] performers;

    private String title;
    private String description;
    private String thumbnailUrl;

    public EventPost() {}
}
