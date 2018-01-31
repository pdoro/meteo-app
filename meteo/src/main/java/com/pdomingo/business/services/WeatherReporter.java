package com.pdomingo.business.services;

import com.pdomingo.entities.json.WeatherReport;

/**
 *
 */
public interface WeatherReporter {
	WeatherReport register(WeatherReport report);
	void delete(String city);
}
