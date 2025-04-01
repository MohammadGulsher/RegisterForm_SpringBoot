package com.example.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
}
