package com.nico.madry.springbanking.controller;

import com.nico.madry.springbanking.dto.UserDto;
import com.nico.madry.springbanking.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserManagementController {

	private ModelMapper modelMapper;

	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
		final User user = modelMapper.map(userDto, User.class);

		return ResponseEntity.ok().body(user);
	}

}
