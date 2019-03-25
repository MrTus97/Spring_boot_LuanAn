package com.example.demo.services;

import com.example.demo.dao.models.DistrictModel;
import com.example.demo.dao.repositories.DistrictRepository;
import com.example.demo.dto.DistrictDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService implements IDistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DistrictDTO> getAllDistrict() {
        List<DistrictModel> districtModels = districtRepository.getAllBy();
        return convertModelToDTO(districtModels);
    }

    @Override
    public List<DistrictDTO> convertModelToDTO(List<DistrictModel> districtModels) {
        List<DistrictDTO> districtDTOS = new ArrayList<>();
        for (DistrictModel districtModel: districtModels){
            DistrictDTO districtDTO = new DistrictDTO();
            districtDTO = modelMapper.map(districtModel,districtDTO.getClass());
            districtDTOS.add(districtDTO);
        }
        return districtDTOS;
    }
}
