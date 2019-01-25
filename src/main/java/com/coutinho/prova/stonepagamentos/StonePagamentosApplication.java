package com.coutinho.prova.stonepagamentos;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class StonePagamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(StonePagamentosApplication.class, args);
	}
	
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/stone");
	    dataSource.setUsername("coutinho");
	    dataSource.setPassword("j1751c");
	    return dataSource;
	}

}

