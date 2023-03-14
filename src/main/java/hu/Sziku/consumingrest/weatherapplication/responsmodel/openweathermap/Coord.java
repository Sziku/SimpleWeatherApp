package hu.Sziku.consumingrest.weatherapplication.responsmodel.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Coord(double lon,
                    double lat){
}
