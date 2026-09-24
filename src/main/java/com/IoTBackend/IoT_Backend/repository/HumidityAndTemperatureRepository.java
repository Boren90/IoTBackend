package com.IoTBackend.IoT_Backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.IoTBackend.IoT_Backend.model.HumidityAndTemperature;

public interface HumidityAndTemperatureRepository extends MongoRepository<HumidityAndTemperature, String> {

}