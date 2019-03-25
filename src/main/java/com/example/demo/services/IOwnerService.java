package com.example.demo.services;

import com.example.demo.dao.models.OwnerModel;
import com.example.demo.dto.OwnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOwnerService {
    public List<OwnerDTO> getAllOwner();

    public List<OwnerDTO> convertModelToDTO(List<OwnerModel> ownerModels);

    List<OwnerDTO> getOwnerById(Long id);
    public List<OwnerDTO> getOwnerByDistrict(String district);
}
