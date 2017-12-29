package com.pdomingo.business.entities.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteWeatherReport {

	private String name;
	private int elevation;

	@JsonIgnore
	private int maxTemperature;
	@JsonIgnore
	private int minTemperature;

	@JsonIgnore
	private String windDirection;
	@JsonIgnore
	private int windSpeed;

	private int ultraviolet;

	@JsonProperty("temperature")
	private void unpackTemperature(Map<String, Object> temperatures) {
		this.maxTemperature = (int) temperatures.get("max");
		this.minTemperature = (int) temperatures.get("min");
	}

	@JsonProperty("wind")
	private void unpackWind(Map<String, Object> wind) {
		this.windDirection = (String) wind.get("direction");
		this.windSpeed = (int) wind.get("speed");
	}
}
