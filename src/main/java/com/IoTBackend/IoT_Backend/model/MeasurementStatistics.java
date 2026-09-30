package com.IoTBackend.IoT_Backend.model;

import java.time.LocalDate;

public class MeasurementStatistics {

    private LocalDate date;
    private int measurementCount;

    private double averageTemperature;
    private double minimumTemperature;
    private double maximumTemperature;

    private double averageHumidity;
    private double minimumHumidity;
    private double maximumHumidity;

    public MeasurementStatistics(LocalDate date,int measurementCount,double averageTemperature,double minimumTemperature,double maximumTemperature,double averageHumidity,double minimumHumidity,double maximumHumidity) {

        this.date = date;
        this.measurementCount = measurementCount;
        this.averageTemperature = averageTemperature;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
        this.averageHumidity = averageHumidity;
        this.minimumHumidity = minimumHumidity;
        this.maximumHumidity = maximumHumidity;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMeasurementCount() {
        return measurementCount;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public double getMinimumHumidity() {
        return minimumHumidity;
    }

    public double getMaximumHumidity() {
        return maximumHumidity;
    }
}