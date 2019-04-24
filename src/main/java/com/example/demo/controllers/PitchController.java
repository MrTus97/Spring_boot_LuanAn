package com.example.demo.controllers;

import com.example.demo.dto.response.Response;
import com.example.demo.services.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PitchController {

    @Autowired
    private PitchService pitchBookingService;

    @GetMapping(value = "/common/get-all-pitch")
    public Response getAllPitch(@RequestParam int page,
                                @RequestParam int pageSize){
        return pitchBookingService.getAllPitch(page-1,pageSize);
    }
}
