package com.example.demo.dao.repositories;

import com.example.demo.dao.models.FavoriteAddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FavoriteAddressRepository extends CrudRepository<FavoriteAddressModel, Long> {

    /**
     * Lấy danh sách sân yêu thích của một customer nào đó
     * @param idCustomer
     * @return
     */
    @Query(value = "select * from favorite_address where id_customer=?1 order by created_at desc",nativeQuery = true)
    public List<FavoriteAddressModel> getFavoriteAddressModelByIdCustomer(Long idCustomer);

    /**
     * Yêu thích 1 sân nào đó
     * @param idOwner
     * @param idCustomer
     * @return
     */
    @Query(value = "insert into favorite_address values (?1,?2)",nativeQuery = true)
    public boolean addFavoriteAddress(Long idOwner,Long idCustomer);

    /**
     * Xóa yêu thích 1 sân nào đó
     * @param id
     * @return
     */
    @Transactional
    Long deleteFavoriteAddressModelById(Long id);


    /**
     * Lấy danh sách sân yêu thích của một customer nào đó
     * @param idCustomer
     * @return
     */
    @Query(value = "select * from favorite_address where id_customer=?1 and id_owner=?2 order by created_at desc",nativeQuery = true)
    public FavoriteAddressModel getByIdCustomerAndOwner(Long idCustomer,Long idOwner);
}
