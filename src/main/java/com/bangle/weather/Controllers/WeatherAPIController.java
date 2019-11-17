package com.bangle.weather.Controllers;

import com.bangle.weather.Entities.WeatherForecastResponse;
import com.bangle.weather.Services.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/weather")
@Api(description="APIs for weather forecast")
public class WeatherAPIController {
    @Autowired
    private WeatherService weatherService;

    @RequestMapping(method = RequestMethod.GET, value = "/tomorrow/{zipCode}")
    @ApiOperation(value = "Api to get weather forecast for tomorrow for location with provided zipCode")
    @PreAuthorize("hasRole('ADMIN')")
    public WeatherForecastResponse getWeatherForecast ( @PathVariable("zipCode") String zipCode ) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        WeatherForecastResponse forecast = weatherService.getWeatherForecast(zipCode, tomorrow);
        return forecast;
    }
}
