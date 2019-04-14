package com.example.demo.controllers;

import com.example.demo.define.ResultCode;
import com.example.demo.dto.FavoriteAddressDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.FavoriteAddressService;
import io.swagger.annotations.ApiParam;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteAddressController {
    @Autowired
    private FavoriteAddressService favoriteAddressService;

    /**
     * Lấy danh sách favorite address dựa vào id customer
     * @param idCustomer
     * @return
     */
    @GetMapping(value = "/personal/get-favorite-by-id-customer")
    public Response getFavoriteByIdCustomer(@RequestParam Long idCustomer
    ){
        List<FavoriteAddressDTO> favoriteAddressDTOS = favoriteAddressService.getFavoriteByIdCustomer(idCustomer);
        if (favoriteAddressDTOS !=null){
            return new Response(ResultCode.SUCCESS,favoriteAddressDTOS,ResultCode.STR_SUCCESS);
        }else{
            return new Response(ResultCode.BAD_REQUEST,null,ResultCode.STR_BAD_REQUEST);
        }

    }

    /**
     * Yêu thích một sân nào đó
     * @param idCustomer
     * @param idOwner
     * @return
     */
    @PostMapping(value = "/personal/favorite-owner")
    public Response favoriteOwner(
            @ApiParam("idUser") @RequestParam Long idCustomer,
            @ApiParam("idOwner")@RequestParam Long idOwner){
        JSONObject jsonObject = favoriteAddressService.favoriteOwner(idCustomer, idOwner);
        if (jsonObject != null){
            return new Response(ResultCode.SUCCESS, jsonObject,"OK");
        }else{
            return new Response(ResultCode.BAD_REQUEST,null,ResultCode.STR_BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "/personal/un-favorite-owner")
    public Response unFavoriteOwner(
        @ApiParam("idFavorite") @RequestParam Long idFavorite
    ){
        JSONObject jsonObject = favoriteAddressService.unFavoriteOwner(idFavorite);
        if (jsonObject != null){
            return new Response(ResultCode.SUCCESS, jsonObject,"OK");
        }else{
            return new Response(ResultCode.BAD_REQUEST,null,ResultCode.STR_BAD_REQUEST);
        }
    }

}
