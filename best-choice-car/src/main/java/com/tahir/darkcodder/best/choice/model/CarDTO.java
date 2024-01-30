package com.tahir.darkcodder.best.choice.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CarDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5555336139477712407L;
	
	private long carId;
	
	@NotNull(message = "Brand Can't be empty")
	@Size(min = 1, max = 16, message = "movieId Can't be less than 1 ot greater than 16 chars")	
	private String brand;
	
	@NotNull(message = "Model Can't be empty")
	@Size(min = 1, max = 16, message = "Model Can't be less than 1 ot greater than 16 chars")
	private String model;
	
	@NotNull(message = "movieName Can't be empty")
	@Size(min = 1, max = 16, message = "Model Can't be less than 1 ot greater than 16 chars")
	private String year;
	
	@NotNull(message = "kms Driven  Can't be empty")
	@Size(min = 1, max = 16, message = "kms Driven Can't be less than 1 ot greater than 16 chars")
	private String kmsDriven;
	
	@NotNull(message = "Price Can't be empty")
	@Size(min = 1, max = 16, message = "Price Can't be less than 1 ot greater than 16 chars")
	private String price;
	
	@NotNull(message = "Fuel Can't be empty")
	@Size(min = 1, max = 16, message = "Fuel Can't be less than 1 ot greater than 16 chars")
	private String fuel;
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getKmsDriven() {
		return kmsDriven;
	}

	public void setKmsDriven(String kmsDriven) {
		this.kmsDriven = kmsDriven;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}	

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", brand=" + brand + ", model=" + model + ", year=" + year + ", kmsDriven="
				+ kmsDriven + ", price=" + price + ", fuel=" + fuel + "]";
	}

	
	
}
