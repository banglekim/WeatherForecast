package com.bangle.weather.Entities;

import com.bangle.weather.Utilities.WeatherUtilities;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class WeatherEntry {
    @JsonProperty("dt_txt")
    private String datetime;
    private double temperature;

    public String getDateTime() {
        return this.datetime;
    }

    public void setDateTime(String dateTimeText) {
        this.datetime = dateTimeText;
    }

    // Return Fahrenheit degree
    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        setTemperature(WeatherUtilities.getFahrenheit(Double.parseDouble(main.get("temp").toString())));
    }
}
