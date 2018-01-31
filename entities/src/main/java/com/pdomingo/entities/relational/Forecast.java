package com.pdomingo.entities.relational;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * https://vladmihalcea.com/2017/03/29/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "forecast", schema = "meteo")
public class Forecast {

	@Id
	@GeneratedValue
	private Long forecast_id;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime timestamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City location;

	@Column(name = "min_temperature")
	private int minTemperature;

	@Column(name = "max_temperature")
	private int maxTemperature;

	@Column(name = "humidity")
	private int humidityPercentage;

	@Column(name = "rain_prob")
	private int rainProbability;

	@Column(name = "snow_prob")
	private int snowProbability;

	@Column(name = "wind_dir")
	@Enumerated(EnumType.STRING)
	private Direction windDirection;

	@Column(name = "wind_speed")
	private int windSpeed;

	@Column(name = "ultraviolet")
	private int ultravioletFactor;

	private List<String> warnings;

	public enum Direction {
		NORTH, SOUTH, EAST, WEST,
		NORTH_EAST, NORTH_WEST,
		SOUTH_EAST, SOUTH_WEST;
	}
}
