package com.pdomingo.webapp.controllers;

import com.pdomingo.business.entities.WeatherReport;
import com.pdomingo.business.services.WeatherReporter;
import com.pdomingo.business.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(value = "/weather")
@Slf4j
public class WeatherController {

	@Inject
	@Qualifier("dispatcher")
	private WeatherService weatherService;

	@Inject
	private WeatherReporter weatherReporter;

	/*--------------------- Mappings ---------------------*/

	@GetMapping("/{city:[a-zA-Z]+}")
	private WeatherReport getWeatherReport(
			@PathVariable String city,

			@RequestParam(value = "since", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
					Optional<LocalDate> startDate,

			@RequestParam(value = "until", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
					Optional<LocalDate> endDate)
	{
		log.info("Received request for resource {}", city);
		WeatherReport report = weatherService.getReport(city, startDate, endDate);
		log.info("{}", report);
		return report;
	}

	@PostMapping("/report")
	@ResponseStatus(HttpStatus.CREATED)
	private void reportWeather(@RequestBody WeatherReport report) {
		weatherReporter.register(report);
	}

	@DeleteMapping("/report/{city:[a-zA-Z]+}")
	@ResponseStatus(HttpStatus.OK)
	private void deleteReport(@PathVariable String city) {
		weatherReporter.delete(city);
	}

	@GetMapping("ping")
	private String ping_pong() {
		return "pong";
	}
}
