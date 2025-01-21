package com.PSI.EventService.Repositories;

import com.PSI.EventService.Models.SchematicObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchematicObjectRepository extends JpaRepository<SchematicObject, Long> {
}
