package com.example.demo.controllers;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.response.Response;
import com.example.demo.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    /**
     * Lấy danh sách tất cả các thời gian có trong db
     * @return
     */
    @GetMapping(value = "/common/get-all-time")
    public Response getAllTime(){
        return new Response(ResultCode.success,timeService.getAllTime(),"OK");
    }


}
