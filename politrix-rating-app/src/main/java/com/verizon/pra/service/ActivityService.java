package com.verizon.pra.service;

import java.util.List;

import com.verizon.pra.model.Activity;


public interface ActivityService {
	List<Activity> getAllActivity();
	Activity addActivity (Activity activity);
	

}
