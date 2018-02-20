package com.pdomingo.business.services.impls;

import com.pdomingo.business.services.WeatherReporter;
import com.pdomingo.business.services.WeatherService;
import com.pdomingo.entities.json.WeatherReport;
import com.pdomingo.persistence.ReportMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class LocalWeatherService implements WeatherService, WeatherReporter {

	private final ReportMongoRepository reportRepository;

	@Inject
	public LocalWeatherService(ReportMongoRepository reportRepository) {
		this.reportRepository = reportRepository;
	}

	@Override
	@Cacheable
	public WeatherReport getReport(String city, Optional<LocalDate> start, Optional<LocalDate> end) {
		log.trace("Report request for {}", city);
		WeatherReport weatherReport = reportRepository.findByCityName(city).get();

		// TODO IMPROVE

		log.trace("Found report #{}", weatherReport.getId());

		return weatherReport;
	}

	@Override
	@CachePut(value = "reports", key = "#report.getCity().getName()")
	public WeatherReport register(WeatherReport report) {
		log.trace("Inserting report for {}", report.getCity().getName());
		WeatherReport inserted = reportRepository.insert(report);
		log.trace("Inserted report #{} ", inserted.getId());

		return inserted;
	}

	@Override
	@CacheEvict(value = "reports")
	public void delete(String city) {
		// delete by cityName
	}
}
