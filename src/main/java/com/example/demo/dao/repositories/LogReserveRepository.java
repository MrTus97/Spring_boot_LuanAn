package com.example.demo.dao.repositories;

import com.example.demo.dao.models.LogReserveModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LogReserveRepository extends CrudRepository<LogReserveModel, Long> {

    @Query(value = "select * from log_reserve where id_time =?2 and date like ?1",nativeQuery = true)
    List<LogReserveModel> getAllByTimeAndDate(String date, Long idTime);

    @Query(value = "select * from log_reserve where id_time =?2 and date like ?1 and id_pitch=?3",nativeQuery = true)
    List<LogReserveModel> getAllByTimeAndDateAndPitch(String date, Long idTime,Long idPitch);

    @Query(value = "select * from log_reserve where id_customer=?1",
            countQuery = "SELECT count(*) FROM log_reserve",nativeQuery = true)
    List<LogReserveModel> getAllById_customer(Long idCustomer, Pageable pageable);

    LogReserveModel getById(Long id);

    @Transactional
    void deleteById(Long id);


}
