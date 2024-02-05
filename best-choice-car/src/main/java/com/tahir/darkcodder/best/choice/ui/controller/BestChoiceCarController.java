package com.tahir.darkcodder.best.choice.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.exceptions.AlreadyInitializedException;

import com.tahir.darkcodder.best.choice.model.CarDTO;
import com.tahir.darkcodder.best.choice.model.User;
import com.tahir.darkcodder.best.choice.service.CarService;

import jakarta.validation.Valid;

@Controller
public class BestChoiceCarController {

	@Autowired
	CarService carService;

	@PostMapping("/book-car")
	public String bookCar(@Valid @ModelAttribute("carDTO") CarDTO carDTO, BindingResult result, Model model) {
		System.out.println("carDTO "+carDTO);
		model.addAttribute("carDTO",carService.getCar(carDTO.getCarId()));
		return "booked-car";
	}

	@GetMapping("/index")
	public String view() {
		return "index";
	}
	
	@GetMapping("/search/{searchVar}")
	public String search(@ModelAttribute("carDTO") CarDTO carDTO, @PathVariable String searchVar, Model model) {
		List<String> options;
		if (searchVar.equals("carBrand")) {
			options = carService.getBrand();
			model.addAttribute("brands", options);
			model.addAttribute("carBrand", Boolean.TRUE);
		} else if (searchVar.equals("carPrice")) {
			options = carService.getPrice();
			model.addAttribute("prices", options);
			model.addAttribute("carPrice", Boolean.TRUE);
		}
		return "search";
	}

	@GetMapping("/search-car")
	public String searchById(@ModelAttribute("carDTO") CarDTO carDTO, Model model) {
		System.out.println("carDTO :"+carDTO);
		List<CarDTO> cars =null;
		List<String> options;
		if(null!=carDTO.getBrand()) {
			cars=carService.findbyCarBrand(carDTO.getBrand());
			options = carService.getBrand();
			model.addAttribute("brands", options);
			model.addAttribute("carBrand", Boolean.TRUE);			
		}else if(null!=carDTO.getPrice()) {
			options = carService.getPrice();
			model.addAttribute("prices", options);
			cars=carService.findbyCarPrice(carDTO.getPrice());
			model.addAttribute("carPrice", Boolean.TRUE);
		}		
		model.addAttribute("carDTOs", cars);
		System.out.println("carDTOs:==> "+cars);
		return "search";
	}
	
	
	@GetMapping("/modify")
	public String modify() {
		return "modify";
	}
	
	
	@ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {        
        return "error";
    }
	
	
	/*

	@GetMapping("/login")
	public String showSignUpForm(@ModelAttribute("user") User user) {		
		return "sign-in";
	}

	@PostMapping("/signin")
	public String signin(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {			
		if (result.hasErrors()) {
			return "sign-in";
		} else {
			if (user.getEmail().equalsIgnoreCase("stella@gmail.com") && user.getPassword().equalsIgnoreCase("stella")) {
				model.addAttribute("carDTO", new CarDTO());
				model.addAttribute("carDTOs", carService.getAllCars());
				return "add-car";
			}else {		
				result.rejectValue("email","", "Invalid email");				
				result.rejectValue("password","", "Invalid password");
			}
		}
		
		return "sign-in";
	}

	@PostMapping("/addCar")
	public String addUser(@Valid @ModelAttribute("carDTO") CarDTO carDTO, BindingResult result, Model model) {
		System.out.println("carDTO "+carDTO);
		if (result.hasErrors()) {
			return "add-car";
		} else {
			try {
				carService.save(carDTO);
				model.addAttribute("carAdded", Boolean.TRUE);
			} catch (AlreadyInitializedException e) {
				result.rejectValue("carBrand", "", e.getMessage());
			}			
		}
		model.addAttribute("carDTOs", carService.getAllCars());
		return "add-car";
	}
	*/
	
}
