package com.example.demo.controllers;

import com.example.demo.define.ResultCode;
import com.example.demo.dto.FavoriteAddressDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.FavoriteAddressService;
import com.example.demo.services.IFavoriteAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteAddressController {
    @Autowired
    private IFavoriteAddressService favoriteAddressService;

    @GetMapping(value = "/get-favorite-by-id-customer")
    public Response getFavoriteById(@RequestParam Long idUser, @RequestHeader String token){
        return new Response(200,favoriteAddressService.getFavoriteByIdCustomer(token,idUser),"OK");
    }

    @PostMapping(value = "/favorite-owner",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Response favoriteOwner(@RequestBody Long idUser, @RequestBody Long idOwner){
        return new Response(ResultCode.success, favoriteAddressService.favoriteOwner(idUser, idOwner),"OK");
    }
}
