package com.example.services;

import com.example.domain.Cargo;
import com.example.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    public Cargo getCargo(Long cargoId) {

        Customer customer = new Customer(1L, "tzs", "jiefanglu", "nanjing", "tzs@163.com");
        Cargo cargo = new Cargo(1L, customer, "computer", 2);

        return cargo;
    }

    public List<Cargo> getCargosByCustomer(Long customerId) {
        return null;
    }

    public void saveCargo(Cargo cargo) {

    }

    public void updateCargo(Cargo cargo) {
    }

    public void deleteCargo(Long cargoId) {
    }
}
