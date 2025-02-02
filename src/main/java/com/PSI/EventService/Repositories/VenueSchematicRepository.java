package com.PSI.EventService.Repositories;

import com.PSI.EventService.Models.VenueSchematic;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VenueSchematicRepository extends JpaRepository<VenueSchematic, Long> {

    @EntityGraph(attributePaths = {"venueSections.seats"})
    @Query(
            value = "SELECT vs.* FROM venue_schematic vs WHERE vs.id = (SELECT e.venue_schematic_id FROM event e WHERE e.id = :eventId)",
            nativeQuery = true)
    Optional<VenueSchematic> findByEvent_Id(@Param("eventId") Long eventId);
}
