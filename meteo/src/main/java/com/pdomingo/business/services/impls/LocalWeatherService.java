package com.pdomingo.business.services.impls;

import com.pdomingo.business.entities.WeatherReport;
import com.pdomingo.business.services.WeatherReporter;
import com.pdomingo.business.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class LocalWeatherService implements WeatherService, WeatherReporter {

	private static final Map<String, WeatherReport> reports = new HashMap<>();

	static {
		reports.put("Madrid",
				WeatherReport.builder()
				.cityName("Madrid")
				.cityElevation(732)
				.minTemperature(0)
				.maxTemperature(10)
				.humidityPercentage(10)
				.rainProbability(23)
				.snowProbability(0)
				.ultravioletFactor(1)
				.windDirection(WeatherReport.Direction.NORTH_EAST)
				.warnings(Collections.emptyList())
				.build());
	}


	@Override
	public WeatherReport getReport(String city, Optional<LocalDate> start, Optional<LocalDate> end) {
		try {
			Thread.sleep(1000);
			log.info("Request processed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return reports.getOrDefault(city, null);
	}

	@Override
	@CachePut(value = "reports", key = "#report.getCityName()")
	public WeatherReport register(WeatherReport report) {
		reports.put(report.getCityName(), report);
		return report;
	}

	@Override
	@CacheEvict(value = "reports")
	public void delete(String city) {
		reports.remove(city);
	}
}
