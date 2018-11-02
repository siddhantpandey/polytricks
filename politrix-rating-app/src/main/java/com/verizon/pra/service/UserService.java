package com.verizon.pra.service;



import java.util.List;

import com.verizon.pra.model.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
    
	
	User getUserById(long userId);
	
	User addUser(User user);
	
	User updateUser(User user);
	
	boolean deleteUserById(long userId);
	
	User getIdByUEmailId(String uEmailId);
	User findByUsername(String username);
}
