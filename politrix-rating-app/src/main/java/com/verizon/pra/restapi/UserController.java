package com.verizon.pra.restapi;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.pra.dao.UserDao;
import com.verizon.pra.model.User;
import com.verizon.pra.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listUser(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }
    
    @GetMapping("/email/{uEmailId}")
    public User getId(@PathVariable(value = "uEmailId") String uEmailId){
        return userService.getIdByUEmailId(uEmailId);
    }
    
    @GetMapping("/username/{username}")
    public User getByUsername(@PathVariable(value = "username") String username) {
    	return userService.findByUsername(username);
    }
    
    @PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		ResponseEntity<User> resp = null;
		User usr = userService.addUser(user);
		
		if(usr!=null)
			resp = new ResponseEntity<>(usr, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
		
	}
    
    @PostMapping("/signup")
    public User saveUser(@RequestBody User user){
    	System.out.println(user.getuEmailId());
    	return userService.save(user);
    }

}