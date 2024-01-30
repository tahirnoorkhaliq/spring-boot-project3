package com.tahir.darkcodder.best.choice.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tahir.darkcodder.best.choice.model.CarDTO;
import com.tahir.darkcodder.best.choice.model.CarDetails;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;
	
	@Override
	public CarDTO save(CarDTO carDTO) {
		System.out.println("MovieDTO: "+carDTO);		
		//if(!movieRepository.existsById(carDTO.getBrand())){
			return new ModelMapper().map(carRepository.save(new ModelMapper().map(carDTO,CarDetails.class)),CarDTO.class);
		//}else {
		//	throw new AlreadyInitializedException("Record Already Available with this Id");
		//}
		
	}

	@Override
	public List<CarDTO> getAllCars() {
		return Arrays.asList(new ModelMapper().map(carRepository.findAll(), CarDTO[].class));		
	}

	
	@Override
	public List<CarDTO> findbyCarBrand(String carBrand) {
		return Arrays.asList(new ModelMapper().map(carRepository.findByBrand(carBrand), CarDTO[].class));		
	}

	@Override
	public List<CarDTO> findbyCarPrice(String carPrice) {
		// TODO Auto-generated method stub
		return Arrays.asList(new ModelMapper().map(carRepository.findByPriceLessThanEqual(carPrice), CarDTO[].class));
	}

	@Override
	public List<String> getBrand() {
		return carRepository.getBrand();
		//return null;
	}

	@Override
	public List<String> getPrice() {
		return carRepository.getPrice();
		//return null;
	}

	@Override
	public CarDTO getCar(long carId) {
		// TODO Auto-generated method stub
		return new ModelMapper().map(carRepository.findByCarId(carId), CarDTO.class);
	}

}
