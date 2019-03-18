package com.example.demo.services;

import com.example.demo.dao.models.PitchModel;
import com.example.demo.dto.PitchDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PitchBookingService {
    public List<PitchDTO> getPitch();
}
