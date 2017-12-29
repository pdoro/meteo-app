package com.pdomingo.webapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@Slf4j
public class AppConfig {

	public final String REMOTE_REST_URL;
	public final String REMOTE_SOAP_URL;
	public final String XML_CONTEXT_PATH;

	public AppConfig(
			@Value("${remote_ws.rest.url}") String REMOTE_REST_URL,
			@Value("${remote_ws.soap.url}") String REMOTE_SOAP_URL,
			@Value("${xml.context_path}")   String XML_CONTEXT_PATH) {
		this.REMOTE_REST_URL = REMOTE_REST_URL;
		this.REMOTE_SOAP_URL = REMOTE_SOAP_URL;
		this.XML_CONTEXT_PATH = XML_CONTEXT_PATH;
	}

	@PostConstruct
	public void report() {
		log.info("Remote service REST url: {}", REMOTE_REST_URL);
		log.info("Remote service SOAP url : {}", REMOTE_SOAP_URL);
	}
}
