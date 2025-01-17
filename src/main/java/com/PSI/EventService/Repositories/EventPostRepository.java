package com.PSI.EventService.Repositories;

import com.PSI.EventService.Models.EventPost;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventPostRepository extends JpaRepository<EventPost, Long> {

    @EntityGraph(attributePaths = {"event"})
    @Query("SELECT ep FROM EventPost ep ORDER BY ep.event.eventStartDate ASC")
    List<EventPost> findAllEventPostsSortedByEventStartDate();
}
