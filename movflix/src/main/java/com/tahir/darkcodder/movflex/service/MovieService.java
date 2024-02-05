package com.tahir.darkcodder.movflex.service;

import java.util.List;

import com.tahir.darkcodder.movflex.model.MovieDTO;

public interface MovieService {
 public MovieDTO save(MovieDTO movieDTO);
 public List<MovieDTO> getAllMovies();
 public List<MovieDTO> findbyMovieId(String movieId);
 public List<MovieDTO> findbyMovieName(String movieName);
 public List<MovieDTO> findbyMovieCollection(Long movieCollection);
 
 
}
