package com.tahir.darkcodder.movflex.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tahir.darkcodder.movflex.model.MovieDetails;



public interface MovieRepository extends CrudRepository<MovieDetails, String> {
	
	
	List<MovieDetails> findByMovieName(String movieName);
	List<MovieDetails> findByMovieCollection(long movieCollection);
}
