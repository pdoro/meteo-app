package com.pdomingo.business.services.impls;

import com.pdomingo.business.entities.WeatherReport;
import com.pdomingo.business.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

@Service("dispatcher")
@Slf4j
public class DispatcherWeatherService implements WeatherService {

	@Inject private LocalWeatherService local;
	@Inject private SOAPWeatherClient remoteSOAP;
	@Inject private RESTWeatherClient remoteREST;

	@Override
	@Cacheable(value = "reports", key = "#city" )
	public WeatherReport getReport(String city, Optional<LocalDate> start, Optional<LocalDate> end) {

		WeatherReport report;

		report = local.getReport(city, start, end);
		if ( report != null ) {
			log.info("Successful response from local service");
			return report;
		}

		report = remoteREST.getReport(city, start, end);
		if ( report != null ) {
			log.info("Successful response from remote rest service");
			return report;
		}

		report = remoteSOAP.getReport(city, start, end);
		if ( report != null ) {
			log.info("Successful response from remote soap service");
			return report;
		}

		throw new NullPointerException("Nope!");
	}
}
