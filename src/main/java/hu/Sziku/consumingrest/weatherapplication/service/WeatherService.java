package hu.Sziku.consumingrest.weatherapplication.service;

import hu.Sziku.consumingrest.weatherapplication.responsmodel.SimpleWeatherResponse;
import hu.Sziku.consumingrest.weatherapplication.responsmodel.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    private final String baseURL = "https://api.openweathermap.org/data/2.5/weather?q=";
    @Value("${apikey}")
    private String apikey;

    private final String city = "Szeged";

    private final String units = "metric";

    private final String language = "hu";


    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public WeatherResponse getWeatherResponse() {
        return restTemplate.getForObject(
                baseURL + city + "&appid=" + apikey + "&units=" + units + "&lang=" + language, WeatherResponse.class);
    }


    public SimpleWeatherResponse getSimpleWeatherResponse() {
        WeatherResponse weatherResponse = restTemplate.getForObject(
                baseURL + this.city + "&appid=" + apikey + "&units=" + units + "&lang=" + language, WeatherResponse.class);
        return new SimpleWeatherResponse(weatherResponse);
    }

    public SimpleWeatherResponse getSimpleWeatherResponse(String city) {
        WeatherResponse weatherResponse = restTemplate.getForObject(
                baseURL + city + "&appid=" + apikey + "&units=" + units + "&lang=" + language, WeatherResponse.class);
        return new SimpleWeatherResponse(weatherResponse);
    }
}
