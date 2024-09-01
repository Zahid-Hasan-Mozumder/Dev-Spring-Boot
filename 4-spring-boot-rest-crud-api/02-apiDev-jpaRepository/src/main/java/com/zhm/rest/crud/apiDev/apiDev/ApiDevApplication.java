package com.zhm.rest.crud.apiDev.apiDev;

import com.zhm.rest.crud.apiDev.apiDev.entity.employee;
import com.zhm.rest.crud.apiDev.apiDev.service.employeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDevApplication.class, args);
	}
}
