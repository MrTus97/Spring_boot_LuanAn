package com.example.demo.services;

import com.example.demo.dao.models.CustomerModel;
import com.example.demo.dao.repositories.CustomerRepository;
import com.example.demo.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO loadUserByPhone(String phone){
        CustomerModel customerModel = customerRepository.getByPhone(phone);
        if (customerModel != null){
            CustomerDTO customerDTO = new CustomerDTO();
            return modelMapper.map(customerModel,customerDTO.getClass());
        }
        return null;
    }
}
