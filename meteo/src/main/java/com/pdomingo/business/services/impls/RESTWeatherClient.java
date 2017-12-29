package com.pdomingo.business.services.impls;

import com.pdomingo.business.entities.WeatherReport;
import com.pdomingo.business.entities.json.RemoteWeatherReport;
import com.pdomingo.business.services.WeatherService;
import com.pdomingo.webapp.config.AppConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RESTWeatherClient implements WeatherService {

	@Inject
	private RestTemplate restTemplate;

	@Inject
	private AppConfig cfg;

	@Override
	public WeatherReport getReport(String city, Optional<LocalDate> start, Optional<LocalDate> end) {

		String url = cfg.REMOTE_REST_URL + city;

		log.info("Performing remote REST request to {}", url);

		RemoteWeatherReport report = restTemplate.getForObject(url, RemoteWeatherReport.class);
		WeatherReport weatherReport = WeatherReport.fromRemoteReport(report);

		return weatherReport;
	}
}
