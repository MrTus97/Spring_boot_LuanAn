package com.example.demo.services;

import com.example.demo.dao.models.DistrictModel;
import com.example.demo.dto.DistrictDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDistrictService {
    List<DistrictDTO> getAllDistrict();

    List<DistrictDTO> convertModelToDTO(List<DistrictModel> districtModels);

}
