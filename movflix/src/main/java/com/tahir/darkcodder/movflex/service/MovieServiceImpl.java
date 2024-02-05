package com.tahir.darkcodder.movflex.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.exceptions.AlreadyInitializedException;

import com.tahir.darkcodder.movflex.model.MovieDTO;
import com.tahir.darkcodder.movflex.model.MovieDetails;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public MovieDTO save(MovieDTO movieDTO) {
		System.out.println("MovieDTO: "+movieDTO);		
		if(!movieRepository.existsById(movieDTO.getMovieId())){
			return new ModelMapper().map(movieRepository.save(new ModelMapper().map(movieDTO,MovieDetails.class)),MovieDTO.class);
		}else {
			throw new AlreadyInitializedException("Record Already Available with this Id");
		}
		
	}

	@Override
	public List<MovieDTO> getAllMovies() {
		return Arrays.asList(new ModelMapper().map(movieRepository.findAll(), MovieDTO[].class));		
	}

	@Override
	public List<MovieDTO> findbyMovieName(String movieName) {
		return  Arrays.asList(new ModelMapper().map(movieRepository.findByMovieName(movieName), MovieDTO[].class));
	}

	@Override
	public List<MovieDTO> findbyMovieCollection(Long movieCollection) {
		return Arrays.asList(new ModelMapper().map(movieRepository.findByMovieCollection(movieCollection), MovieDTO[].class));
	}

	@Override
	public List<MovieDTO> findbyMovieId(String movieId) {		
		return  Arrays.asList(new ModelMapper().map(movieRepository.findById(movieId), MovieDTO.class));
	}

}
