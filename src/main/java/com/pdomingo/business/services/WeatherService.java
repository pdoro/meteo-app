package com.pdomingo.business.services;

import com.pdomingo.business.entities.WeatherReport;

import java.time.LocalDate;
import java.util.Optional;

public interface WeatherService {

	WeatherReport getReport(String city,
	                        Optional<LocalDate> start,
	                        Optional<LocalDate> end);
}
