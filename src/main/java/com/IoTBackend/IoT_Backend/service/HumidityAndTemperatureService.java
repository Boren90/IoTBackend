package com.IoTBackend.IoT_Backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.IoTBackend.IoT_Backend.model.HumidityAndTemperature;
import com.IoTBackend.IoT_Backend.model.MeasurementStatistics;
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

    public List<HumidityAndTemperature> getMeasurementsForDay(LocalDateTime start, LocalDateTime end) {

    return repository.findByTimestampBetween(start, end);
}

    public MeasurementStatistics getStatisticsForDay(LocalDate date) {

    LocalDateTime start = date.atStartOfDay();
    LocalDateTime end = date.plusDays(1).atStartOfDay();

    List<HumidityAndTemperature> measurements =
            repository.findByTimestampBetween(start, end);

    if (measurements.isEmpty()) {
        return null;
    }

    double averageTemperature = measurements.stream()
            .mapToDouble(HumidityAndTemperature::getTemperature)//omvandlar objektet till en primitiv double och hämtar temperaturvärdet
            .average()
            .orElse(0);

    double minimumTemperature = measurements.stream()
            .mapToDouble(HumidityAndTemperature::getTemperature)
            .min()
            .orElse(0);

    double maximumTemperature = measurements.stream()
            .mapToDouble(HumidityAndTemperature::getTemperature)
            .max()
            .orElse(0);

    double averageHumidity = measurements.stream()
            .mapToDouble(HumidityAndTemperature::getHumidity)
            .average()
            .orElse(0);

    double minimumHumidity = measurements.stream()
            .mapToDouble(HumidityAndTemperature::getHumidity)
            .min()
            .orElse(0);

    double maximumHumidity = measurements.stream()
            .mapToDouble(HumidityAndTemperature::getHumidity)
            .max()
            .orElse(0);

    MeasurementStatistics statistics = new MeasurementStatistics(date,measurements.size(),averageTemperature,minimumTemperature,maximumTemperature,averageHumidity,minimumHumidity,maximumHumidity);        
    
    return statistics;

}
}