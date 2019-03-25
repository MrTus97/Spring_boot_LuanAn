package com.example.demo.dao.repositories;

import com.example.demo.dao.models.OwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerModel, Long> {
    @Query(value = "select * from owner",nativeQuery = true)
    public List<OwnerModel> getAllOwner();

    @Query(value = "select * from owner where id =?1",nativeQuery = true)
    public List<OwnerModel> getOwnerModelById(Long id);

    public List<OwnerModel> getOwnerModelByDistrict(String district);
}
