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


    @Query(value = "select * from pair where pair = 'YES' order by created_at desc",
    countQuery = "select count(*) from pair",
    nativeQuery = true)
    List<PairModel> getAllByPairOderOrderByCreatedAtDesc(Pageable pageable);

    @Query(value = "SELECT * FROM pair WHERE id_customer = ?1 order by created_at desc",
            countQuery = "SELECT count(*) FROM pair",
            nativeQuery = true)
    List<PairModel> getAllByIdCustomer(Long id, Pageable pageable);

    PairModel getById(Long id);


}
