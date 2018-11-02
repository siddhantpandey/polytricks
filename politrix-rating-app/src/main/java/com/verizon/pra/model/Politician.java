package com.verizon.pra.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Politicians")
public class Politician {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pId;

	@NotEmpty
	private String pName;
	
	@NotNull
	private int pAge;

	@Enumerated(EnumType.STRING)
	private Gender pGender;

	@NotEmpty
	private String pEducation;
	
	@NotNull
	private double pAssets;

	@NotEmpty
	private String pProfession;
	
	@NotNull
	private long pIncome;

	@NotEmpty
	private String pState;

	private String pParlConstituency;
	private String pStateConstituency;

	@NotNull
	private LocalDate pActiveSince;

	@Enumerated(EnumType.STRING)
	private Status pStatus;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "pParty")
	private Party pParty;
	
	
	@OneToMany(mappedBy = "politician", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "politicians", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Activity> activities;
	
	@OneToOne( mappedBy="politician", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
	private Statistics stats;

	public Politician() {
		super();
	}

	

	public Politician(long pId, @NotEmpty String pName, @NotNull int pAge, Gender pGender, @NotEmpty String pEducation,
			@NotNull double pAssets, @NotEmpty String pProfession, @NotNull long pIncome, @NotEmpty String pState,
			String pParlConstituency, String pStateConstituency, @NotNull LocalDate pActiveSince, Status pStatus,
			@NotNull Party pParty, List<Comment> comments, List<Activity> activities, Statistics stats) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pAge = pAge;
		this.pGender = pGender;
		this.pEducation = pEducation;
		this.pAssets = pAssets;
		this.pProfession = pProfession;
		this.pIncome = pIncome;
		this.pState = pState;
		this.pParlConstituency = pParlConstituency;
		this.pStateConstituency = pStateConstituency;
		this.pActiveSince = pActiveSince;
		this.pStatus = pStatus;
		this.pParty = pParty;
		this.comments = comments;
		this.activities = activities;
		this.stats = stats;
	}



	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpAge() {
		return pAge;
	}

	public void setpAge(int pAge) {
		this.pAge = pAge;
	}

	public Gender getpGender() {
		return pGender;
	}

	public void setpGender(Gender pGender) {
		this.pGender = pGender;
	}

	public String getpEducation() {
		return pEducation;
	}

	public void setpEducation(String pEducation) {
		this.pEducation = pEducation;
	}

	public double getpAssets() {
		return pAssets;
	}

	public void setpAssets(double pAssets) {
		this.pAssets = pAssets;
	}

	public String getpProfession() {
		return pProfession;
	}

	public void setpProfession(String pProfession) {
		this.pProfession = pProfession;
	}

	public long getpIncome() {
		return pIncome;
	}

	public void setpIncome(long pIncome) {
		this.pIncome = pIncome;
	}

	public String getpState() {
		return pState;
	}

	public void setpState(String pState) {
		this.pState = pState;
	}

	public String getpParlConstituency() {
		return pParlConstituency;
	}

	public void setpParlConstituency(String pParlConstituency) {
		this.pParlConstituency = pParlConstituency;
	}

	public String getpStateConstituency() {
		return pStateConstituency;
	}

	public void setpStateConstituency(String pStateConstituency) {
		this.pStateConstituency = pStateConstituency;
	}

	public LocalDate getpActiveSince() {
		return pActiveSince;
	}

	public void setpActiveSince(LocalDate pActiveSince) {
		this.pActiveSince = pActiveSince;
	}

	public Status getpStatus() {
		return pStatus;
	}

	public void setpStatus(Status pStatus) {
		this.pStatus = pStatus;
	}

	public Party getpParty() {
		return pParty;
	}

	public void setpParty(Party pParty) {
		this.pParty = pParty;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public List<Activity> getActivities() {
		return activities;
	}



	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}



	public Statistics getStats() {
		return stats;
	}



	public void setStats(Statistics stats) {
		this.stats = stats;
	}
	
	

}
