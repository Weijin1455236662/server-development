package com.example.db;

import com.example.domain.Cargo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CargoRepository {
    long count();

    @Cacheable("cargoCache")
    List<Cargo> findRecent();

    List<Cargo> findRecent(int count);

    @Cacheable("cargoCache")
    Cargo findOne(long id);

    @CachePut(value = "cargoCache", key = "#result.id")
    Cargo save(Cargo cargo);

    @Cacheable("cargoCache")
    List<Cargo> findByCustomerId(long customerId);

    @CacheEvict(value = "cargoCache")
    void delete(long id);

    List<Cargo> findAll();
}
