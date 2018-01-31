package com.pdomingo.entities.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class Temperature {

	@JsonProperty("min_temperature")
	private int min;

	@JsonProperty("max_temperature")
	private int max;
}
