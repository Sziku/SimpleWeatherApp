package com.example.consumingrest.controller;

import com.example.consumingrest.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    final RestTemplate restTemplate;

    @Value("${apikey}")
    private String apikey;
    @Autowired
    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/weather")
    public WeatherRepo getWeather(){
        return restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q=Szeged&appid=" + apikey + "&units=metric&lang=hu", WeatherRepo.class);

    }
}
