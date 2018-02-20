package com.pdomingo.webapp.controllers;

import com.pdomingo.business.services.WeatherReporter;
import com.pdomingo.business.services.WeatherService;
import com.pdomingo.entities.json.WeatherReport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/weather")
@Slf4j
public class WeatherController {


	private final WeatherService weatherService;
	private final WeatherReporter weatherReporter;

	@Inject
	public WeatherController(@Qualifier("dispatcher") WeatherService weatherService,
	                         WeatherReporter weatherReporter) {
		this.weatherService = weatherService;
		this.weatherReporter = weatherReporter;
	}

	/*--------------------- Mappings ---------------------*/

	@GetMapping("/")
	private List<WeatherReport> getAllReports() {
		return Collections.emptyList();
	}

	@GetMapping("/{city:[a-zA-Z\\s]+}")
	private WeatherReport getWeatherReport(
			@PathVariable String city,

			@RequestParam(value = "since", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
					Optional<LocalDate> startDate,

			@RequestParam(value = "until", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
					Optional<LocalDate> endDate)
	{
		log.trace("Received request to get weather report for {}", city);
		WeatherReport report = weatherService.getReport(city, startDate, endDate);
		return report;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	private void reportWeather(@RequestBody WeatherReport report) {
		log.trace("Received request to create weather report for {}", report.getCity().getName());
		weatherReporter.register(report);
	}

	@DeleteMapping("/{city:[a-zA-Z]+}")
	@ResponseStatus(HttpStatus.OK)
	private void deleteReport(@PathVariable String city) {
		log.trace("Received request to delete weather report for {}", city);
		weatherReporter.delete(city);
	}

	@GetMapping("ping")
	private String ping_pong() {
		return "pong";
	}
}
