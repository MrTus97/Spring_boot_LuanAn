package com.example.demo.controllers;

import com.example.demo.dao.models.PairModel;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.PairDTO;
import com.example.demo.dto.response.Response;
import com.example.demo.services.PairService;
import io.swagger.annotations.ApiParam;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PairController {

    @Autowired
    private PairService pairService;

    @GetMapping(value = "/common/get-all-pair")
    public Response getAllPair(@RequestParam int page,
                               @RequestParam int pageSize){
        return pairService.getAllPair(page,pageSize);


    }

    @GetMapping(value = "/personal/get-pair-by-id")
    public Response getPairById(@ApiParam("idCustomer") @RequestParam Long idCustomer,
                                @RequestParam Optional<Integer> page,
                                @RequestParam Optional<Integer> pageSize
    ){
        return pairService.getPairById(idCustomer,page,pageSize);

    }

    /**
     * Đăng bài ghép kèo
     * @param pairModel
     * @return
     */
    @PostMapping(value = "/personal/post-pair")
    public Response postPair(@ApiParam @RequestBody PairModel pairModel){
        JSONObject jsonObject = pairService.postPair(pairModel);
        if (jsonObject != null){
            return new Response(ResultCode.SUCCESS,jsonObject,ResultCode.STR_SUCCESS);
        }else{
            return new Response(ResultCode.BAD_REQUEST,null,ResultCode.STR_BAD_REQUEST);
        }

    }

    @PutMapping(value = "/personal/update-pair")
    public Response updateStatus(@ApiParam("status") @RequestParam String status,
                                 @ApiParam("idPair") @RequestParam Long idPair,
                                 @ApiParam("idCustomer") @RequestParam Long idCustomer){
        return pairService.updateStatus(status, idPair,idCustomer);

    }

}
