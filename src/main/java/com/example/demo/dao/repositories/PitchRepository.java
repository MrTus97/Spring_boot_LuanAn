package com.example.demo.dao.repositories;

import com.example.demo.dao.models.OwnerModel;
import com.example.demo.dao.models.PitchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PitchRepository extends CrudRepository<PitchModel, Long> {
    @Query(value = "select * from pitch",nativeQuery = true)
    public  List<PitchModel> getAll();

    @Query(value = "select * " +
            "from pitch inner join pitch_type on pitch.id_type = pitch_type.id " +
            "where pitch_type.id =?1",
            nativeQuery = true)
    List<PitchModel> getAllByPitchTypeId(Long id);

    @Query(value = "select pitch.* from " +
            "pitch_type inner join owner on pitch_type.id_owner = owner.id " +
            "inner join pitch on pitch.id_type = pitch_type.id " +
            "where owner.district = ?1 " +
            "and pitch_type.name=?2",
            nativeQuery = true)
    List<PitchModel> getAllByDistrictAndName(String district, String type_name);


}
