package com.verizon.pra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.pra.model.Politician;

@Repository
public interface PoliticianRepository extends JpaRepository<Politician, Long> {
	
	Politician getByPName(String pName);
	
	List<Politician> getByPParlConstituency(String pParlConstituency);
	
	List<Politician> getByPStateConstituency(String pStateConstituency);
	
	List<Politician> getAllByPState(String pState);
	
	List<Politician> getAllByPParty(String pPartyName);
}
