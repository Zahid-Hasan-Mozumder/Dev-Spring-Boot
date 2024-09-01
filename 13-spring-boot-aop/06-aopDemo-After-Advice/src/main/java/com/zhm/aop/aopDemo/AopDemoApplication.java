package com.zhm.aop.aopDemo;

import com.zhm.aop.aopDemo.DAO.AccountDAO;
import com.zhm.aop.aopDemo.DAO.MembershipDAO;
import com.zhm.aop.aopDemo.anotherDAO.TestDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TestDAO theTestDAO){
		return runner ->{
			demoAfterAdvice(theAccountDAO);
		};
	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;

		System.out.println("Main program before the execution of the method");
		try{
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc){
			System.out.println("Exception found : " + exc);
		}
		System.out.println("Main program after execution of the method");

	}


}
