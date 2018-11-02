package com.verizon.pra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.pra.dao.ActivityRepository;
import com.verizon.pra.model.Activity;

@Service

public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepo;

	@Override
	public List<Activity> getAllActivity() {
		return activityRepo.findAll();
	}

	@Override
	public Activity addActivity(Activity activity) {
		return activityRepo.save(activity);
		
	}

}
