package com.pdomingo.business.services;

import com.pdomingo.business.entities.WeatherReport;

/**
 *
 */
public interface WeatherReporter {
	WeatherReport register(WeatherReport report);
	void delete(String city);
}
