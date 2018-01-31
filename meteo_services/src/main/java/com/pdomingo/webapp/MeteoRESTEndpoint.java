package com.pdomingo.webapp;

import com.pdomingo.entities.soap_xml.Report;
import com.pdomingo.persistence.MeteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MeteoRESTEndpoint {

	@Autowired
	private MeteoRepository repository;

	@GetMapping("/{city:[a-zA-Z]+}")
	public Report getReport(@PathVariable("city") String cityName) {
		Report report = repository.findByName(cityName);
		return report;
	}
}
