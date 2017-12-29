package com.pdomingo.webapp.controllers;

import com.pdomingo.business.entities.WeatherReport;
import com.pdomingo.business.services.WeatherReporter;
import com.pdomingo.business.services.WeatherService;
import lombok.RequiredArgsConstructor;
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

	@Inject
	@Qualifier("dispatcher")
	private WeatherService weatherService;

	@Inject
	private WeatherReporter weatherReporter;

	/*--------------------- Mappings ---------------------*/

	@GetMapping("/")
	private List<WeatherReport> getReports() {
		return Collections.emptyList();
	}

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
		log.info("Received request to get weather report for {}", city);
		WeatherReport report = weatherService.getReport(city, startDate, endDate);
		return report;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	private void reportWeather(@RequestBody WeatherReport report) {
		log.info("Received request to create weather report for {}", report.getCityName());
		weatherReporter.register(report);
	}

	@DeleteMapping("/{city:[a-zA-Z]+}")
	@ResponseStatus(HttpStatus.OK)
	private void deleteReport(@PathVariable String city) {
		log.info("Received request to delete weather report for {}", city);
		weatherReporter.delete(city);
	}

	@GetMapping("ping")
	private String ping_pong() {
		return "pong";
	}
}
