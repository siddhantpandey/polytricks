package com.verizon.pra.service;

import java.util.List;

import com.verizon.pra.model.Party;

public interface PartyService {

	List<Party> getAllPartyDetails();

	Party getAllDetailsByName(String partyName);

	Party addPartyDetails(Party party);

	Party updatePartyDetails(Party party);
	

	boolean deletePartyDetails(String partyName);

}
