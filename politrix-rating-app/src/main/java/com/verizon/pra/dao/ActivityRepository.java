package com.verizon.pra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.pra.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
