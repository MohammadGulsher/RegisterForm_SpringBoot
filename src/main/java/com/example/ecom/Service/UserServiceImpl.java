package com.example.ecom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Repository.UserRepository;
import com.example.ecom.entity.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User insertUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User loginAndEmail(String email, String password) {
		User user=userRepository.findByEmail(email);
		if(user !=null && user.getPassword().equals(password))
		{
			return user;
		}
		return null;
	}

	
}
