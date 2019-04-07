package com.example.demo.controllers;

import com.example.demo.dao.models.PairModel;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.PairDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.PairService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class PairController {

    @Autowired
    private PairService pairService;

    @GetMapping(value = "/common/get-all-pair", params = {"page", "pageSize"})
    public Response getAllPair(@RequestParam Optional<Integer> page,
                               @RequestParam Optional<Integer> pageSize){
        return new Response(ResultCode.success,pairService.getAllPair(page,pageSize),"OK");
    }

    @GetMapping(value = "/personal/get-pair-by-id")
    public Response getPairById(@ApiParam("idCustomer") @RequestParam Long idCustomer,
                                @RequestParam Optional<Integer> page,
                                @RequestParam Optional<Integer> pageSize
    ){
        return new Response(ResultCode.success, pairService.getPairById(idCustomer,page,pageSize),"OK");
    }

    /**
     * Đăng bài ghép kèo
     * @param pairModel
     * @return
     */
    @PostMapping(value = "/personal/post-pair")
    public Response postPair(@ApiParam @RequestBody PairModel pairModel){
        return new Response(ResultCode.success,pairService.postPair(pairModel),"OK");
    }

    @PutMapping(value = "/personal/update-pair")
    public Response updateStatus(@ApiParam("status") @RequestParam String status,
                                 @ApiParam("idPair") @RequestParam Long idPair){
        return new Response(ResultCode.success,pairService.updateStatus(status, idPair),"OK");
    }

}
