package com.example.demo.dao.repositories;
import com.example.demo.dao.models.TimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<TimeModel, Long> {

    @Query(value = "select * from time",nativeQuery = true)
    public List<TimeModel> getAllTime();
}
