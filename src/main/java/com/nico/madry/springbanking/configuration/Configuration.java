package com.nico.madry.springbanking.configuration;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@org.springframework.context.annotation.Configuration
public class Configuration {

	//@Bean
	//public DataSource dataSource() {
	//	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	//
	//	// TODO: Create environment variable retrievable for jdbc credentials [NM]
	//	dataSource.setDriverClassName("org.postgresql");
	//	dataSource.setUsername("TODO");
	//	dataSource.setPassword("TODO");
	//	dataSource.setUrl("TODO");
	//
	//	return dataSource;
	//}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
