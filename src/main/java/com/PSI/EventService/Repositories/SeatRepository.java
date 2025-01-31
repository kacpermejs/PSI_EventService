package com.PSI.EventService.Repositories;

import com.PSI.EventService.Models.Seat;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @EntityGraph(attributePaths = {"venueSection"})
    List<Seat> findBySchematic_Id(Long schematicId);
}
