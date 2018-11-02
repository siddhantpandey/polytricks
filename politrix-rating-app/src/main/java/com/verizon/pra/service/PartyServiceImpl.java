package com.verizon.pra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.pra.dao.PartyRepository;
import com.verizon.pra.model.Party;

@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository partyRepo;

	@Override
	public Party getAllDetailsByName(String partyName) {

		Optional<Party> optParty = partyRepo.findById(partyName);

		Party p1 = null;
		if (optParty.isPresent()) {
			p1 = optParty.get();
		}
		return p1;
	}

	@Override
	public Party addPartyDetails(Party party) {
		return partyRepo.save(party);
	}

	@Override
	public Party updatePartyDetails(Party party) {
		return partyRepo.save(party);
	}

	@Override
	public boolean deletePartyDetails(String partyName) {
		boolean isDeleted = false;
		if (partyRepo.existsById(partyName)) {
			partyRepo.deleteById(partyName);
			isDeleted = true;
		}
		return isDeleted;

	}

	@Override
	public List<Party> getAllPartyDetails() {
		return partyRepo.findAll();
	}

	

}
