package com.jsp.WeatherReportWebService.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.WeatherReportWebService.DTO.Weather;
import com.jsp.WeatherReportWebService.SERVICE.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	WeatherService service;
	
	// REST API to INSERT WEATHER REPORT INTO DB
	
	@PostMapping("/weather") // url --> end points
	public Weather addWeather(@RequestBody Weather weather)
	{
		return service.insertWeather(weather);
	}
	
	// REST API TO RETRIEVE ALL WEATHER REPOSRT FROM DB
	
	@GetMapping("/weather")
	public List<Weather> getAllReports()
	{
		return service.getAllWeatherReports();
	}
	
	// REST API TO RETRIEVE A SPECIFIC WEATHER REPORT BASED ON ID
	
	@GetMapping("/byid")
	public Weather getweatherReportById(@RequestParam long id)
	{
		return service.getWeatherById(id);
	}
	
	/// REST API TO DELETE A WEATHER REPORT BASED ON ID
	
	@DeleteMapping("/weather")
	public String deleteWeather(@RequestParam long id)
	{
		return service.deleteWeatherById(id);
	}
	
	// REST API TO UPDATE WEATHER DETAILS WITH NEW CONDITION AND NEW TEMPERATURE BASED ON ID
	
	@PutMapping("/weather")
	public String updateWeatherDetails(@RequestParam long id , @RequestParam String condt , @RequestParam String temp)
	{
		return service.updateWeatherReport(id, condt, temp);
	}
	
	// REST API TO RETRIEVE ALL WEATHER REPORTS OF A SPECIFIC CITY
	
	@GetMapping("/bycity")
	public List<Weather> getWeatherByCity(@RequestParam String city)
	{
		return service.getWeatherByCity(city);
	}
	
	// REST API TO RETRIEVE ALL RAINT WEATHER REPORTS
	
	@GetMapping("/bycondt")
	public List<Weather> getRainyWeather()
	{
		return service.getAllRainyWeatherReports();
	}
}
















