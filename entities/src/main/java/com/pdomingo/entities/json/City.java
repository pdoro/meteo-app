package com.pdomingo.entities.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class City {

	@JsonProperty("name")
	private String name;

	@JsonProperty("elevation")
	private int elevation;

	/*--------------------- Constructors ---------------------*/

	/*--------------------- Public Methods ---------------------*/

	/*--------------------- Private Methods ---------------------*/

}
