package hu.Sziku.consumingrest.weatherapplication.responsmodel.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weather(int id,
                      String main,
                      String description,
                      String icon){
}
