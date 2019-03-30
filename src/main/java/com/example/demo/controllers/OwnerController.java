package com.example.demo.controllers;

import com.example.demo.define.ResultCode;
import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    /**
     * Lấy tất cả các chủ sân có trong db
     * @return Tất cả chủ sân
     */
    @GetMapping(value = "/common/get-all-owner")
    public Response getAllOwner(){
        List<OwnerDTO> list = ownerService.getAllOwner();
        return  new Response(ResultCode.success,list,"OK");
    }

    /**
     * Lấy chi tiết của một sân nào đó
     * @param id: id Owner
     * @return Chi tiết của bảng owner
     */
    @GetMapping(value = "/common/get-owner-by-id")
    public Response getOwnerById(@RequestParam Long id) {
        List<OwnerDTO> list = ownerService.getOwnerById(id);
        return new Response(ResultCode.success, list, "OK");
    }

    /**
     * Lấy danh sách các sân của khu vực nào đó
     * @param district: tên khu vực
     * @return Danh sách các owner
     */
    @GetMapping(value = "/common/get-owner-by-district")
    public Response getOwnerByName(@RequestParam String district){
        return new Response(ResultCode.success,ownerService.getOwnerByDistrict(district),"OK");
    }
}
