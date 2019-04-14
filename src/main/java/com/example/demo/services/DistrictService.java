package com.example.demo.services;

import com.example.demo.dao.models.DistrictModel;
import com.example.demo.dao.repositories.DistrictRepository;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.response.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService{
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Response getAllDistrict() {
        try {
            List<DistrictModel> districtModels = districtRepository.getAllBy();
            return new Response(ResultCode.SUCCESS,convertModelToDTO(districtModels),ResultCode.STR_SUCCESS);
        }catch (Exception e)
        {
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }
    }

    public List<DistrictDTO> convertModelToDTO(List<DistrictModel> districtModels) {
        try {
            List<DistrictDTO> districtDTOS = new ArrayList<>();
            for (DistrictModel districtModel: districtModels){
                DistrictDTO districtDTO = new DistrictDTO();
                districtDTO = modelMapper.map(districtModel,districtDTO.getClass());
                districtDTOS.add(districtDTO);
            }
            return districtDTOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
