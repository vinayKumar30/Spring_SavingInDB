package com.org.xworkz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Entity
@Table(name = "Movie_Details")
@Data
public class MovieEntity implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "movie")
	private String movieName;
	@Column(name = "director")
	private String directorName;
	@Column(name = "year")
	private String year;

	public MovieEntity() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public MovieEntity(String movieName, String directorName, String year) {
		super();
		this.movieName = movieName;
		this.directorName = directorName;
		this.year = year;
	}

}
