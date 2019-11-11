package com.bangle.weather.Utilities;

public class WeatherUtilities {
    public static double getFahrenheit(double degreesKelvin)
    {
        double f = (((degreesKelvin - 273) * 9/5) + 32);
        String str = String.format("%1.2f", f);
        return Double.valueOf(str);
    }

    public static double getCelsiusTemperature(double degreesKelvin) {
        double celsiusTemp = degreesKelvin - 273.15;
        return Double.valueOf(String.format("%1.2f", celsiusTemp));
    }
}
