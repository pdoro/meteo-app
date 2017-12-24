package com.pdomingo.webapp.config;

import com.pdomingo.business.services.impls.SOAPWeatherClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.inject.Inject;

@Configuration
public class SOAPConfig {

	@Inject
	private AppConfig cfg;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(cfg.XML_CONTEXT_PATH);
		return marshaller;
	}

	@Bean
	public SOAPWeatherClient soapWeatherService(Jaxb2Marshaller marshaller) {
		SOAPWeatherClient weatherClient = new SOAPWeatherClient();

		weatherClient.setDefaultUri(cfg.REMOTE_SOAP_URL);
		weatherClient.setMarshaller(marshaller);
		weatherClient.setUnmarshaller(marshaller);

		return weatherClient;
	}

}
