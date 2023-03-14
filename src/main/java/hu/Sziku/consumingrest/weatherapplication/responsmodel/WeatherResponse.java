package hu.Sziku.consumingrest.weatherapplication.responsmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import hu.Sziku.consumingrest.weatherapplication.responsmodel.openweathermap.*;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(
        Coord coord,
        @JsonProperty("weather") List<Weather> weathers,
        String base,
        Main main,
        int visibility,
        Wind wind,
        Clouds clouds,
        int dt,
        Sys sys,
        int timezone,
        int id,
        String name,
        int cod) {
}
