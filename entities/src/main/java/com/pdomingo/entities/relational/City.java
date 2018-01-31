package com.pdomingo.entities.relational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "city", schema = "meteo")
public class City {

	@Id
	@GeneratedValue
	private Long city_id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "population", nullable = false)
	private int population;

	@Column(name = "elevation")
	private int elevation;

	@Embedded
	private Coordinates coordinates;

	List<Forecast> forecasts;

	@RequiredArgsConstructor
	public static class Coordinates {
		public final double x;
		public final double y;
	}
}
