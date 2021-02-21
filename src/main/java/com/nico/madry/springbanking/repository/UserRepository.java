package com.nico.madry.springbanking.repository;

import java.util.List;
import java.util.Optional;

import com.nico.madry.springbanking.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByFirstName(final String firstName);

	List<User> findByLastName(final String lastName);

	Optional<User> findByFirstNameAndLastName(final String firstName, final String lastName);

}
