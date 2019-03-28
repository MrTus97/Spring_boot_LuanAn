package com.example.demo.dao.repositories;

import com.example.demo.dao.models.FavoriteAddressModel;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteAddressRepository extends JpaRepository<FavoriteAddressModel, Long> {
    @Query(value = "select * from favorite_address where id_customer=?1 ",nativeQuery = true)
    public List<FavoriteAddressModel> getFavoriteAddressModelByIdCustomer(Long id);

    @Query(value = "insert into favorite_address values (?1,?2)",nativeQuery = true)
    public boolean addFavoriteAddress(Long idOwner,Long idCustomer);
}
