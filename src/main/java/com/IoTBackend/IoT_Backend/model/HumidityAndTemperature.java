package com.IoTBackend.IoT_Backend.model;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "humidity_and_temperature")
public class HumidityAndTemperature {
    
    @Id 
    private String id;
    private double humidity;
    private double temperature;
    private LocalDateTime timestamp;

    public HumidityAndTemperature() {
    }

    public HumidityAndTemperature(double humidity, double temperature) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.timestamp = LocalDateTime.now();
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}