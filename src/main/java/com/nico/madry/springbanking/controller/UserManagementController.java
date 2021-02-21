package com.nico.madry.springbanking.controller;

import com.nico.madry.springbanking.dto.UserDto;
import com.nico.madry.springbanking.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("user")
public class UserManagementController {

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody UserDto userDto) {
		final User user = modelMapper.map(userDto, User.class);

		return user;
	}

}
