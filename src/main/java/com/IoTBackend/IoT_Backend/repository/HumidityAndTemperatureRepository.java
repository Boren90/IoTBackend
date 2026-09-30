package com.IoTBackend.IoT_Backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.IoTBackend.IoT_Backend.model.HumidityAndTemperature;

public interface HumidityAndTemperatureRepository extends MongoRepository<HumidityAndTemperature, String> {

    List<HumidityAndTemperature> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}