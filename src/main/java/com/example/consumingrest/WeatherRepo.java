package com.example.consumingrest;

import com.example.consumingrest.weatherapi.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherRepo(Coord coord, @JsonProperty("weather") List<Weather> weathers, String base, Main main, int visibility, Wind wind, Clouds clouds, int dt, Sys sys, int timezone, int id, String name, int cod) {
}
