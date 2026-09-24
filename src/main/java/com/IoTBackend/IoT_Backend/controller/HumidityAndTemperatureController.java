package com.IoTBackend.IoT_Backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IoTBackend.IoT_Backend.model.HumidityAndTemperature;
import com.IoTBackend.IoT_Backend.service.HumidityAndTemperatureService;

@RestController
@RequestMapping("/api/humidity-temperature")
public class HumidityAndTemperatureController {

    private final HumidityAndTemperatureService service;

    public HumidityAndTemperatureController(HumidityAndTemperatureService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HumidityAndTemperature> createMeasurement(@RequestBody HumidityAndTemperature measurement) {
        HumidityAndTemperature savedMeasurement = service.saveMeasurement(measurement);

        return ResponseEntity.ok(savedMeasurement);
    }

    @GetMapping
    public ResponseEntity<List<HumidityAndTemperature>> getAllMeasurements() {

        return ResponseEntity.ok(service.getAllMeasurements());
    }
}