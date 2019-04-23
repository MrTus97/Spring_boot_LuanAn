package com.example.demo.dao.repositories;
import com.example.demo.dao.models.PriceModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<PriceModel, Long> {

    @Query(value = "select * from price where id_time=?2 and id_type = ?1 order by date desc",nativeQuery = true)
    List<PriceModel> getByTimeAndType(Long idPitchType, Long idTime);
}
