package com.bae.houseplants.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Houseplant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String plantName;
	
	private String water;

	private String sunlight;

	private String humidity;
	
	private Integer quantity;
	

	public Houseplant(String plantName, String water, String sunlight, String humidity, Integer quantity) {
		super();
		this.plantName = plantName;
		this.water = water;
		this.sunlight = sunlight;
		this.humidity = humidity;
		this.quantity = quantity;
	}

	public Houseplant(Integer id, String plantName, String water, String sunlight, String humidity, Integer quantity) {
		super();
		this.id = id;
		this.plantName = plantName;
		this.water = water;
		this.sunlight = sunlight;
		this.humidity = humidity;
		this.quantity = quantity;
	}
	

	public Houseplant() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getSunlight() {
		return sunlight;
	}

	public void setSunlight(String sunlight) {
		this.sunlight = sunlight;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Houseplant [id=" + id + ", plantName=" + plantName + ", water=" + water + ", sunlight=" + sunlight
				+ ", humidity=" + humidity + ", quantity=" + quantity + "]";
	}
}