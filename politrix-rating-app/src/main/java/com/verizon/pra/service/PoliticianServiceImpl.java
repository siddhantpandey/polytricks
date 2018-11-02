package com.verizon.pra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.pra.dao.PoliticianRepository;
import com.verizon.pra.model.Party;
import com.verizon.pra.model.Politician;

@Service
public class PoliticianServiceImpl implements PoliticianService {

	@Autowired
	PoliticianRepository polRepo;

	@Autowired
	private PartyService partySer;
	
	@Autowired
	private StatisticsService statService;
	
	
	@Override
	public Politician getByPId(long pId) {
		Politician pol = null;
		Optional<Politician> optPol = polRepo.findById(pId);
		if (optPol.isPresent()) {
			pol = optPol.get();
		}
		return pol;
	}

	@Override
	public Politician addPolitician(Politician politician) {
		return polRepo.save(politician);
	}

	@Override
	public Politician getByPName(String pName) {
		return polRepo.getByPName(pName);
	}

	@Override
	public List<Politician> getByPParlConstituency(String pParlConstituency) {
		return polRepo.getByPParlConstituency(pParlConstituency);
	}

	@Override
	public List<Politician> getByPStateConstituency(String pStateConstituency) {
		return polRepo.getByPStateConstituency(pStateConstituency);
	}

	@Override
	public List<Politician> getAllByPState(String pState) {
		return polRepo.getAllByPState(pState);
	}

	@Override
	public List<Politician> getAllByPParty(String pPartyName) {
		Party party = null;
		party = partySer.getAllDetailsByName(pPartyName);
		return party.getPartyMembers();
	}

	@Override
	public List<Politician> getAllPoliticians() {
		return polRepo.findAll();
	}

	@Override
	public List<Politician> getAllPoliticiansForDisplay() {
		statService.setAllStatistics();
		return polRepo.findAll();
	}

	

}
