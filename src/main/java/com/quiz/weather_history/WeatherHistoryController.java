package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;

	// list
	@GetMapping("/weather-list-view")
	public String weatherView(Model model) {
		
		// DB에서 Weather_History 받기
		List<WeatherHistory> weatherList =  weatherHistoryBO.getWeatherHistory();
		
		//Model에 저장
		model.addAttribute("weatherList", weatherList);
		
		// 화면 이동
		return "weather_history/weatherList";
	}
	
	//날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherview() {
		
		
		return "weather_history/addWeather";
	}

	
	@PostMapping("/weather-list")
	public String afterAddWeather
		(@ModelAttribute WeatherHistory weatherHistory
			,Model model) {
		
		// DB insert => 
		weatherHistoryBO.addWeather(weatherHistory);
		
		// DB에서 Weather_History 받기
		List<WeatherHistory> weatherList =  weatherHistoryBO.getWeatherHistory();
		
		//Model에 저장
		model.addAttribute("weatherList", weatherList);
		
		return"weather_history/weatherList";
	}
}
