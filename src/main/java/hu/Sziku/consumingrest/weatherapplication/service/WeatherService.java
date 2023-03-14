package hu.Sziku.consumingrest.weatherapplication.service;

import hu.Sziku.consumingrest.weatherapplication.responsmodel.SimpleWeatherResponse;
import hu.Sziku.consumingrest.weatherapplication.responsmodel.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherService {

    final RestTemplate restTemplate;

    @Value("${apikey}")
    private String apikey;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public WeatherResponse getWeatherResponse() {
        return restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q=Szeged&appid=" + apikey + "&units=metric&lang=hu", WeatherResponse.class);
    }


    public SimpleWeatherResponse getSimpleWeatherResponse() {
        WeatherResponse weatherResponse = restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q=Szeged&appid=" + apikey + "&units=metric&lang=hu", WeatherResponse.class);
        return new SimpleWeatherResponse(weatherResponse);
    }
}
