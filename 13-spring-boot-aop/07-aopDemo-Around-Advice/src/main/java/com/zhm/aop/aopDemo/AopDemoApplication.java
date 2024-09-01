package com.zhm.aop.aopDemo;

import com.zhm.aop.aopDemo.DAO.AccountDAO;
import com.zhm.aop.aopDemo.DAO.MembershipDAO;
import com.zhm.aop.aopDemo.anotherDAO.TestDAO;
import com.zhm.aop.aopDemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TestDAO theTestDAO,
											   TrafficFortuneService theTrafficFortuneService){
		return runner ->{
			// demoAroundAdvice(theTrafficFortuneService);
			demoAroundAdviceExceptionHandling(theTrafficFortuneService);
		};
	}

	private void demoAroundAdviceExceptionHandling(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("Main program");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("Main program");

		System.out.println("My fortune is : " + data);
	}

	private void demoAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("Main program");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("Main program");

		System.out.println("My fortune is : " + data);

	}

}
