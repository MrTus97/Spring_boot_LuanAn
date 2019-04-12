package com.example.demo.services;

import com.example.demo.dao.models.OwnerModel;
import com.example.demo.dao.repositories.OwnerRepository;
import com.example.demo.dto.OwnerDTO;
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


    public List<OwnerDTO> getAllOwner() {
        try {
            List<OwnerModel> list = ownerRepository.getAllOwner();
            return convertModelToDTO(list);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public List<OwnerDTO> convertModelToDTO(List<OwnerModel> ownerModels) {
        List<OwnerDTO> ownerDTOS = new ArrayList<>();
        for (OwnerModel ownerModel : ownerModels){
            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO = modelMapper.map(ownerModel,ownerDTO.getClass());
            ownerDTOS.add(ownerDTO);
        }
        return ownerDTOS;
    }

    public List<OwnerDTO> getOwnerById(Long id) {
        List<OwnerModel> ownerModels = ownerRepository.getOwnerModelById(id);
        return convertModelToDTO(ownerModels);
    }

    public List<OwnerDTO> getOwnerByDistrict(String district) {
        List<OwnerModel> ownerModels = ownerRepository.getOwnerModelByDistrict(district);
        return convertModelToDTO(ownerModels);
    }
}
