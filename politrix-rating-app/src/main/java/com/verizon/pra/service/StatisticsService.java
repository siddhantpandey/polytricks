
package com.verizon.pra.service;

import java.util.List;

import com.verizon.pra.model.Statistics;

public interface StatisticsService {
	
	Statistics getStatisticsByPolitician(long politicianId);
	
	Statistics setStatisticsByPolitician(long politicianId);
	
	Statistics addStatistics(Statistics stats);
	
	Statistics updateStatistics(Statistics stats);

	List<Statistics> getAllStatistics();
	
	void initialiseStatistics();
	
	void setAllStatistics();
		
}


