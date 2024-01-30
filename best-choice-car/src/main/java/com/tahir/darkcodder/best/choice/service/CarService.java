package com.tahir.darkcodder.best.choice.service;

import java.util.List;

import com.tahir.darkcodder.best.choice.model.CarDTO;

public interface CarService {
 public CarDTO save(CarDTO movieDTO);
 public List<CarDTO> getAllCars();
 public CarDTO getCar(long carId);
 public List<CarDTO> findbyCarBrand(String carBrand);
 public List<CarDTO> findbyCarPrice(String carPrice);
 public List<String> getBrand();
 public List<String> getPrice();
 
 
 
}
