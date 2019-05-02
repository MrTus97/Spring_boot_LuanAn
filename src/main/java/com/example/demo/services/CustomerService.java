package com.example.demo.services;

import com.example.demo.dao.models.CustomerModel;
import com.example.demo.dao.repositories.CustomerRepository;
import com.example.demo.define.Define;
import com.example.demo.define.ResultCode;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.response.Response;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.define.ResultCode.*;

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

    public Response createAccount(String phone, String name, String teamName, String password) {
        try {
            CustomerModel customerModel = customerRepository.getByPhone(phone);
            if (customerModel != null){
                return new Response(BAD_REQUEST,null,"Số điện thoại đăng kí đã tồn tại");
            }else{
                CustomerModel customerModel1 = new CustomerModel();
                customerModel1.setPhone(phone);
                customerModel1.setName(name);
                customerModel1.setTeam_name(teamName);
                customerModel1.setPassword(password);
                customerModel1.setVerify(Define.STR_NO);
                customerModel1.setIs_block(Define.STR_NO);
                customerModel1.setIs_delete(Define.STR_NO);
                customerModel1.setCount_cancel(Define.DEFAULT_NONE);
                customerModel1.setCount_reserve(Define.DEFAULT_NONE);
                customerModel1.setLevel("0");
                customerModel1.setStar("0");
                customerRepository.save(customerModel1);
                return new Response(ResultCode.SUCCESS,"Đăng kí thành công",ResultCode.STR_SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Response(BAD_REQUEST,null,e.getMessage());
        }
    }

    public Response verifyAccount(Long idCustomer) {
        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ACCESS_DENIED,null,STR_ACCESS_DENIED);
            }
            CustomerModel customerModel = customerRepository.getById(idCustomer);
            customerModel.setVerify(Define.STR_YES);
            customerRepository.save(customerModel);
            return new Response(SUCCESS,"OK",STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(BAD_REQUEST,null,e.getMessage());
        }
    }

    public Response updateAccount(Long idCustomer, String name, String teamName, String description) {
        try {
            if (idCustomer != Define.idCustomer){
                return new Response(ACCESS_DENIED,null,STR_ACCESS_DENIED);
            }
            CustomerModel customerModel = customerRepository.getById(idCustomer);
            customerModel.setTeam_name(teamName);
            customerModel.setName(name);
            customerModel.setDescription(description);
            customerRepository.save(customerModel);
            return new Response(SUCCESS,"OK",STR_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(BAD_REQUEST,null,e.getMessage());
        }
    }
}
