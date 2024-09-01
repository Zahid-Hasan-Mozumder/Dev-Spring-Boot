package com.zhm.spring_boot.spring_core.SpringCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication(
		scanBasePackages = {"com.zhm.spring_boot.spring_core.SpringCoreDemo",
							"com.zhm.spring_boot.spring_core.util"}
)
*/

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCoreDemoApplication.class, args);

	}

}
