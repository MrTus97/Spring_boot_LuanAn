package com.example.demo.controllers;

import com.example.demo.dto.FavoriteAddressDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.FavoriteAddressService;
import com.example.demo.services.IFavoriteAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavoriteAddressController {
    @Autowired
    private IFavoriteAddressService favoriteAddressService;

    @GetMapping(value = "/get-favorite-by-id-customer")
    public Response getFavoriteById(@RequestParam Long idUser, @RequestHeader String token){
        return new Response(200,favoriteAddressService.getFavoriteByIdCustomer(token,idUser),"OK");
    }
}
