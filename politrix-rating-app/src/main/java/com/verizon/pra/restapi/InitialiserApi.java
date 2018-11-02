package com.verizon.pra.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.pra.service.StatisticsService;

@RestController
@CrossOrigin
public class InitialiserApi {

	@Autowired
	private StatisticsService statService;
	
	
	@GetMapping
	public ResponseEntity<HttpStatus> initialiseStatisticsTable() {
		statService.setAllStatistics();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
