package com.example.Controller;

import com.example.Entity.Alert;
import com.example.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @GetMapping(path = "/vin/{vin}",produces = "application/json")
    public List<Alert> findAlertsByVin(@PathVariable("vin") String vin){
    return alertService.findByVin(vin);
    }
    @GetMapping(path = "/priority/{priority_type}",produces = "application/json")
    public List<Alert> findAlertsByPriority(@PathVariable("priority_type") String priority){
        return  alertService.findAlertsByPriority(priority);
    }
}
