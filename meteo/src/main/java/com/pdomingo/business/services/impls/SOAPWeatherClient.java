package com.pdomingo.business.services.impls;

import com.pdomingo.business.services.WeatherService;
import com.pdomingo.entities.json.City;
import com.pdomingo.entities.json.WeatherReport;
import com.pdomingo.entities.json.WindInfo;
import com.pdomingo.entities.soap_xml.Direction;
import com.pdomingo.entities.soap_xml.GetMeteoReportRequest;
import com.pdomingo.entities.soap_xml.GetMeteoReportResponse;
import com.pdomingo.entities.soap_xml.Report;
import com.pdomingo.webapp.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

@Slf4j
public class SOAPWeatherClient
		extends WebServiceGatewaySupport
		implements WeatherService
{

	@Inject
	private AppConfig cfg;

	public static final String ACTION_URL = "http://127.0.0.1:8080/ws/getMeteoReportRequest";

	@Override
	public WeatherReport getReport(String city, Optional<LocalDate> start, Optional<LocalDate> end) {

		GetMeteoReportRequest request = new GetMeteoReportRequest();
		request.setName(city);

		log.info("Performing remote SOAP request to {}", cfg.REMOTE_SOAP_URL);

		GetMeteoReportResponse response = (GetMeteoReportResponse)
				getWebServiceTemplate().marshalSendAndReceive(cfg.REMOTE_SOAP_URL, request, new SoapActionCallback(ACTION_URL));

		return transformReport(response);
	}

	private WeatherReport transformReport(GetMeteoReportResponse response) {

		Report report = response.getMeteoReport();

		/*
		WeatherReport weatherReport = WeatherReport.builder()
				.city(new City())
				.cityElevation(report.getElevation())
				.maxTemperature(report.getTemperature().getMax())
				.minTemperature(report.getTemperature().getMin())
				.windDirection(null)
				.windSpeed(report.getWind().getSpeed())
				.build();
		*/
		// TODO: fix

		return null;
	}

	private WindInfo.Direction translateWind(Direction windDirection) {

		switch (windDirection) {
			case N:  return WindInfo.Direction.NORTH;
			case S:  return WindInfo.Direction.SOUTH;
			case E:  return WindInfo.Direction.EAST;
			case W:  return WindInfo.Direction.WEST;
			case NE: return WindInfo.Direction.NORTH_EAST;
			case NW: return WindInfo.Direction.NORTH_WEST;
			case SE: return WindInfo.Direction.SOUTH_EAST;
			case SW: return WindInfo.Direction.SOUTH_WEST;
			default: throw new IllegalArgumentException("Invalid wind direction");
		}
	}
}
