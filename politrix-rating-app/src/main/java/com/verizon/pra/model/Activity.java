package com.verizon.pra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "activity")

public class Activity {
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="pId" )
	private Politician politicians;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityId;
	
	public Politician getPoliticians() {
		return politicians;
	}

	public void setPoliticians(Politician politicians) {
		this.politicians = politicians;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	@NotEmpty
	private String actName;
	
	private String actDescription;


	public Activity() {
		super();
	}

	public Activity( String actName, String actDescription) {
		super();
		
		this.actName = actName;
		this.actDescription = actDescription;
	}
	

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActDescription() {
		return actDescription;
	}

	public void setActDescription(String actDescription) {
		this.actDescription = actDescription;
	}	

}
