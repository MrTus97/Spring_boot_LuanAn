package com.example.demo.controllers;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    /**
     * Lấy tất cả các khu vực có trong db
     * @return Danh sách khu vực
     */
    @GetMapping(value = "/common/get-all-district")
    public Response getAllDistrict(){
        List<DistrictDTO> districtDTOList = districtService.getAllDistrict();
        if (districtDTOList != null){
            return new Response(ResultCode.SUCCESS, districtService.getAllDistrict(),"OK");
        }else{
            return new Response(ResultCode.BAD_REQUEST,null,"Bad request");
        }

    }
}
