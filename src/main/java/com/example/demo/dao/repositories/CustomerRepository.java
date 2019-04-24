package com.example.demo.dao.repositories;

import com.example.demo.dao.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    CustomerModel getByPhone(String phone);

    @Query(value = "select * from customer where phone = ?1 and password = ?2 and is_block <> 'YES'",nativeQuery = true)
    CustomerModel getByPhoneAndPassword(String phone, String password);

    CustomerModel getById(Long id);
}
