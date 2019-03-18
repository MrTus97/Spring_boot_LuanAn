package com.example.demo.controllers;

import com.example.demo.dao.repositories.PitchRepository;
import com.example.demo.dto.PitchDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.PitchBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PitchController {
    @Autowired
    private PitchRepository pitchRepository;

    private PitchBookingService pitchBookingService;

    public PitchController(PitchBookingService pitchBookingService) {
        this.pitchBookingService = pitchBookingService;
    }

    @GetMapping(value = "/get_pitch")
    public Response<PitchDTO> getPitch(){
        List<PitchDTO> list = pitchBookingService.getPitch();
        return new Response(true,list,"OK");
    }
    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
