package com.nico.madry.springbanking.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.nico.madry.springbanking.model.AuditedEntity;
import com.nico.madry.springbanking.model.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(name = "uq_user_id", columnNames = "id") })
public class User extends AuditedEntity {

	@Id
	@NotNull
	@Column(name = "id", precision = 9, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequencer")
	@SequenceGenerator(allocationSize = 1, name = "userSequencer", sequenceName = "user_seq")
	private Long id;

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
}


