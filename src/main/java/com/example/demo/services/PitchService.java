package com.example.demo.services;

import com.example.demo.dao.models.PitchModel;
import com.example.demo.dao.repositories.PitchRepository;
import com.example.demo.dto.PitchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PitchService implements IPitchBookingService {

    @Autowired
    private PitchRepository pitchRepository;

    @Override
    public List<PitchDTO> getPitch() {
        List<PitchModel> pitchModels = pitchRepository.getAll();
        List<PitchDTO> pitchDTOS = new ArrayList<>();
        for (PitchModel pitchModel: pitchModels){
            PitchDTO pitchDTO = new PitchDTO();
            pitchDTO.setId(pitchModel.getId());
            pitchDTO.setCount(pitchModel.getCount());
            pitchDTO.setId_type(pitchModel.getPitchType());
            pitchDTO.setDescription(pitchModel.getDescription());
            pitchDTO.setIs_use(pitchModel.getIs_use());
            pitchDTO.setName(pitchModel.getName());

            pitchDTOS.add(pitchDTO);
        }
        return pitchDTOS;
    }
}
