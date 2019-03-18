package com.example.demo.dao.repositories;

import com.example.demo.dao.models.PitchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PitchRepository extends JpaRepository<PitchModel, Long> {
    @Query(value = "select * from pitch",nativeQuery = true)
    List<PitchModel> getAll();
}
