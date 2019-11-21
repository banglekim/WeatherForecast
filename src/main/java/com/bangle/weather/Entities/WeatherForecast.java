package com.bangle.weather.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherForecast {

    private String name;
    @JsonProperty("list")
    private List<WeatherEntry> entries = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeatherEntry> getEntries() {
        return this.entries;
    }

    public void setEntries(List<WeatherEntry> entries) {
        this.entries = entries;
    }

    @JsonProperty("city")
    public void setCity( Map <String, Object> city) {
        setName(city.get("name").toString());
    }
}
