package com.pdomingo.entities.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WindInfo {

	@JsonProperty("wind_direction")
	private Direction windDirection;
	@JsonProperty("wind_speed")
	private int windSpeed;

	public enum Direction {
		NORTH, SOUTH, EAST, WEST,
		NORTH_EAST, NORTH_WEST,
		SOUTH_EAST, SOUTH_WEST;
	}
}
