package com.example.demo.services;

import com.example.demo.dao.models.FavoriteAddressModel;
import com.example.demo.dao.repositories.FavoriteAddressRepository;
import com.example.demo.dto.FavoriteAddressDTO;
import com.example.demo.dto.OwnerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FavoriteAddressService implements IFavoriteAddressService {
    @Autowired
    private FavoriteAddressRepository favoriteAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FavoriteAddressDTO> getFavoriteByIdCustomer(String token, Long idUser) {
        List<FavoriteAddressModel> favoriteAddressModels = favoriteAddressRepository.getFavoriteAddressModelByIdCustomer(idUser);
        return convertModelToDTO(favoriteAddressModels);
    }

    @Override
    public List<FavoriteAddressDTO> convertModelToDTO(List<FavoriteAddressModel> favoriteAddressModels) {
        List<FavoriteAddressDTO> favoriteAddressDTOS = new ArrayList<>();
        for (FavoriteAddressModel favoriteAddressModel : favoriteAddressModels){
            FavoriteAddressDTO favoriteAddressDTO = new FavoriteAddressDTO();
            favoriteAddressDTO = modelMapper.map(favoriteAddressModel,favoriteAddressDTO.getClass());
//            favoriteAddressDTO.setId(favoriteAddressModel.getId());
//            favoriteAddressDTO.setOwner(new OwnerDTO("abc","ffkdk"));
            favoriteAddressDTOS.add(favoriteAddressDTO);
        }
        return  favoriteAddressDTOS;
    }
}
