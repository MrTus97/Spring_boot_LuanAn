package com.example.demo.controllers;

import com.example.demo.define.ResultCode;
import com.example.demo.dto.response.Response;
import com.example.demo.services.CustomerService;
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

    @PostMapping(value = "/common/create-account")
    public Response createAccount(@ApiParam("phone") @RequestParam String phone,
                                  @ApiParam("name") @RequestParam String name,
                                  @ApiParam("teamName") @RequestParam String teamName,
                                  @ApiParam("password") @RequestParam String password){
        return customerService.createAccount(phone,name,teamName,password);
    }

    @PutMapping(value = "/personal/verify-account")
    public Response verifyAccount(@ApiParam("idCustomer") @RequestParam Long idCustomer){
        return customerService.verifyAccount(idCustomer);
    }

    @PutMapping(value = "/personal/update-account")
    public Response updateAccount(@ApiParam("idCustomer") @RequestParam Long idCustomer,
                                  @ApiParam("name") @RequestParam String name,
                                  @ApiParam("teamName") @RequestParam String teamName,
                                  @ApiParam("description") @RequestParam String description){
        return customerService.updateAccount(idCustomer,name,teamName,description);
    }

}
