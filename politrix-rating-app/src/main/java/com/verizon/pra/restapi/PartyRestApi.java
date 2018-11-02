package com.verizon.pra.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.pra.model.Party;
import com.verizon.pra.service.PartyService;

@RestController
@CrossOrigin
@RequestMapping("/parties")
public class PartyRestApi {

	@Autowired
	private PartyService partyService;

	@GetMapping
	public ResponseEntity<List<Party>> getAllPartyDetails() {

		return new ResponseEntity<>(partyService.getAllPartyDetails(), HttpStatus.OK);
	}

	@GetMapping("/{partyName}")
	public ResponseEntity<Party> getPartyDetailsByName(@PathVariable("partyName") String partyName) {

		ResponseEntity<Party> resp = null;

		Party p1 = partyService.getAllDetailsByName(partyName);
		if (p1 != null) {
			resp = new ResponseEntity<Party>(p1, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<Party>(HttpStatus.NOT_FOUND);
		}
		return resp;
	}

	@PostMapping
	public ResponseEntity<Party> addPartyDetails(@RequestBody Party party) {

		ResponseEntity<Party> resp = null;

		Party p1 = partyService.addPartyDetails(party);
		if (p1 != null) {
			resp = new ResponseEntity<Party>(p1, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<Party>(HttpStatus.NOT_FOUND);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Party> updatePartyDetails(@RequestBody Party party) {

		ResponseEntity<Party> resp = null;

		Party p1 = partyService.updatePartyDetails(party);
		if (p1 != null) {
			resp = new ResponseEntity<Party>(p1, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<Party>(HttpStatus.NOT_FOUND);
		}
		return resp;
	}

	@DeleteMapping("/{partyName}")
	public ResponseEntity<Party> deletePartyDetails(@PathVariable("partyName") String partyName) {

		ResponseEntity<Party> resp = null;

		boolean p1 = partyService.deletePartyDetails(partyName);
		if (p1) {
			resp = new ResponseEntity<Party>(HttpStatus.OK);
		} else {
			resp = new ResponseEntity<Party>(HttpStatus.NOT_FOUND);
		}
		return resp;
	}

}
