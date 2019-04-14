package com.example.demo.controllers;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.TimeDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<TimeDTO> list = timeService.getAllTime();
        if (list != null){
            return new Response(ResultCode.SUCCESS,list,"OK");
        }else{
            return new Response(ResultCode.BAD_REQUEST,null,ResultCode.STR_BAD_REQUEST);
        }

    }


}
