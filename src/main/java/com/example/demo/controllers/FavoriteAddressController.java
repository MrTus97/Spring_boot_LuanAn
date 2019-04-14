package com.example.demo.controllers;

import com.example.demo.dto.response.Response;
import com.example.demo.services.FavoriteAddressService;
import io.swagger.annotations.ApiParam;
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
        return favoriteAddressService.getFavoriteByIdCustomer(idCustomer);
    }

    /**
     * Yêu thích một sân nào đó
     * @param idCustomer
     * @param idOwner
     * @return
     */
    @PostMapping(value = "/personal/favorite-owner")
    public Response favoriteOwner(
            @ApiParam("idCustomer") @RequestParam Long idCustomer,
            @ApiParam("idOwner")@RequestParam Long idOwner){
        return favoriteAddressService.favoriteOwner(idCustomer, idOwner);
    }

    @DeleteMapping(value = "/personal/un-favorite-owner")
    public Response unFavoriteOwner(
        @ApiParam("idFavorite") @RequestParam Long idFavorite,
        @ApiParam("idCustomer") @RequestParam Long idCustomer
    ){
        return favoriteAddressService.unFavoriteOwner(idFavorite,idCustomer);
    }

}
