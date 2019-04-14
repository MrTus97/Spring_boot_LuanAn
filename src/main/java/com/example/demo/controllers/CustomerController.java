package com.example.demo.controllers;

import com.example.demo.define.ResultCode;
import com.example.demo.dto.response.Response;
import com.example.demo.services.CustomerService;
import com.example.demo.services.JwtService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Đăng nhập với phone và mật khẩu
     * @param phone
     * @param password
     * @return Token và chi tiết customer
     */
    @PostMapping(value = "/common/login")
    public Response login(@ApiParam("phone") @RequestParam String phone, @ApiParam("password") @RequestParam String password){
        if (customerService.checkLogin(phone,password) != null){
            return new Response(ResultCode.SUCCESS,customerService.checkLogin(phone,password),"OK");
        }else{
            return new Response(ResultCode.BAD_REQUEST,null,"Sai tên đăng nhập hoặc mật khẩu");
        }

    }
}
