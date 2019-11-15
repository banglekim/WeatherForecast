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

    @Override
    public boolean equals ( Object obj ) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof HourlyTemperature)) {
            return false;
        }

        // typecast obj to HourlyTemperature so that we can compare data members
        HourlyTemperature c = (HourlyTemperature) obj;
        return (this.temperature==c.temperature) && (this.hour.equals(c.hour));
    }
}
