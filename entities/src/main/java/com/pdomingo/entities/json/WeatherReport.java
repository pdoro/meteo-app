package com.pdomingo.entities.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reports")
public class WeatherReport {

	@JsonIgnore
	@Id
	private String id;

	private City city;
	private Temperature temperature;
	private RainInfo rainInfo;
	private WindInfo windInfo;

	@JsonProperty("ultraviolet")
	private int ultravioletFactor;

	private List<String> warnings;
}
