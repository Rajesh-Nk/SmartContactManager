package com.rajesh.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajesh.sms.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	

}
