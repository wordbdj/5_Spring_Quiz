package com.quiz.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@GetMapping("/weather-list-view")
	public String weatherView() {
		
		return "weather_history/weatherList";
	}
	
	@GetMapping("add-weather-view")
	public String addWeatherview() {
		
		return "weather_history/addWeather";
	}

}
