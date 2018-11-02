package com.verizon.pra.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.pra.dao.PoliticianRepository;
import com.verizon.pra.model.Politician;
import com.verizon.pra.service.PoliticianService;

@RestController
@CrossOrigin
@RequestMapping("/politician")
public class PoliticianApi {

	@Autowired
	PoliticianService service;

	@GetMapping("/{pState}")
	public ResponseEntity<List<Politician>> getAllPoliticianByPState(@PathVariable("pState") String pState) {

		ResponseEntity<List<Politician>> resp = null;

		List<Politician> politicians = service.getAllByPState(pState);

		if (politicians != null)
			resp = new ResponseEntity<>(politicians, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Politician> getPoliticianById(@PathVariable("id") long id) {
		ResponseEntity<Politician> resp = null;
		System.out.println("123");
		Politician pol = service.getByPId(id);
		if (pol != null) {
			resp = new ResponseEntity<Politician>(pol, HttpStatus.OK);
		} else
			resp = new ResponseEntity<Politician>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@GetMapping("/{field}/{srchVal}")
	public ResponseEntity<List<Politician>> getPoliticianByName(@PathVariable("field") String fieldBy,
			@PathVariable("srchVal") String searchValue) {

		ResponseEntity<List<Politician>> resp = null;
		switch (fieldBy) {
		case "pName":
			Politician pol = service.getByPName(searchValue);
			if (pol != null) {
				resp = new ResponseEntity<>(Collections.singletonList(pol), HttpStatus.OK);
			} else
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			break;
			
		case "pState":
			List<Politician> polListByState=service.getAllByPState(searchValue);
			if(polListByState!=null)
				resp=new ResponseEntity<List<Politician>>(polListByState, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			break;
			
		case "pParlConstituency":
			List<Politician> polListByPConstituency=service.getByPParlConstituency(searchValue);
			if(polListByPConstituency!=null)
				resp=new ResponseEntity<List<Politician>>(polListByPConstituency, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			break;
			
		case "pStateConstituency":
			List<Politician> polListBySConstituency=service.getByPStateConstituency(searchValue);
			if(polListBySConstituency!=null)
				resp=new ResponseEntity<List<Politician>>(polListBySConstituency, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			break;
			
		case "pParty":
			List<Politician> polListByParty=service.getAllByPParty(searchValue);
			if(polListByParty!=null)
				resp=new ResponseEntity<List<Politician>>(polListByParty, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			break;		
			
		}
		return resp;		

	}
	
	@PostMapping
	public ResponseEntity<Politician> addPolitician(@RequestBody Politician politician){
		ResponseEntity<Politician> resp=null;
		Politician pol=service.addPolitician(politician);
		if(pol!=null)
			resp=new ResponseEntity<Politician>(pol, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
	

	
	@GetMapping
	public ResponseEntity<List<Politician>> getAllPoliticians() {
		return new ResponseEntity<>(service.getAllPoliticiansForDisplay(), HttpStatus.OK);
	}
	
}
