package com.example.demo.controllers;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.response.Response;
import com.example.demo.services.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistrictController {

    @Autowired
    private IDistrictService districtService;

    @GetMapping(value = "/common/get-all-district")
    public Response getAllDistrict(){
        return new Response(ResultCode.success, districtService.getAllDistrict(),"OK");
    }
}
