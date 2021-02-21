package com.nico.madry.springbanking.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.nico.madry.springbanking.model.AuditedEntity;
import com.nico.madry.springbanking.model.Gender;

@Entity
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(name = "UQ_USER_ID", columnNames = "ID") })
public class User extends AuditedEntity {

	@NotBlank(message = "The first name is mandatory")
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[A-Za-z ]*", message = "The first name must contain only letters and spaces")
	@Column(name = "firstname", nullable = false)
	private String firstName;

	@NotBlank(message = "The last name is mandatory")
	@Size(min = 1, max = 255)
	@Column(name = "lastname", nullable = false)
	@Pattern(regexp = "[A-Za-z ]*", message = "The last name must contain only letters and spaces")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotBlank(message = "A password is required")
	@Size(min = 1, max = 255)
	@Column(name = "password", nullable = false)
	private String password;

	@NotBlank(message = "A password salt is required")
	@Size(min = 1, max = 255)
	@Column(name = "password_salt", nullable = false)
	private String passwordSalt;

	@Size(min = 1, max = 255)
	@Column(name = "country")
	private String country;

	@Size(min = 1, max = 255)
	@Column(name = "zip_code")
	private String zipCode;

	@Size(min = 1, max = 255)
	@Column(name = "city")
	private String city;

	@Size(min = 1, max = 255)
	@Column(name = "street")
	private String street;

	public User() {
		super();
	}

	public User(final String firstName, final String lastName, final String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(final String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getPassword()
			  .equals(user.getPassword()) && getPasswordSalt().equals(user.getPasswordSalt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getFirstName(), getLastName(), getPassword(), getPasswordSalt(), getCountry(), getZipCode(),
			  getCity(), getStreet());
	}

	@Override
	public String toString() {
		return "User{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", password='" + password + '\''
			  + ", passwordSalt='" + passwordSalt + '\'' + ", country='" + country + '\'' + ", zipCode='" + zipCode + '\'' + ", city='"
			  + city + '\'' + ", street='" + street + '\'' + '}';
	}
}
