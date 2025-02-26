package com.jsp.WeatherReportWebService.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.WeatherReportWebService.DTO.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long>
{
	//  all methods to perform DB operations are inherited from JpaRepository here.
	
	// to search based on cit
	@Query("select w from Weather w where w.city = ?1")
	public List<Weather> getAllWeatherByCity(String city);
	
	// to get all weather reports where condition is rainy
	
	@Query(value = "select * from weather where conditions='rainy' ", nativeQuery = true)
	public List<Weather> getRainyWeatherReports();
}

