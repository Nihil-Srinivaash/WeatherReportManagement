package com.jsp.WeatherReportWebService.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.WeatherReportWebService.DTO.Weather;
import com.jsp.WeatherReportWebService.REPOSITORY.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	WeatherRepository repository;
	
	// to insert weather record(object) into DB
	public Weather insertWeather(Weather weather)
	{
		 return repository.save(weather);
	}
	
	// to retrieve all weather records from DB
	public List<Weather> getAllWeatherReports() 
	{
		return repository.findAll();
	}
	
	// to retrieve a specific weather report based on ID
	public Weather getWeatherById(long id)
	{
		Optional<Weather> opt = repository.findById(id);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			return null;
		}
	}
	
	// to delete a weather report from DB
	public String deleteWeatherById(long id)
	{
		Weather w = getWeatherById(id);
		if(w != null)
		{
			// repository.deleteById(id);
			// 			OR
			repository.delete(w); 
			return "Weather Report deleted successfully...";
		}
		else
		{
			return "Could not delete the requested weather report. Weather ID not found...";
		}
	}
	
	// to update weather details - condition and temperature based on weather ID
	public String updateWeatherReport(long id , String newCondition ,String newTemperature)
	{
		Weather w = getWeatherById(id);
		if(w != null)
		{
			w.setConditions(newCondition);
			w.setTemperature(newTemperature);
			repository.save(w);
			return "Weather details updated successfully...";
		}
		else
		{
			return "Cannot update weather details . Weather ID not found...";
		}
	}
	
	// to retrieve weather reports based on city
	public List<Weather> getWeatherByCity(String city)
	{
		return repository.getAllWeatherByCity(city);
	}
	
	// to retrieve all weather reports where condition is rainy
	public List<Weather> getAllRainyWeatherReports()
	{
		return repository.getRainyWeatherReports();
	}
}

	  
							















