package com.example.services;

import com.example.config.ServiceConfig;
import com.example.db.CargoRepository;
import com.example.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    ServiceConfig config;

    public Cargo getCargo(Long cargoId) {
        Cargo cargo = cargoRepository.findOne(cargoId);
        return cargo;
    }

    public List<Cargo> getCargosByCustomer(Long customerId) {
        return cargoRepository.findByCustomerId(customerId);
    }

    public void saveCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    public void updateCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    public void deleteCargo(Long cargoId) {
        cargoRepository.delete(cargoId);
    }
}
