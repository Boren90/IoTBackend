package com.IoTBackend.IoT_Backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.IoTBackend.IoT_Backend.model.HumidityAndTemperature;
import com.IoTBackend.IoT_Backend.repository.HumidityAndTemperatureRepository;

@Service
public class HumidityAndTemperatureService {

    private final HumidityAndTemperatureRepository repository;

    public HumidityAndTemperatureService(HumidityAndTemperatureRepository repository) {

        this.repository = repository;
    }

    public HumidityAndTemperature saveMeasurement(HumidityAndTemperature measurement) {
        
        measurement.setTimestamp(LocalDateTime.now());
        return repository.save(measurement);
    }

    public List<HumidityAndTemperature> getAllMeasurements() {

        return repository.findAll();
    }
}