package com.tahir.darkcodder.movflex.ui.controller;

import java.util.ArrayList;
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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MovieLibraryController {

	@Autowired
	MovieService movieService;

	@GetMapping("/login")
	public String showSignUpForm(@ModelAttribute("user") User user) {
		return "sign-in";
	}

	@GetMapping("/signin")
	public String signIn(Model model, HttpSession session, @ModelAttribute("movieDTO") MovieDTO movieDTO) {
		List<String> messages = (List<String>) session.getAttribute("Email_SESSION");
		if (messages == null) {
			model.addAttribute("user",new User());
			return "redirect:/login";
		}
		model.addAttribute("movieDTOs", movieService.getAllMovies());
		return "add-movie";		
	}
	
	
	
	@PostMapping("/signin")
	public String signin(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,HttpServletRequest request) {
		if (result.hasErrors()) {
			return "sign-in";
		} else {
			if (user.getEmail().equalsIgnoreCase("stella@gmail.com") && user.getPassword().equalsIgnoreCase("stella")) {
				List<String> emailSession = (List<String>) request.getSession().getAttribute("Email_SESSION");
				if (emailSession == null) {
					emailSession = new ArrayList<>();
					request.getSession().setAttribute("Email_SESSION", emailSession);
				}
				emailSession.add(user.getEmail());
				request.getSession().setAttribute("Email_SESSION", emailSession);
				model.addAttribute("movieDTO", new MovieDTO());
				model.addAttribute("movieDTOs", movieService.getAllMovies());
				return "add-movie";
			} else {
				result.rejectValue("email", "", "Email not valid");
				result.rejectValue("password", "", "Password not valid");
			}
		}

		return "sign-in";
	}

	@GetMapping("/addMovie")
	public String process(Model model, HttpSession session, @ModelAttribute("movieDTO") MovieDTO movieDTO) {
		List<String> messages = (List<String>) session.getAttribute("Email_SESSION");
		if (messages == null) {
			model.addAttribute("user",new User());
			return "redirect:/login";
		}	
		model.addAttribute("movieDTOs", movieService.getAllMovies());
		return "add-movie";	
	}
	
	@PostMapping("/addMovie")
	public String addUser(@Valid @ModelAttribute("movieDTO") MovieDTO movieDTO, BindingResult result, Model model,HttpSession session) {
		System.out.println("movieDTO " + movieDTO);
		List<String> messages = (List<String>) session.getAttribute("Email_SESSION");
		if (messages == null) {
			model.addAttribute("user",new User());
			return "redirect:/login";
		}	
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
	public String search(@ModelAttribute("movieDTO") MovieDTO movieDTO, @PathVariable String searchVar, Model model) {
		System.out.println("movieDTO :" + movieDTO);
		if (searchVar.equals("id")) {
			model.addAttribute("id", Boolean.TRUE);
		} else if (searchVar.equals("name")) {
			model.addAttribute("name", Boolean.TRUE);
		} else if (searchVar.equals("collection")) {
			model.addAttribute("collection", Boolean.TRUE);
		}
		return "search";
	}

	@GetMapping("/search-movie")
	public String searchById(@ModelAttribute("movieDTO") MovieDTO movieDTO, Model model) {
		List<MovieDTO> movies = null;
		if (null != movieDTO.getMovieId()) {
			movies = movieService.findbyMovieId(movieDTO.getMovieId());
			model.addAttribute("id", Boolean.TRUE);
			if (null == movies || null == movies.get(0)) {
				movies = new ArrayList<>();
			}
		} else if (null != movieDTO.getMovieName()) {
			movies = movieService.findbyMovieName(movieDTO.getMovieName());
			model.addAttribute("name", Boolean.TRUE);
			if (null == movies || movies.isEmpty()) {
				movies = new ArrayList<>();
			}
		} else {
			movies = movieService.findbyMovieCollection(movieDTO.getMovieCollection());
			model.addAttribute("collection", Boolean.TRUE);
			if (null == movies || movies.isEmpty()) {
				movies = new ArrayList<>();
			}
		}

		model.addAttribute("movieDTOs", movies);
		System.out.println("movies:==> " + movies);
		return "search";
	}

	@GetMapping("/modify")
	public String modify() {
		return "modify";
	}
	
	@GetMapping("/signout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {
		System.out.println(ex.getMessage()+" "+ex);
		return "error";
	}
}
