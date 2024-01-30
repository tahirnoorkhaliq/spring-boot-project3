package com.tahir.darkcodder.best.choice.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARDETAILS")
public class CarDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2533464507878391463L;

	@Id
	@GeneratedValue
	private long carId;
	
	@Column(nullable = false, length = 100)
	private String brand;
	
	@Column(nullable = false, length = 100)
	private String model;
	
	@Column(nullable = false, length = 100)
	private String year;
	
	@Column(nullable = false, length = 100)
	private String kmsDriven;
	
	@Column(nullable = false, length = 100)
	private String price;
	
	@Column(nullable = false, length = 100)
	private String fuel;

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

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

	@Override
	public String toString() {
		return "CarDetails [carId=" + carId + ", brand=" + brand + ", model=" + model + ", year=" + year
				+ ", kmsDriven=" + kmsDriven + ", price=" + price + ", fuel=" + fuel + "]";
	}
	


}
