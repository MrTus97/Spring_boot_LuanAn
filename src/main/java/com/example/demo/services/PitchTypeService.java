package com.example.demo.services;

import com.example.demo.dao.models.PitchTypeModel;
import com.example.demo.dao.repositories.PitchTypeRepository;
import com.example.demo.dto.PitchTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PitchTypeService {

    @Autowired
    private PitchTypeRepository pitchTypeRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<PitchTypeDTO> getPitchTypeByDistrictAndName(String district, String name){
        List<PitchTypeModel> pitchTypeModels = pitchTypeRepository.getAllByDistrictAndName(district, name);
        return convertModelToDTO(pitchTypeModels);
    }

    public List<PitchTypeDTO> convertModelToDTO(List<PitchTypeModel> pitchTypeModels){
        List<PitchTypeDTO> pitchTypeDTOS = new ArrayList<>();
        for (PitchTypeModel pitchTypeModel:pitchTypeModels){
            PitchTypeDTO pitchTypeDTO = new PitchTypeDTO();
            pitchTypeDTO = modelMapper.map(pitchTypeModel,pitchTypeDTO.getClass());
            pitchTypeDTOS.add(pitchTypeDTO);
        }
        return pitchTypeDTOS;
    }
}
