package com.blog.application.services;

import java.util.List;

import com.blog.application.payloads.UserDto;

public interface UserService {
	
    //create
	UserDto createUser(UserDto user);
	
	UserDto createUserWithConversion(UserDto user);

	//update
	UserDto updateUser(UserDto user, Integer userId);
	
	// delete
	void deleteUser(Integer userId);
	
	//get single
	UserDto getUser(Integer userId);
	
	//get all
	List<UserDto> getAllUsers();
	

}
