package com.example.db;

import com.example.domain.Cargo;

import java.util.List;

public interface CargoRepositoryCustom {

    List<Cargo> findRecent();

    List<Cargo> findRecent(int count);
}
