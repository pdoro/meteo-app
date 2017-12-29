package com.pdomingo.business.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import com.pdomingo.business.entities.json.RemoteWeatherReport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReport {

	@JsonProperty("name")
	private String cityName;
	@JsonProperty("elevation")
	private int cityElevation;

	@JsonProperty("min_temperature")
	private int minTemperature;
	@JsonProperty("max_temperature")
	private int maxTemperature;

	@JsonProperty("humidity")
	private int humidityPercentage;
	@JsonProperty("rain_probability")
	private int rainProbability;
	@JsonProperty("snow_probability")
	private int snowProbability;

	@JsonProperty("wind_direction")
	private Direction windDirection;
	@JsonProperty("wind_speed")
	private int windSpeed;

	@JsonProperty("ultraviolet")
	private int ultravioletFactor;

	private List<String> warnings;

	public enum Direction {
		NORTH, SOUTH, EAST, WEST,
		NORTH_EAST, NORTH_WEST,
		SOUTH_EAST, SOUTH_WEST;

		private static final Map<String, Direction> TRANSLATION_MAP = ImmutableMap.<String, Direction>builder().
				put("N", NORTH).
				put("S", SOUTH).
				put("E", EAST).
				put("W", WEST).
				put("NE", NORTH_EAST).
				put("NW", NORTH_WEST).
				put("SE", SOUTH_EAST).
				put("SW", SOUTH_WEST).
				build();

		public static Direction from(String name) {
			return TRANSLATION_MAP.get(name);
		}
	}

	public static WeatherReport fromRemoteReport(RemoteWeatherReport remoteReport) {
		return WeatherReport.builder() .
				cityName(remoteReport.getName()).
				cityElevation(remoteReport.getElevation()).
				maxTemperature(remoteReport.getMaxTemperature()).
				minTemperature(remoteReport.getMinTemperature()).
				//.humidityPercentage(remoteReport.)
				windSpeed(remoteReport.getWindSpeed()).
				windDirection(Direction.from(remoteReport.getWindDirection())).
				ultravioletFactor(remoteReport.getUltraviolet())
				.build();
	}
}
