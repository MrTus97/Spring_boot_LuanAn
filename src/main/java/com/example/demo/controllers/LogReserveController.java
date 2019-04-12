package com.example.demo.controllers;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.PitchDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.LogReserveService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogReserveController {
    @Autowired
    private LogReserveService logReserveService;

    @GetMapping(value = "/common/get-pitch-free-time")
    public Response getPitchFreeTime(@ApiParam("district") @RequestParam String district,
                                     @ApiParam("date") @RequestParam String date,
                                     @ApiParam("time") @RequestParam String time,
                                     @ApiParam("type") @RequestParam String type){
        List<PitchDTO> list = logReserveService.getPitchFreeTime(district,date,time,type);
        if (list != null) {
            return new Response(200, list, "OK");
        }else{
            return new Response(ResultCode.BAD_REQUEST,list,"Bad Request");
        }
    }
}
