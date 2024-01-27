package com.tahir.darkcodder.movflex.ui.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.AlreadyInitializedException;

import com.tahir.darkcodder.movflex.model.MovieDTO;
import com.tahir.darkcodder.movflex.model.User;
import com.tahir.darkcodder.movflex.service.MovieService;

import jakarta.validation.Valid;

@Controller
public class MovieLibraryController {

	@Autowired
	MovieService movieService;

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
				model.addAttribute("movieDTO", new MovieDTO());
				model.addAttribute("movieDTOs", movieService.getAllMovies());
				return "add-movie";
			}else {		
				result.rejectValue("email","", "Invalid email");				
				result.rejectValue("password","", "Invalid password");
			}
		}
		
		return "sign-in";
	}

	@PostMapping("/addMovie")
	public String addUser(@Valid @ModelAttribute("movieDTO") MovieDTO movieDTO, BindingResult result, Model model) {
		System.out.println("movieDTO "+movieDTO);
		if (result.hasErrors()) {
			return "add-movie";
		} else {
			try {
				movieService.save(movieDTO);
				model.addAttribute("movieAdded", Boolean.TRUE);
			} catch (AlreadyInitializedException e) {
				result.rejectValue("movieId", "", e.getMessage());
			}			
		}
		model.addAttribute("movieDTOs", movieService.getAllMovies());
		return "add-movie";
	}

	@GetMapping("/index")
	public String view() {
		return "index";
	}
	
	@GetMapping("/search/{searchVar}")
	public String search( @ModelAttribute("movieDTO") MovieDTO movieDTO, @PathVariable String searchVar,Model model) {	
		if(searchVar.equals("id")) {
			model.addAttribute("movieId", Boolean.TRUE);
		}else if(searchVar.equals("name")) {
			model.addAttribute("movieName", Boolean.TRUE);
		}else if(searchVar.equals("collection")) {
			model.addAttribute("movieCollection", Boolean.TRUE);
		}
		return "search";
	}
	
	@GetMapping("/search-movie")
	public String searchById(@ModelAttribute("movieDTO") MovieDTO movieDTO, Model model) {
		System.out.println("movieDTO :"+movieDTO);
		List<MovieDTO> movies =null;
		if(null!=movieDTO.getMovieId()) {
			movies=movieService.findbyMovieId(movieDTO.getMovieId());
			model.addAttribute("movieId", Boolean.TRUE);			
		}else if(null!=movieDTO.getMovieName()) {
			movies=movieService.findbyMovieName(movieDTO.getMovieName());
			model.addAttribute("movieName", Boolean.TRUE);
		}else if(movieDTO.getMovieCollection()>0) {
			movies=movieService.findbyMovieCollection(movieDTO.getMovieCollection());
			model.addAttribute("movieCollection", Boolean.TRUE);
		}		
		
		model.addAttribute("movieDTOs", movies);
		if(null==movies) {
			model.addAttribute("hideTable", Boolean.TRUE);
		}
		System.out.println("movieDTOs:==> "+movies);
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
}
