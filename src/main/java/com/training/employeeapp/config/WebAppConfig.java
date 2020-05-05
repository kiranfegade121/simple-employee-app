package com.training.employeeapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.training")
public class WebAppConfig {

	@Bean	
	public DataSource getDriverManagerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// We are using setter injection
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("admin@123");
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		// we are using constructor injection
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDriverManagerDataSource());		
		return jdbcTemplate;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
