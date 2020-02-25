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
@Table(name = "Award_details")
@Data
public class AwardEntity implements Serializable {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "award")
	private String awardName;
	@Column(name = "sponser")
	private String sponser;
	@Column(name = "gift")
	private String gift;

	public AwardEntity() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public AwardEntity(String awardName, String sponser, String gift) {
		super();
		this.awardName = awardName;
		this.sponser = sponser;
		this.gift = gift;
	}

}
