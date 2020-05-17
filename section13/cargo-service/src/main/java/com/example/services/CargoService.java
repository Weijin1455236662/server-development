package com.example.services;

import com.example.clients.CustomerDiscoveryClient;
import com.example.clients.CustomerFeignClient;
import com.example.clients.CustomerRestTemplateClient;
import com.example.config.ServiceConfig;
import com.example.db.CargoRepository;
import com.example.domain.Cargo;
import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    ServiceConfig config;

    @Autowired
    CustomerDiscoveryClient customerDiscoveryClient;

//    @Autowired
//    CustomerRestTemplateClient customerRestTemplateClient;

//    @Autowired
//    CustomerFeignClient customerFeignClient;

    public Cargo getCargo(Long customerId, Long cargoId) {
        Cargo cargo = cargoRepository.findOne(cargoId);
        cargo.setProduct(config.getExampleProduct());

        Customer customer = customerDiscoveryClient.getCustomer(customerId);

        cargo.setName(customer.getName());
        cargo.setAddress(customer.getAddress());
        cargo.setCity(customer.getCity());
        cargo.setEmail(customer.getEmail());

        return cargo;
    }

    public List<Cargo> getCargosByCustomer(Long customerId) {
        return cargoRepository.findByCustomer(customerId);
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
