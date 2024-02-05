package com.tahir.darkcodder.movflex.model;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MovieDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5555336139477712407L;
	
	@NotNull(message = "movieId Can't be empty")
	@Size(min = 1, max = 16, message = "movieId Can't be less than 1 ot greater than 16 chars")
	private String movieId;
	@NotNull(message = "movieName Can't be empty")
	@Size(min = 1, max = 16, message = "movieName Can't be less than 1 ot greater than 16 chars")
	private String movieName;
	@NotNull(message = "Movie Collection Can't be empty")
	@Min(1)	
	private Long movieCollection;
	

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Long getMovieCollection() {
		return movieCollection;
	}

	public void setMovieCollection(Long movieCollection) {
		this.movieCollection = movieCollection;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", movieCollection=" + movieCollection
				+ "]";
	}

}
