package com.verizon.pra.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.pra.model.Politician;
import com.verizon.pra.model.Statistics;
import com.verizon.pra.service.StatisticsService;

@CrossOrigin
@RestController
@RequestMapping("/stats")
public class StatisticsApi {

	@Autowired
	private StatisticsService statService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Statistics> getStatistics(@PathVariable("id") long pId) {
		ResponseEntity<Statistics> resp = null;
		
		Statistics polStats = statService.getStatisticsByPolitician(pId);
		
		if(polStats != null)
			resp = new ResponseEntity<>(polStats, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return resp;
	}
	
	
	@GetMapping()
	public ResponseEntity<List<Statistics>> getAllStatistics() {
		
		ResponseEntity<List<Statistics>> resp = null;
		List<Statistics> stat = statService.getAllStatistics();	
		
		resp  = new ResponseEntity<>(stat, HttpStatus.OK);
		
		return resp;
		
	}
	
	
	
	@GetMapping("/popular")
	public ResponseEntity<List<Politician>> getPopularPoliticians() {
		
		ResponseEntity<List<Politician>> resp = null;
		List<Statistics> statistics = statService.getAllStatistics();
		List<Politician> politicians = new ArrayList<>();
		
		for(int i=0; i<statistics.size(); i++) {
			if(i == 5)
				break;
			politicians.add(statistics.get(i).getPolitician());
		}
		
		resp = new ResponseEntity<>(politicians, HttpStatus.OK);
		return resp;
		
	}
	
	
	@GetMapping("/totalCount")
	public ResponseEntity<List<Integer>> getTotalLikeDislikeCount() {
		ResponseEntity<List<Integer>> resp = null;
		
		int likeCount = 0;
		int dislikeCount = 0;
		
		List<Integer> ls = new ArrayList<>();
		
		List<Statistics> stats = statService.getAllStatistics();
		
		for(Statistics stat: stats) {
			likeCount += stat.getLikeCount();
			dislikeCount += stat.getDislikeCount();
		}
		
		ls.add(likeCount);
		ls.add(dislikeCount);
		
		resp = new ResponseEntity<>(ls, HttpStatus.OK);
		return resp;
		
	}
	
	
}
