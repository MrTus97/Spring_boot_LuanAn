package com.example.demo.controllers;

import com.example.demo.define.ResultCode;
import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    @GetMapping(value = "/common/get-all-owner")
    public Response getAllOwner(){
        List<OwnerDTO> list = ownerService.getAllOwner();
        return  new Response(200,list,"OK");
    }

    @GetMapping(value = "/get-owner-by-id")
    public Response getOwnerById(@RequestParam Long id) {
        List<OwnerDTO> list = ownerService.getOwnerById(id);
        return new Response(200, list, "OK");
    }

    @GetMapping(value = "/get-owner-by-district")
    public Response getOwnerByName(@RequestParam String district){
        return new Response(ResultCode.success,ownerService.getOwnerByDistrict(district),"OK");
    }
}
