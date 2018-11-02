package com.verizon.pra.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.verizon.pra.dao.UserDao;
import com.verizon.pra.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		Optional<User> opt = userDao.findById(id);
		User user = null;
		if (opt.isPresent())
			user = opt.get();
		return user;
	}

	@Override
	public User getUserById(long userId) {
		User user = null;
		Optional<User> optUser = userDao.findById(userId);

		if (optUser.isPresent())
			user = optUser.get();
		return user;
	}

	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	public boolean deleteUserById(long userId) {
		boolean isDeleted = false;

		if (userDao.existsById(userId)) {
			userDao.deleteById(userId);
			isDeleted = true;
		}

		return isDeleted;
	}

	@Override
	public User save(User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		System.out.println(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		newUser.setuName(user.getuName());
		newUser.setuEmailId(user.getuEmailId());
		return userDao.save(newUser);
	}

	@Override
	public User getIdByUEmailId(String uEmailId) {
		return userDao.findByUEmailId(uEmailId);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
