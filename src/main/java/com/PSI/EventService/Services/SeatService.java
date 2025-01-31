package com.PSI.EventService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.PSI.EventService.Repositories.SeatRepository;
import com.PSI.EventService.Models.Seat;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeatsBySchematicId(Long schematicId) {
        return seatRepository.findBySchematic_Id(schematicId);
    }
}
