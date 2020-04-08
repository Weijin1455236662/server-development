package com.example.db;

import com.example.domain.Cargo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CargoRepositoryImpl implements CargoRepositoryCustom {

    @PersistenceContext  //并不会真正注入EntityManager，因变它不是线程安全的
    private EntityManager entityManager;

    @Override
    public List<Cargo> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Cargo> findRecent(int count) {
        return (List<Cargo>) entityManager.createQuery("select cg from Cargo cg order by cg.orderDate desc")
                .setMaxResults(count).getResultList();
    }
}
