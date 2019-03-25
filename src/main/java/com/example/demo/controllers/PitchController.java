package com.example.demo.controllers;

import com.example.demo.dto.PitchDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PitchController {

    @Autowired
    private PitchService pitchBookingService;

    @GetMapping(value = "/get-pitch")
    public Response getPitch(){
        return new Response(200,pitchBookingService.getPitch(),"OK");
    }




}
