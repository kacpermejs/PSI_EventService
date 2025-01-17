package com.PSI.EventService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    private String title;
    private String description;
    private String thumbnailUrl;

    public EventPost() {}
}
