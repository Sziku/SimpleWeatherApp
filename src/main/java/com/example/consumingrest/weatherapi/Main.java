package com.example.consumingrest.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity, int sea_level, int grnd_level) {
}
