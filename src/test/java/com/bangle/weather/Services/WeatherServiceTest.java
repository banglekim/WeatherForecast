package com.bangle.weather.Services;

import com.bangle.weather.Entities.HourlyTemperature;
import com.bangle.weather.Entities.WeatherEntry;
import com.bangle.weather.Entities.WeatherForecast;
import com.bangle.weather.Entities.WeatherForecastResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
class WeatherServiceTest {
    WeatherForecast weatherForecast;
    WeatherForecastResponse response;

    @InjectMocks
    private WeatherService weatherService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp ( ) throws Exception {
        response = new WeatherForecastResponse();
        response.setCity("Chicago");
        response.setDate("2019-11-11");
        List < HourlyTemperature > tempList = new ArrayList <>();
        tempList.add(new HourlyTemperature("03:00:00", 31.68));
        response.setHourlyTemperatures(tempList);

        weatherForecast = new WeatherForecast();
        weatherForecast.setName("Chicago");
        List < WeatherEntry > entries = new ArrayList <>();
        WeatherEntry entry1 = new WeatherEntry();
        entry1.setDateTime("2019-11-11 03:00:00");
        entry1.setTemperature(31.68);
        entries.add(entry1);
        weatherForecast.setEntries(entries);
    }

    @Test
    void getWeatherForecast ( ) {
        when(restTemplate.exchange(any(), Mockito.<Class<Object>> any()))
          .thenReturn(new ResponseEntity(weatherForecast, HttpStatus.OK));
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        WeatherForecastResponse forecast = weatherService.getWeatherForecast("52556", tomorrow);
        assertEquals(response.getCity(),forecast.getCity());
        assertTrue(response.getHourlyTemperatures().get(0).equals(forecast.getHourlyTemperatures().get(0)));
    }
}
