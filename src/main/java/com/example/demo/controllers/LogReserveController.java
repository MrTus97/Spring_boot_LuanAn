package com.example.demo.controllers;
import com.example.demo.services.LogReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogReserveController {
    @Autowired
    private LogReserveService logReserveService;


}
