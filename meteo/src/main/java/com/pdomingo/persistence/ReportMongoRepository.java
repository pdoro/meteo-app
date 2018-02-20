package com.pdomingo.persistence;

import com.pdomingo.entities.json.WeatherReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ReportMongoRepository extends MongoRepository<WeatherReport, String> {

	/*
	 * Automatically generated implementations. Spring matches the name of the
	 * method and handles the logic.
	 *
	 * ej. findByCityName => {method : find} {field : cityName}
	 */

	Optional<WeatherReport> findByCityName(String cityName);

	/* Complex queries */
	@Query("{ 'temperature.min' : { '$gt' : ?0}," +
			" 'temperature.max' : { '$lt' : ?1} }")
	Optional<WeatherReport> findCityWithTemperatureInRange(int min, int max);
}
