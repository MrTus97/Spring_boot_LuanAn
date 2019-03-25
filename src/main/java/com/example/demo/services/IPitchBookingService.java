package com.example.demo.services;

import com.example.demo.dao.models.OwnerModel;
import com.example.demo.dao.models.PitchModel;
import com.example.demo.dto.FavoriteAddressDTO;
import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.PitchDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPitchBookingService {
    public List<PitchDTO> getPitch();
}
