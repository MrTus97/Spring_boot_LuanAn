package com.example.demo.dao.repositories;
import com.example.demo.dao.models.PitchTypeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PitchTypeRepository extends CrudRepository<PitchTypeModel, Long> {
    List<PitchTypeModel> getAllByName(String name);

    @Query(value = "select * from " +
            "pitch_type inner join owner on pitch_type.id_owner = owner.id " +
            "where owner.district = ?1 " +
            "and pitch_type.name=?2",
            nativeQuery = true)
    List<PitchTypeModel> getAllByDistrictAndName(String district, String type_name);
}
