package com.PSI.EventService.Repositories;

import com.PSI.EventService.Models.VenueSchematic;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenueSchematicRepository extends JpaRepository<VenueSchematic, Long> {

    @EntityGraph(attributePaths = {"venueSections.seats"})
    Optional<VenueSchematic> findById(Long id);
}
