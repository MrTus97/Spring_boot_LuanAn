package com.example.demo.controllers;
import com.example.demo.dto.response.Response;
import com.example.demo.services.LogReserveService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogReserveController {
    @Autowired
    private LogReserveService logReserveService;

    @GetMapping(value = "/common/get-pitch-free-time")
    public Response getPitchFreeTime(@ApiParam("district") @RequestParam String district,
                                     @ApiParam("date") @RequestParam String date,
                                     @ApiParam("time") @RequestParam Long time,
                                     @ApiParam("type") @RequestParam String type){
        return logReserveService.getPitchFreeTime(district,date,time,type);
    }

    @PostMapping(value = "/personal/reserve-pitch")
    public Response reservePitch(@ApiParam("date") @RequestParam String date,
                                  @ApiParam("idCustomer") @RequestParam Long idCustomer,
                                  @ApiParam("idPitch") @RequestParam Long idPitch,
                                  @ApiParam("idPrice") @RequestParam Long idPrice,
                                  @ApiParam("idTime") @RequestParam Long idTime){
        return logReserveService.reservePitch(idCustomer,idPitch,idPrice,idTime,date);
    }

    @GetMapping(value = "/personal/get-reserve")
    public Response getReserve(@ApiParam("idCustomer") @RequestParam Long idCustomer,
                               @ApiParam("page") @RequestParam int page,
                               @ApiParam("pageSize") @RequestParam int pageSize){
        return logReserveService.getLogByIdCustomer(idCustomer,page,pageSize);
    }

    @DeleteMapping(value = "/personal/cancel-reserve")
    public Response cancelReserve(@ApiParam("idCustomer") @RequestParam Long idCustomer,
                                  @ApiParam("idReserve") @RequestParam Long idReserve){
        return logReserveService.cancelReserve(idCustomer,idReserve);
    }
}
