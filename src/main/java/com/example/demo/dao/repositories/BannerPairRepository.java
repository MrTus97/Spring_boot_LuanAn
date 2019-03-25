package com.example.demo.dao.repositories;

import com.example.demo.dao.models.BannerPairModel;
import com.example.demo.dao.models.PairModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerPairRepository extends JpaRepository<BannerPairModel, Long> {
}
