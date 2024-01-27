package com.tahir.darkcodder.movflex.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie-details")
public class MovieDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2533464507878391463L;

	@Id
	private String movieId;
	@Column(nullable = false, length = 100)
	private String movieName;
	@Column(nullable = false, length = 100)
	private long movieCollection;	

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

	public long getMovieCollection() {
		return movieCollection;
	}

	public void setMovieCollection(long movieCollection) {
		this.movieCollection = movieCollection;
	}

	@Override
	public String toString() {
		return "MovieDetails [movieId=" + movieId + ", movieName=" + movieName + ", movieCollection=" + movieCollection
				+ "]";
	}

}
