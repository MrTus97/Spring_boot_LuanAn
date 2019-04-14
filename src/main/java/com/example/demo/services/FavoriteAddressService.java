package com.example.demo.services;

import com.example.demo.dao.models.FavoriteAddressModel;
import com.example.demo.dao.repositories.FavoriteAddressRepository;
import com.example.demo.define.Define;
import com.example.demo.dto.FavoriteAddressDTO;
import com.example.demo.rest.CustomAccessDeniedHandler;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
@Service
public class FavoriteAddressService {
    @Autowired
    private FavoriteAddressRepository favoriteAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerService customerService;



    public JSONObject favoriteOwner(Long idCustomer, Long idOwner) {
        try{
            JSONObject jsonObject = new JSONObject();
            FavoriteAddressModel favoriteAddressModel1 = favoriteAddressRepository.getByIdCustomerAndOwner(idCustomer,idOwner);
            if (favoriteAddressModel1==null){
                FavoriteAddressModel favoriteAddressModel = new FavoriteAddressModel();
                favoriteAddressModel.setId_owner(idOwner);
                favoriteAddressModel.setId_customer(idCustomer);
                favoriteAddressRepository.save(favoriteAddressModel);
                jsonObject.put("status","OK");
            }else {
                jsonObject.put("status", "Sân này đã được yêu thích");
            }
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    /**
     * Lấy danh sách sân yêu thích của customer
     * @param idCustomer
     * @return
     */
    public List<FavoriteAddressDTO> getFavoriteByIdCustomer(Long idCustomer) {
        try {
            if (idCustomer == Define.idCustomer){
                List<FavoriteAddressDTO> favoriteAddressDTOS = new ArrayList<>();
                List<FavoriteAddressModel> favoriteAddressModels = favoriteAddressRepository.getFavoriteAddressModelByIdCustomer(idCustomer);
                for (FavoriteAddressModel favoriteAddressModel: favoriteAddressModels) {
                    FavoriteAddressDTO favoriteAddressDTO = new FavoriteAddressDTO();
                    favoriteAddressDTO = modelMapper.map(favoriteAddressModel,favoriteAddressDTO.getClass());
                    favoriteAddressDTOS.add(favoriteAddressDTO);
                }
                return favoriteAddressDTOS;
            }else{
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    /**
     * Xóa yêu thích một sân nào đó theo id
     * @param idFavorite
     * @return
     */
    public JSONObject unFavoriteOwner(Long idFavorite) {
        try {
            Long status = favoriteAddressRepository.deleteFavoriteAddressModelById(idFavorite);
            JSONObject jsonObject = new JSONObject();
            if (status > 0) {
                jsonObject.put("status", status);
            } else {
                jsonObject.put("status", "-1");
            }

            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
