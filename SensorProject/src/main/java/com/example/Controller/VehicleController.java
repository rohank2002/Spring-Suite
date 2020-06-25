package com.example.Controller;

import com.example.Entity.Vehicle;
import com.example.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/vehicles")
@CrossOrigin(origins = {"http://mocker.egen.io", "http://mocker.egen.academy"})
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PutMapping(consumes = "application/json",produces = "application/json")
    public List<Vehicle> update(@RequestBody  List<Vehicle> vehicleList){
    Iterable<Vehicle> vehicles = vehicleService.update(vehicleList);
    List<Vehicle> result = new ArrayList<>();
    for(Vehicle v : vehicles){
        result.add(v);
    }
    return result;
    }
    @GetMapping(produces = "application/json")
    public List<Vehicle> findAll(){
        return vehicleService.findAll();
    }
    @GetMapping(produces = "application/json",path = "/vin/{vin}")
    public Vehicle findOne(@PathVariable("vin") String vin){
    return vehicleService.findOne(vin);
    }



}
