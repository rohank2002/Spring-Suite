package com.example.Service;

import com.example.Entity.Reading;

import java.util.List;

public interface ReadingsService {
    List<Reading> findAll();
    Reading findOne(String vin);
    Reading create(Reading reading);
}
