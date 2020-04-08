package com.example.db;

import com.example.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long>, CargoRepositoryCustom {
    //    long count();
//
//    List<Cargo> findRecent();
//
//    List<Cargo> findRecent(int count);
//
//    Cargo findOne(long id);
//
//    Cargo save(Cargo cargo);
//
    List<Cargo> findByCustomerIdOrderByOrderDateDesc(long customerId);
//
//    void delete(long id);
//
//    List<Cargo> findAll();

//    @Query("select cg from Cargo cg order by cg.orderDate desc")
//    List<Cargo> getThings();
};
