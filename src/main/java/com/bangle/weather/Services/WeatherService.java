package com.bangle.weather.Services;

import com.bangle.weather.Configurations.ProjectProperties;
import com.bangle.weather.Entities.HourlyTemperature;
import com.bangle.weather.Entities.WeatherEntry;
import com.bangle.weather.Entities.WeatherForecast;
import com.bangle.weather.Entities.WeatherForecastResponse;
import com.bangle.weather.Utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {
    @Autowired
    private ProjectProperties projectProperties;

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final RestTemplate restTemplate= new RestTemplate();

    public WeatherForecastResponse buildWeatherForecastResponse(WeatherForecast forecast, LocalDate date) {
        WeatherForecastResponse response = new WeatherForecastResponse();
        response.setCity(forecast.getName());
        response.setDate(date.toString());

        List <WeatherEntry> entries = forecast.getEntries().stream().filter(e-> e.getDateTime().contains(date.toString()))
                .collect(Collectors.toList());
        List< HourlyTemperature > hourlyTemperatures= new ArrayList <>();
        for (WeatherEntry entry: entries) {
            String[] dateTime= entry.getDateTime().split(" ");
            String hour = dateTime[1];
            hourlyTemperatures.add(new HourlyTemperature(hour,entry.getTemperature()));
        }
        response.setHourlyTemperatures(hourlyTemperatures);
        return response;
    }

    public WeatherForecastResponse getWeatherForecast( String zipCode, LocalDate date) {
        logger.info("Requesting weather forecast for {}/{}", zipCode, date);
        String api = projectProperties.getProperty(Constants.API_KEY);

        URI uri = new UriTemplate(Constants.FORECAST_URL).expand(zipCode,api);

        ResponseEntity<WeatherForecast> exchange = restTemplate
                .getForEntity(uri, WeatherForecast.class);

        WeatherForecastResponse response = buildWeatherForecastResponse(exchange.getBody(), date);
        return response;
    }
}
