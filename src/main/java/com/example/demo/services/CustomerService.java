package com.example.demo.services;

import com.example.demo.dao.models.CustomerModel;
import com.example.demo.dao.repositories.CustomerRepository;
import com.example.demo.dto.CustomerDTO;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtService jwtService;

    public CustomerDTO loadUserByPhone(String phone){
        CustomerModel customerModel = customerRepository.getByPhone(phone);
        if (customerModel != null){
            CustomerDTO customerDTO = new CustomerDTO();
            return modelMapper.map(customerModel,customerDTO.getClass());
        }
        return null;
    }



    public JSONObject checkLogin(String phone, String password){
        try {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO = modelMapper.map(customerRepository.getByPhoneAndPassword(phone, password),customerDTO.getClass());
            if (customerDTO != null){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token",jwtService.generateTokenLogin(phone));
                jsonObject.put("customer",customerDTO);
                return jsonObject;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
