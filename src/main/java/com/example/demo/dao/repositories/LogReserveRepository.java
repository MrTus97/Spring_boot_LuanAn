package com.example.demo.dao.repositories;

import com.example.demo.dao.models.LogReserveModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogReserveRepository extends CrudRepository<LogReserveModel, Long> {

    @Query(value = "select * from log_reserve where id_time =?3 and date > ?1 and date <= ?2",nativeQuery = true)
    List<LogReserveModel> getAllByTimeAndDate(String date,String dateAfter, Long idTime);

    @Query(value = "select * from log_reserve where id_time =?3 and date > ?1 and date <= ?2 and id_pitch=?4",nativeQuery = true)
    List<LogReserveModel> getAllByTimeAndDateAndPitch(String date,String dateAfter, Long idTime,Long idPitch);
}
