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
			demoAfterReturningAdvice(theAccountDAO);
		};
	}

	private void demoAfterReturningAdvice(AccountDAO theAccountDAO) {

		System.out.println("Main program before the execution of the method");
		List<Account> acc = theAccountDAO.findAccounts();
		System.out.println("Main program after execution of the method");
		System.out.println(acc);
	}


}
