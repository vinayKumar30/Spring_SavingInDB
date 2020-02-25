package com.org.xworkz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.xworkz.dao.ActorDAO;
import com.org.xworkz.dao.AwardDAO;
import com.org.xworkz.dto.ActorDTO;
import com.org.xworkz.entity.ActorEntity;
import com.org.xworkz.service.ActorServiceDAO;

@Controller
@RequestMapping("/")
public class ActorController {

	@Autowired
	private ActorServiceDAO servicedao;

	@Autowired
	private ActorDAO dao;

	public ActorController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/actor.do")
	public String onActor(ActorDTO actorDTO, ActorEntity entity, ModelMap map) {
		try {
			System.out.println("Invoked onActor() method");
			System.out.println(actorDTO);

			/*
			 * boolean check = this.servicedao.ValidateAndSave(actorDTO); if (check) {
			 * ModelMap suc = map.addAttribute("successMessage", "Success:Data Saved"); }
			 * else { ModelMap fail = map.addAttribute("failureMessage",
			 * "Failure:Data not Saved"); }
			 */

			int v = this.dao.save(entity);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}
		return "/ActorForm.jsp";
	}

}
