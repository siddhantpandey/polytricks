package com.verizon.pra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.pra.dao.PoliticianRepository;
import com.verizon.pra.dao.StatisticsRepository;
import com.verizon.pra.model.Comment;
import com.verizon.pra.model.Politician;
import com.verizon.pra.model.Statistics;

@Service
public class StatisticsServiceImpl implements StatisticsService{

	@Autowired
	private StatisticsRepository statsRepo;
	
	@Autowired
	private PoliticianService politicianservice;
	
	@Autowired
	private CommentService commentService;
	

	@Override
	public Statistics addStatistics(Statistics stats) {
		
		return statsRepo.save(stats);
	}
	
	
	@Override
	public Statistics updateStatistics(Statistics stats) {
		return statsRepo.save(stats);
	}
	
	
	@Override
	public Statistics getStatisticsByPolitician(long politicianId) {
		Optional<Statistics> optStatistics = statsRepo.findById(politicianId);
		Statistics stat = null;

		if(optStatistics.isPresent()) {
			stat = optStatistics.get();
		}
		
		return stat;
	}
	
	

	@Override
	public Statistics setStatisticsByPolitician(long politicianId) {

		Politician politician = politicianservice.getByPId(politicianId);
		Statistics polStats = null;

		if (politician != null) {
			polStats = statsRepo.findByPolitician(politician);
			
			double likeCount = 0;
			double dislikeCount = 0;
			double totalCount = 0;
			double popularityIndex = 0;
			
			List<Comment> comments = commentService.getAllCommentsByPoliticianId(politicianId);
			
			for(Comment comment:comments) {
				if(comment.isuLike()) 
					likeCount++;
				else 
					dislikeCount++;
			}	
			
			comments = commentService.getAllComments();
			
			for(Comment comment: comments) {
				totalCount++;
			}
			
			if(totalCount!=0)
				popularityIndex = ((likeCount + dislikeCount)/totalCount)*100;
			polStats.setLikeCount(likeCount);
			polStats.setDislikeCount(dislikeCount);
			polStats.setPopularityIndex(popularityIndex);
			
			
		}
		
		return statsRepo.save(polStats);
		
	}
	
	

	@Override
	public void initialiseStatistics() {
		List<Politician> politicians = politicianservice.getAllPoliticians();
		Statistics stat = null;
		
		for(Politician pol: politicians) {
			stat = new Statistics(pol, 0, 0, 0);
			statsRepo.save(stat);
		}
	}
	
	
	@Override
	public List<Statistics> getAllStatistics() {
		return statsRepo.findAll();
	}



	@Override
	public void setAllStatistics() {
		List<Politician> politicians = politicianservice.getAllPoliticians();
		List<Statistics> stats = statsRepo.findAll();
		
		if(politicians.size() != stats.size())
			initialiseStatistics();
		
		for(Politician pol: politicians) {
			setStatisticsByPolitician(pol.getpId());
		}
	}


}

