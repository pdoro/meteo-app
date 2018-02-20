package com.pdomingo.entities.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RainInfo {

	@JsonProperty("humidity")
	private int humidityPercentage;
	@JsonProperty("rain_probability")
	private int rainProbability;
	@JsonProperty("snow_probability")
	private int snowProbability;
}
