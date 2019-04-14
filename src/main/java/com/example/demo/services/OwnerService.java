package com.example.demo.services;

import com.example.demo.dao.models.OwnerModel;
import com.example.demo.dao.repositories.OwnerRepository;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Response getAllOwner() {
        try {
            List<OwnerModel> list = ownerRepository.getAllOwner();
            return new Response(ResultCode.BAD_REQUEST,convertModelToDTO(list),ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }

    public List<OwnerDTO> convertModelToDTO(List<OwnerModel> ownerModels) {
        try {
            List<OwnerDTO> ownerDTOS = new ArrayList<>();
            for (OwnerModel ownerModel : ownerModels){
                OwnerDTO ownerDTO = new OwnerDTO();
                ownerDTO = modelMapper.map(ownerModel,ownerDTO.getClass());
                ownerDTOS.add(ownerDTO);
            }
            return ownerDTOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public Response getOwnerById(Long id) {
        try {
            List<OwnerModel> ownerModels = ownerRepository.getOwnerModelById(id);
            return new Response(ResultCode.SUCCESS,convertModelToDTO(ownerModels),ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }

    public Response getOwnerByDistrict(String district) {
        try {
            List<OwnerModel> ownerModels = ownerRepository.getOwnerModelByDistrict(district);
            if (ownerModels.isEmpty()){
                return new Response(ResultCode.SUCCESS,null,"Không tìm thấy kết quả");
            }
            return new Response(ResultCode.SUCCESS, convertModelToDTO(ownerModels),ResultCode.STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }
}
