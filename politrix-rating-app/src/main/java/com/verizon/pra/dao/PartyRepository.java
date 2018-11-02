package com.verizon.pra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.pra.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, String> {
	
}
