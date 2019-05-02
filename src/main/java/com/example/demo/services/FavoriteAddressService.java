package com.example.demo.services;

import com.example.demo.dao.models.FavoriteAddressModel;
import com.example.demo.dao.repositories.FavoriteAddressRepository;
import com.example.demo.define.Define;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.FavoriteAddressDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.rest.CustomAccessDeniedHandler;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.sql.Date;
import java.sql.Timestamp;
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



    public Response favoriteOwner(Long idCustomer, Long idOwner) {
        try{
            if (idCustomer != Define.idCustomer){
                return new Response(ResultCode.ACCESS_DENIED,null,ResultCode.STR_ACCESS_DENIED);
            }
            JSONObject jsonObject = new JSONObject();
            FavoriteAddressModel favoriteAddressModel1 = favoriteAddressRepository.getByIdCustomerAndOwner(idCustomer,idOwner);
            if (favoriteAddressModel1==null){
                FavoriteAddressModel favoriteAddressModel = new FavoriteAddressModel();
                favoriteAddressModel.setId_owner(idOwner);
                favoriteAddressModel.setId_customer(idCustomer);
                java.util.Date date = new java.util.Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                favoriteAddressModel.setCreatedAt(timestamp);
                favoriteAddressModel.setUpdateAt(timestamp);
                favoriteAddressRepository.save(favoriteAddressModel);
                jsonObject.put("status","OK");
                return new Response(ResultCode.SUCCESS,jsonObject,ResultCode.STR_SUCCESS);
            }else {
                jsonObject.put("status", "Sân này đã được yêu thích");
                return new Response(ResultCode.SUCCESS,jsonObject,ResultCode.STR_BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }


    }

    /**
     * Lấy danh sách sân yêu thích của customer
     * @param idCustomer
     * @return
     */
    public Response getFavoriteByIdCustomer(Long idCustomer) {
        try {
            if (idCustomer == Define.idCustomer){
                List<FavoriteAddressDTO> favoriteAddressDTOS = new ArrayList<>();
                List<FavoriteAddressModel> favoriteAddressModels = favoriteAddressRepository.getFavoriteAddressModelByIdCustomer(idCustomer);
                for (FavoriteAddressModel favoriteAddressModel: favoriteAddressModels) {
                    FavoriteAddressDTO favoriteAddressDTO = new FavoriteAddressDTO();
                    favoriteAddressDTO = modelMapper.map(favoriteAddressModel,favoriteAddressDTO.getClass());
                    favoriteAddressDTOS.add(favoriteAddressDTO);
                }
                return new Response(ResultCode.SUCCESS,favoriteAddressDTOS,ResultCode.STR_SUCCESS);
            }else{
                return new Response(ResultCode.BAD_REQUEST,null,ResultCode.STR_ACCESS_DENIED);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }


    /**
     * Xóa yêu thích một sân nào đó theo id
     * @param idFavorite
     * @return
     */
    public Response unFavoriteOwner(Long idFavorite,Long idCustomer) {
        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ResultCode.ACCESS_DENIED,null,ResultCode.STR_ACCESS_DENIED);
            }
            Long status = favoriteAddressRepository.deleteFavoriteAddressModelById(idFavorite);
            JSONObject jsonObject = new JSONObject();
            if (status > 0) {
                jsonObject.put("status", "OK");
                return new Response(ResultCode.SUCCESS,jsonObject,ResultCode.STR_SUCCESS);
            } else {
                return new Response(ResultCode.BAD_REQUEST,null,ResultCode.STR_BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new Response(ResultCode.BAD_REQUEST,null,e.getMessage());
        }

    }
}
