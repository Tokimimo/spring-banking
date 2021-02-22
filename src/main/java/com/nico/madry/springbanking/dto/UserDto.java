package com.nico.madry.springbanking.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

	private String firstName;

	private String lastName;

	private String country;

	private String zipCode;

	private String city;

	private String street;

}
