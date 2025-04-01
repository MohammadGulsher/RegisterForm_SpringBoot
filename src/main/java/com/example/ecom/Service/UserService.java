package com.example.ecom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Repository.UserRepository;
import com.example.ecom.entity.User;


public interface UserService {

	public User insertUser(User user);
	
	public User loginAndEmail(String email,String password);
}
