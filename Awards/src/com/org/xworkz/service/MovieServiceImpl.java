package com.org.xworkz.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.xworkz.dao.MovieDAO;
import com.org.xworkz.dto.MovieDTO;
import com.org.xworkz.entity.MovieEntity;

@Service
public class MovieServiceImpl implements MovieServiceDAO {

	@Autowired
	private MovieDAO movieServiceDAO;

	public MovieServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public boolean ValidateAndSave(MovieDTO movieDTO) {

		try {
			System.out.println("Invoked ValidateAndSave() method" + movieDTO);
			boolean valid = true;

			if (Objects.nonNull(movieDTO)) {
				System.out.println("Starting Validation...");
				String movieName = movieDTO.getMovieName();
				if (movieName != null && !movieName.isEmpty() && movieName.length() >= 5) {
					System.out.println("Name is valid");
					valid = true;
				} else {
					System.out.println("movie Name is not valid");
					if (movieName == null) {
						System.out.println("No value given for movie name");
					}
					if (movieName != null && movieName.length() < 5) {
						System.out.println("value given is less than 5 for movie name");
					}
					valid = false;
				}

				String year = movieDTO.getYear();
				if (valid && year != null && !year.isEmpty() && year.length() >= 4) {
					System.out.println("year is valid");
					valid = true;
				} else {
					System.out.println("year is not valid");
					if (year == null) {
						System.out.println("No value given for year");
					}
					if (year != null && year.length() < 4) {
						System.out.println("value given is less than 4 for year");
					}
					valid = false;
				}

				String directorName = movieDTO.getDirectorName();
				if (valid && directorName != null && !directorName.isEmpty() && directorName.length() >= 5) {
					System.out.println("Director name is valid");
					valid = true;
				} else {
					System.out.println("Director Name is not valid");
					if (directorName == null) {
						System.out.println("No value given for director name");
					}
					if (directorName != null && directorName.length() < 5) {
						System.out.println("value given is less than 5 for director name");
					}
					valid = false;
				}

			}

			if (valid) {
				System.out.println("DATA IS VALID,CONVERTING INTO ENTITY");
				MovieEntity movieEntity = new MovieEntity();
				BeanUtils.copyProperties(movieDTO, movieEntity);
				System.out.println("entity is saved \t" + movieEntity);
				movieServiceDAO.save(movieEntity);
			}
			// return valid;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}
		return false;
	}

}
