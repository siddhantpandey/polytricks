package com.verizon.pra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.pra.model.Politician;
import com.verizon.pra.model.Statistics;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
	//List<Statistics> findTop5ByStatIdAsc();
	
	Statistics findByPolitician(Politician politicianId);
	
	boolean existsByPolitician(Politician politicianId);

}
