package com.example.demo.controllers;

import com.example.demo.dto.response.Response;
import com.example.demo.services.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PitchController {

    @Autowired
    private PitchService pitchBookingService;

    /**
     * Không xài
     * @return
     */
    @GetMapping(value = "/common/get-pitch")
    public Response getPitch(
//            @ApiParam("id_pitch_type") @RequestParam Long id_pitch_type
    ){
        return new Response(200,pitchBookingService.getPitchByDistrictAndName(),"OK");
    }




}
