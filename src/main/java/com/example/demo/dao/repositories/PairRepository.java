package com.example.demo.dao.repositories;

import com.example.demo.dao.models.PairModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairRepository extends CrudRepository<PairModel, Long> {

    List<PairModel> getAllByStatusOrderByCreatedAt(String status, Pageable pageable);

    @Query(value = "SELECT * FROM pair WHERE id_customer = ?1",
            countQuery = "SELECT count(*) FROM pair",
            nativeQuery = true)
    List<PairModel> getAllByIdCustomer(Long id, Pageable pageable);

    PairModel getById(Long id);


}
