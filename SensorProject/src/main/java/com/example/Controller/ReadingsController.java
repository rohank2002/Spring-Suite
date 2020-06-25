package com.example.Controller;

import com.example.Entity.Reading;
import com.example.Entity.Vehicle;
import com.example.Repository.AlertRepo;
import com.example.Repository.VehicleRepo;
import com.example.Service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/readings")
@CrossOrigin(origins = {"http://mocker.egen.io", "http://mocker.egen.academy"})
public class ReadingsController {
    @Autowired
    private ReadingsService readingsService;
    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    AlertRepo alertRepo;

    @PostMapping(consumes = "application/json",produces = "application/json")
    public Reading create(@RequestBody Reading reading){
        Optional<Vehicle> vehicle = vehicleRepo.findById(reading.getVin());
            return readingsService.create(reading);


    }
}
