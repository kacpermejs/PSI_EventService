package com.PSI.EventService.Repositories;

import com.PSI.EventService.DTOs.EventDetailsDTO;
import com.PSI.EventService.Models.Event;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findById(long id);
}
