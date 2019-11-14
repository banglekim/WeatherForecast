package com.bangle.weather.Controllers;

import com.bangle.weather.Entities.WeatherForecastResponse;
import com.bangle.weather.Services.WeatherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/weather/tomorrow")
public class WeatherAppController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(method = RequestMethod.GET, value = "/{zipCode}")
    @ApiOperation(value = "Api to get weather forecast for tomorrow for location with provided zipCode and view")
    public ModelAndView getWeatherForecast ( @PathVariable("zipCode") String zipCode ) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        WeatherForecastResponse forecast = weatherService.getWeatherForecast(zipCode, tomorrow);
        Map <String, Object> model = new LinkedHashMap <>();
        model.put("weather", forecast);
        return new ModelAndView("weather", model);
    }

}

