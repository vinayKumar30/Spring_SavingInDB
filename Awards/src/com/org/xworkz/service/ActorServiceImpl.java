package com.org.xworkz.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.xworkz.dao.ActorDAO;
import com.org.xworkz.dto.ActorDTO;
import com.org.xworkz.entity.ActorEntity;
import com.org.xworkz.entity.MovieEntity;

@Service
public class ActorServiceImpl implements ActorServiceDAO {
	@Autowired
	private ActorDAO dao;

	public ActorServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public boolean ValidateAndSave(ActorDTO actorDTO) {
		System.out.println("Invoked ValidateAndSave() from ActorServiceImpl");
		try {
			boolean valid = false;
			if (Objects.nonNull(actorDTO)) {
				System.out.println("Starting Validatation...");
				String leadActorName = actorDTO.getLeadActorName();
				if (leadActorName != null && !leadActorName.isEmpty() && leadActorName.length() >= 5) {
					System.out.println("lead name is valid");
					valid = true;
				} else {
					System.out.println("lead name is not valid");
					if (leadActorName == null) {
						System.out.println("No value given for name");
					}
					if (leadActorName != null && leadActorName.length() < 5) {
						System.out.println("leadActorName is less than 5");
					}
					valid = false;
				}

				String leadSupportingActorName = actorDTO.getLeadSupportingActorName();
				if (leadSupportingActorName != null && !leadSupportingActorName.isEmpty()
						&& leadSupportingActorName.length() >= 5) {
					System.out.println("lead supporting actor name is valid");
					valid = true;
				} else {
					System.out.println("lead supporting actor name is not valid");
					if (leadSupportingActorName == null) {
						System.out.println("No value given for name");
					}
					if (leadSupportingActorName != null && leadSupportingActorName.length() < 5) {
						System.out.println("leadSupportingActorName is less than 5");
					}
					valid = false;
				}
			}
			//return valid;

			if (valid) {
				System.out.println("DATA IS VALID,CONVERTING INTO ENTITY");
				ActorEntity actorEntity = new ActorEntity();
				BeanUtils.copyProperties(actorDTO, actorEntity);
				System.out.println("entity is saved \t" + actorEntity);
				dao.save(actorEntity);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}
		return false;
	}

}
