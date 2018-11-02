package com.verizon.pra.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.pra.model.Activity;
import com.verizon.pra.service.ActivityService;

@RestController

@RequestMapping("/activity")
@CrossOrigin
public class ActivityApi {
	@Autowired
	private ActivityService aserv;
	
	@GetMapping
	public ResponseEntity<List<Activity>> getAllActivity() {
		return new ResponseEntity<>(aserv.getAllActivity(), HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<Activity> addActivity(@RequestBody Activity activity){
		ResponseEntity<Activity> resp = null;
		if (resp == null) {
			Activity c = aserv.addActivity(activity);
			if (c == null)
				resp = new ResponseEntity<Activity>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Activity>(c, HttpStatus.OK);
		}
		return resp;
	}
}
