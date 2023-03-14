package hu.Sziku.consumingrest.weatherapplication.controller;

import hu.Sziku.consumingrest.weatherapplication.responsmodel.SimpleWeatherResponse;
import hu.Sziku.consumingrest.weatherapplication.responsmodel.WeatherResponse;
import hu.Sziku.consumingrest.weatherapplication.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    final WeatherService weatherService;

    @Autowired
    public WeatherController(RestTemplate restTemplate, WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public WeatherResponse getWeather(){
        return weatherService.getWeatherResponse();

    }

    @GetMapping("api/weather2")
    public SimpleWeatherResponse getWeather2(){
        return weatherService.getSimpleWeatherResponse();
    }

}
