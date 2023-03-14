package hu.Sziku.consumingrest.weatherapplication.controller;

import hu.Sziku.consumingrest.weatherapplication.responsmodel.SimpleWeatherResponse;
import hu.Sziku.consumingrest.weatherapplication.responsmodel.WeatherResponse;
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
    public WeatherResponse getWeather(){
        return restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q=Szeged&appid=" + apikey + "&units=metric&lang=hu", WeatherResponse.class);

    }

    @GetMapping("api/weather2")
    public SimpleWeatherResponse getWeather2(){
        WeatherResponse weatherResponse = restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q=Szeged&appid=" + apikey + "&units=metric&lang=hu", WeatherResponse.class);
        return new SimpleWeatherResponse(weatherResponse);
    }
}
