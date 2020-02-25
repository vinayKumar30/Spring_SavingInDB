package com.org.xworkz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.xworkz.dao.MovieDAO;
import com.org.xworkz.dto.MovieDTO;
import com.org.xworkz.entity.MovieEntity;
import com.org.xworkz.service.MovieServiceDAO;

@Controller
@RequestMapping("/")
public class MovieController {
	@Autowired
	private MovieServiceDAO movieServiceDAO;

	@Autowired
	private MovieDAO dao;

	public MovieController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/movie.do")
	public String onSubmitMyChoice(MovieDTO movieDTO, MovieEntity entity, ModelMap map) {

		try {
			System.out.println("Invoked onSubmitMyChoice() method");
			System.out.println(movieDTO);
			map.addAttribute("movieName", movieDTO.getMovieName());
			map.addAttribute("year", movieDTO.getYear());
			map.addAttribute("directorName", movieDTO.getDirectorName());

			/*
			 * boolean check = this.movieServiceDAO.ValidateAndSave(movieDTO); if (check) {
			 * 
			 * ModelMap suc = map.addAttribute("successMessage", "Success:Data Saved");
			 * 
			 * } else {
			 * 
			 * ModelMap fail = map.addAttribute("failureMessage", "Failure:Data not Saved");
			 * }
			 */

			int value = this.dao.save(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO" + e.getMessage());
		}
		return "/MovieForm.jsp";
	}

}
