package com.bangle.weather.Entities;

public class HourlyTemperature {
    private double temperature;
    private String hour;

    public HourlyTemperature ( String hour, double temperature ) {
        this.temperature = temperature;
        this.hour = hour;
    }

    public double getTemperature ( ) {
        return temperature;
    }

    public void setTemperature ( double temperature ) {
        this.temperature = temperature;
    }

    public String getHour ( ) {
        return hour;
    }

    public void setHour ( String hour ) {
        this.hour = hour;
    }
}
