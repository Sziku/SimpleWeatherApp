package hu.Sziku.consumingrest;

import hu.Sziku.consumingrest.weatherapplication.responsmodel.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication //(scanBasePackages = {"responsmodel"})
public class WeatherApplication {
	@Value("${apikey}")
	private String apikey;

	private static final Logger log = LoggerFactory.getLogger(WeatherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			WeatherResponse weatherResponse = restTemplate.getForObject(
					"https://api.openweathermap.org/data/2.5/weather?q=Szeged&appid=" + apikey + "&units=metric&lang=hu", WeatherResponse.class);
			log.info(weatherResponse.toString());
		};
	}


}
