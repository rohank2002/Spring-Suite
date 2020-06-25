package com.example.Controller;

import com.example.Entity.Reading;
import com.example.Entity.Vehicle;
import com.example.Repository.AlertRepo;
import com.example.Repository.VehicleRepo;
import com.example.Service.ReadingsService;
import com.example.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/readings")
@CrossOrigin(origins = {"http://mocker.egen.io", "http://mocker.egen.academy"})
public class ReadingsController {
    @Autowired
    private ReadingsService readingsService;
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    AlertRepo alertRepo;

    @PostMapping(consumes = "application/json",produces = "application/json")
    public Reading create(@RequestBody Reading reading){
            return readingsService.create(reading);
    }
    @GetMapping(produces = "application/json")
    public List<Reading> findAll(){
        return  readingsService.findAll();
    }
    @GetMapping(path = "/vin/{vin}",produces = "application/json")
    public List<Reading> findReadingByVin(@PathVariable("vin") String vin){
        return readingsService.findReadingByVin(vin);
    }
}
