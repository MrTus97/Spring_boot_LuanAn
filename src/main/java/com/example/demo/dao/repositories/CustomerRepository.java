package com.example.demo.dao.repositories;

import com.example.demo.dao.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    public CustomerModel getByPhone(String phone);

    CustomerModel getByPhoneAndPassword(String phone, String password);
}
