package com.blog.application.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.application.entities.User;
import com.blog.application.exceptions.ResourceNotFound;
import com.blog.application.payloads.UserDto;
import com.blog.application.repositories.UserRepository;
import com.blog.application.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.mapper.map(userDto, User.class);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEnable(true);
		User savedUser = this.userRepo.save(user);
		return this.mapper.map(savedUser, UserDto.class);
	}
	@Override
	public UserDto createUserWithConversion(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEnable(true);
		User savedUser = this.userRepo.save(user);
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		return this.mapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		this.userRepo.delete(user);
	}

	@Override
	public UserDto getUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		return this.mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		return users.stream().map((user) -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
	}
	
	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		return user;
	}
	private UserDto UserToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
