package com.nico.madry.springbanking.repository;

import java.util.List;
import java.util.Optional;

import com.nico.madry.springbanking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	List<User> findByFirstName(final String firstName);

	List<User> findByLastName(final String lastName);

	Optional<User> findByFirstNameAndLastName(final String firstName, final String lastName);

}
