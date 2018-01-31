package com.pdomingo.webapp;

import com.pdomingo.config.WebServiceConfig;
import com.pdomingo.entities.soap_xml.GetMeteoReportRequest;
import com.pdomingo.entities.soap_xml.GetMeteoReportResponse;
import com.pdomingo.entities.soap_xml.Report;
import com.pdomingo.persistence.MeteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MeteoSOAPEndpoint {

	@Autowired
	private MeteoRepository repository;

	@PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "getMeteoReportRequest")
	@ResponsePayload
	public GetMeteoReportResponse getReport(@RequestPayload GetMeteoReportRequest request) {

		// https://spring.io/guides/gs/producing-web-service/

		String cityName = request.getName();
		Report report = repository.findByName(cityName);

		GetMeteoReportResponse reponse = new GetMeteoReportResponse();
		reponse.setMeteoReport(report);
		return reponse;
	}
}
