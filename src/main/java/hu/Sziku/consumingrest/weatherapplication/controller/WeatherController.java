package hu.Sziku.consumingrest.weatherapplication.controller;

import hu.Sziku.consumingrest.weatherapplication.responsmodel.SimpleWeatherResponse;
import hu.Sziku.consumingrest.weatherapplication.responsmodel.WeatherResponse;
import hu.Sziku.consumingrest.weatherapplication.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    final WeatherService weatherService;
    Logger logger = LoggerFactory.getLogger(WeatherController.class);

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

    @GetMapping("api/weather2/{city}")
    public SimpleWeatherResponse getLocalWeather(@PathVariable("city") String city){
        logger.warn("GET request received ofr city: " + city);
        return weatherService.getSimpleWeatherResponse(city);
    }

}
