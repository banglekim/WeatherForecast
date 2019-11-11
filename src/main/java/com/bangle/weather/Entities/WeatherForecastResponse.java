package com.bangle.weather.Entities;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastResponse {
    private String city;
    String date;
    private List <HourlyTemperature> hourlyTemperatures;

    public WeatherForecastResponse ( ) {
        hourlyTemperatures = new ArrayList <>();
    }

    public WeatherForecastResponse ( String city, String date, List < HourlyTemperature > hourlyTemperatures ) {
        this.city = city;
        this.date = date;
        this.hourlyTemperatures = hourlyTemperatures;
    }

    public String getCity ( ) {
        return city;
    }

    public void setCity ( String city ) {
        this.city = city;
    }

    public String getDate ( ) {
        return date;
    }

    public void setDate ( String date ) {
        this.date = date;
    }

    public List < HourlyTemperature > getHourlyTemperatures ( ) {
        return hourlyTemperatures;
    }

    public void setHourlyTemperatures ( List < HourlyTemperature > hourlyTemperatures ) {
        this.hourlyTemperatures = hourlyTemperatures;
    }
}
