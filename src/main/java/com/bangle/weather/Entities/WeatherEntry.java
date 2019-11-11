package com.bangle.weather.Entities;

import com.bangle.weather.Utilities.WeatherUtilities;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.Map;

public class WeatherEntry implements Serializable {
    private String datetime;
    private double temperature;

    @JsonProperty("datetime")
    public String getDateTime() {
        return this.datetime;
    }

    @JsonSetter("dt_txt")
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
