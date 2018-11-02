package com.verizon.pra.service;

import java.util.List;

import com.verizon.pra.model.Politician;

public interface PoliticianService {
	
	Politician getByPId(long pId);
	
	Politician addPolitician(Politician politician);
	
	Politician getByPName(String pName);
	
	List<Politician> getAllPoliticians();
	
	List<Politician> getByPParlConstituency(String pParlConstituency);
	
	List<Politician> getByPStateConstituency(String pStateConstituency);
	
	List<Politician> getAllByPState(String pState);
	
	List<Politician> getAllByPParty(String pPartyName);

	List<Politician> getAllPoliticiansForDisplay();
	
}
