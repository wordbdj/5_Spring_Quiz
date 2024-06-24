package com.quiz.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@GetMapping("")
	public String addStudentView() {
		
		return "weather_history/addWeather.html";
	}
	
	

}
