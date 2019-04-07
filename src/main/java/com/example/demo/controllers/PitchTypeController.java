package com.example.demo.controllers;

import com.example.demo.dto.response.Response;
import com.example.demo.services.PitchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchTypeController {

    @Autowired
    private PitchTypeService pitchTypeService;

    /**
     * Không xài
     * @return
     */
    @GetMapping(value = "common/get-xxx")
    public Response getxxx(){
        return new Response(200,pitchTypeService.getPitchTypeByDistrictAndName("Cẩm Lệ","Sân 5"),"OK");
    }
}
