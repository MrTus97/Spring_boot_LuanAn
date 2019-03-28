package com.example.demo.services;

import com.example.demo.dao.models.FavoriteAddressModel;
import com.example.demo.dto.FavoriteAddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFavoriteAddressService {
    public List<FavoriteAddressDTO> getFavoriteByIdCustomer(String token, Long idUser);
    public List<FavoriteAddressDTO> convertModelToDTO(List<FavoriteAddressModel> list);

    public boolean favoriteOwner(Long idUser, Long idOwner);
}

