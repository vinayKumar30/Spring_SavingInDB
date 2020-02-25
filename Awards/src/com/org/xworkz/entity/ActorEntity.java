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
@Table(name = "actor_details")
@Data
public class ActorEntity implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "leadActor")
	private String leadActorName;
	@Column(name = "SupportingLead")
	private String leadSupportingActorName;

	public ActorEntity() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public ActorEntity(String leadActorName, String leadSupportingActorName) {
		super();
		System.out.println("Parameterized Constructor \t" + this.getClass().getSimpleName());
		this.leadActorName = leadActorName;
		this.leadSupportingActorName = leadSupportingActorName;
	}

}
