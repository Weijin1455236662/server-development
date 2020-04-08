package com.example.controllers;

import com.example.domain.Cargo;
import com.example.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/customers/{customerId}/cargos")
public class CargoServiceController {
    @Autowired
    private CargoService cargoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cargo> getCargos(@PathVariable("customerId") Long customerId) {
        System.out.println("===getCargos=== RequestMethod=GET");
        return null;
    }

    @RequestMapping(value = "/{cargoId}", method = RequestMethod.GET)
    public Cargo getCargo(@PathVariable("customerId") Long customerId,
                          @PathVariable("cargoId") Long cargoId) {
        System.out.println("===getCargo=== RequestMethod=GET");
        return cargoService.getCargo(cargoId);
    }

    @RequestMapping(value = "{cargoId}", method = RequestMethod.PUT)
    public String updateCargo(@PathVariable("cargoId") Long cargoId) {
        System.out.println("===updateCargo=== RequestMethod=PUT");
        return String.format("This is the put");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveCargo(@RequestBody Cargo cargo) {
        System.out.println("===saveCargo=== RequestMethod=POST");
    }

    @RequestMapping(value = "{cargoId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCargo(@PathVariable("cargoId") Long cargoId) {
        System.out.println("===deleteCargo=== RequestMethod=DELETE");
        return;
    }
}
