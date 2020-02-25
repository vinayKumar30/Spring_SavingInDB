package com.org.xworkz.service;

import com.org.xworkz.dto.MovieDTO;
import com.org.xworkz.entity.MovieEntity;

public interface MovieServiceDAO {
	
	public boolean ValidateAndSave(MovieDTO movieDTO);

}
