package com.example.demo.controllers;

import com.example.demo.define.ResultCode;
import com.example.demo.dto.response.Response;
import com.example.demo.services.FavoriteAddressService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        return new Response(200,favoriteAddressService.getFavoriteByIdCustomer(idCustomer),"OK");
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
        return new Response(ResultCode.success, favoriteAddressService.favoriteOwner(idCustomer, idOwner),"OK");
    }

    @DeleteMapping(value = "/personal/un-favorite-owner")
    public Response unFavoriteOwner(
        @ApiParam("idFavorite") @RequestParam Long idFavorite
    ){
        return new Response(ResultCode.success,favoriteAddressService.unFavoriteOwner(idFavorite),"OK");
    }

}
