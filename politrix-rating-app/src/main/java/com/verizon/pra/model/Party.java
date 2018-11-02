package com.verizon.pra.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "parties")
public class Party {

	@Id
	@NotEmpty(message = "Party name cannot be empty")
	private String partyName;

	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Party formed date cannot be left blank")
	private LocalDate partyFormed;

	@Enumerated(EnumType.STRING)
	private PartyType partyType;

	@NotEmpty(message = "Party name cannot be empty")
	private String partyStateActive;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pParty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@NotNull(message = "There must be atleast 1 party member")
	private List<Politician> partyMembers;

	private String pStatesRuled;
	
	public Party() {
		super();
	}
	
	public Party(@NotEmpty(message = "Party name cannot be empty") String partyName,
			@NotNull(message = "Party formed date cannot be left blank") LocalDate partyFormed, PartyType partyType,
			@NotEmpty(message = "Party name cannot be empty") String partyStateActive,
			@NotNull(message = "There must be atleast 1 party member") List<Politician> partyMembers,
			String pStatesRuled) {
		super();
		this.partyName = partyName;
		this.partyFormed = partyFormed;
		this.partyType = partyType;
		this.partyStateActive = partyStateActive;
		this.partyMembers = partyMembers;
		this.pStatesRuled = pStatesRuled;
	}



	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public LocalDate getPartyFormed() {
		return partyFormed;
	}

	public void setPartyFormed(LocalDate partyFormed) {
		this.partyFormed = partyFormed;
	}

	public PartyType getPartyType() {
		return partyType;
	}

	public void setPartyType(PartyType partyType) {
		this.partyType = partyType;
	}

	public String getPartyStateActive() {
		return partyStateActive;
	}

	public void setPartyStateActive(String partyStateActive) {
		this.partyStateActive = partyStateActive;
	}

	
	public List<Politician> getPartyMembers() {
		return partyMembers;
	}

	public void setPartyMembers(List<Politician> partyMembers) {
		this.partyMembers = partyMembers;
	}

	public String getpStatesRuled() {
		return pStatesRuled;
	}

	public void setpStatesRuled(String pStatesRuled) {
		this.pStatesRuled = pStatesRuled;
	}

}
