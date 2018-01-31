package com.pdomingo.persistence;

import com.pdomingo.entities.soap_xml.Direction;
import com.pdomingo.entities.soap_xml.Report;
import com.pdomingo.entities.soap_xml.Temperature;
import com.pdomingo.entities.soap_xml.Wind;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class MeteoRepository {

	private static final Map<String, Report> reportsByCountry = new HashMap<>();

	@PostConstruct
	public void initialize() {

		String london = "London";

		Report londonReport = new Report();
		londonReport.setName(london);
		londonReport.setElevation(579);
		Temperature londonTemperature = new Temperature();
		londonTemperature.setMin(1);
		londonTemperature.setMax(9);
		londonReport.setTemperature(londonTemperature);

		Wind londonWind = new Wind();
		londonWind.setDirection(Direction.E);
		londonWind.setSpeed(17);
		londonReport.setWind(londonWind);

		londonReport.setUltraviolet(2);

		reportsByCountry.put(london, londonReport);
	}

	public Report findByName(String cityName) {
		return reportsByCountry.get(cityName);
	}
}
