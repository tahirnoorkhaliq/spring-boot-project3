package com.tahir.darkcodder.best.choice.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tahir.darkcodder.best.choice.model.CarDetails;



public interface CarRepository extends CrudRepository<CarDetails, Long> {
	
	
	List<CarDetails> findByBrand(String carBrand);
	CarDetails findByCarId(Long carId);
	List<CarDetails> findByPriceLessThanEqual(String carPrice);	
	@Query(value="SELECT distinct Brand FROM CARDETAILS", 
			  nativeQuery = true)
	List<String> getBrand();
	@Query(value="SELECT distinct Price FROM CARDETAILS", 
			  nativeQuery = true)
	List<String> getPrice();
	
}
