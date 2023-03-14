package hu.Sziku.consumingrest.weatherapplication.responsmodel;

import lombok.Data;

@Data
public class SimpleWeatherResponse {

    //Coord;
    private double coordX;
    private double coordY;
    //Weather
    private int weatherId;
    private String weatherMain;
    private String weatherDescription;
    private String weatherIcon;
    //
    private String base;
    //Main;
    private double mainTemp;
    private double mainTempMin;
    private double mainFeelsLike;
    private double mainTempMax;
    private int mainPressure;
    private int mainHumidity;
    private int mainSea_level;
    private int mainGrndLevel;
    //
    private int visibility;
    //Wind
    private double windSpeed;
    private int windDeg;
    private double windGust;
    //cloud
    private int cloudAll;
    //
    private int dt;
    //Sys;
    private String sysCountry;
    private int sysSunrise;
    private int sysSunset;
    //
    private int timezone;
    private int id;
    private String cityName;
    private int cod;


    public SimpleWeatherResponse(WeatherResponse weatherResponse) {
        this.coordX = weatherResponse.coord().lon();
        this.coordY = weatherResponse.coord().lat();
        this.weatherId = weatherResponse.weathers().get(0).id();
        this.weatherMain = weatherResponse.weathers().get(0).main();
        this.weatherDescription = weatherResponse.weathers().get(0).description();
        this.weatherIcon = weatherResponse.weathers().get(0).icon();
        this.base = weatherResponse.base();
        this.mainTemp = weatherResponse.main().temp();
        this.mainTempMin = weatherResponse.main().temp_min();
        this.mainFeelsLike = weatherResponse.main().feels_like();
        this.mainTempMax = weatherResponse.main().temp_max();
        this.mainPressure = weatherResponse.main().pressure();
        this.mainHumidity = weatherResponse.main().humidity();
        this.mainSea_level = weatherResponse.main().sea_level();
        this.mainGrndLevel = weatherResponse.main().grnd_level();
        this.visibility = weatherResponse.visibility();
        this.windSpeed = weatherResponse.wind().speed();
        this.windDeg = weatherResponse.wind().deg();
        this.windGust = weatherResponse.wind().gust();
        this.cloudAll = weatherResponse.clouds().all();
        this.dt = weatherResponse.dt();
        this.sysCountry = weatherResponse.sys().country();
        this.sysSunrise = weatherResponse.sys().sunrise();
        this.sysSunset = weatherResponse.sys().sunset();
        this.timezone = weatherResponse.timezone();
        this.id = weatherResponse.id();
        this.cityName = weatherResponse.name();
        this.cod = weatherResponse.cod();

    }
}