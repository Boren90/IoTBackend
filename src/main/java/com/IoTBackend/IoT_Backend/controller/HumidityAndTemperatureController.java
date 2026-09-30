package com.IoTBackend.IoT_Backend.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IoTBackend.IoT_Backend.model.HumidityAndTemperature;
import com.IoTBackend.IoT_Backend.model.MeasurementStatistics;
import com.IoTBackend.IoT_Backend.service.HumidityAndTemperatureService;

@RestController
@RequestMapping("/api/humidity-temperature")
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping("/day")
    public ResponseEntity<List<HumidityAndTemperature>> getMeasurementsForDay(@RequestParam LocalDate date) {

        LocalDateTime start = date.atStartOfDay();// Returnerar LocalDateTime vid midnatt för den angivna dagen
        LocalDateTime end = date.plusDays(1).atStartOfDay();// Returnerar LocalDateTime vid midnatt för nästa dag

        return ResponseEntity.ok(service.getMeasurementsForDay(start, end));
    }

    @GetMapping("/statistics")
    public ResponseEntity<MeasurementStatistics> getStatisticsForDay(@RequestParam LocalDate date) {

        MeasurementStatistics statistics = service.getStatisticsForDay(date);

        if (statistics == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(statistics);
    }
}