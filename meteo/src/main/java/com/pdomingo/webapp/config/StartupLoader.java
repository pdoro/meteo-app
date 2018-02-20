package com.pdomingo.webapp.config;

import com.pdomingo.persistence.ReportMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class StartupLoader implements ApplicationRunner {

	private final ResourceLoader   resourceLoader;
	private final ReportMongoRepository reportRepository;

	@Autowired
	public StartupLoader(ResourceLoader resourceLoader, ReportMongoRepository reportRepository) {
		this.resourceLoader = resourceLoader;
		this.reportRepository = reportRepository;
	}

	public void run(ApplicationArguments args) {

		/* Load Mongo sample data */
		Resource sampleData = resourceLoader.getResource(ResourceLoader.CLASSPATH_URL_PREFIX + "sample-data.csv");



	}
}