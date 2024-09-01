package com.zhm.aop.aopDemo;

import com.zhm.aop.aopDemo.DAO.AccountDAO;
import com.zhm.aop.aopDemo.DAO.MembershipDAO;
import com.zhm.aop.aopDemo.anotherDAO.TestDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TestDAO theTestDAO){
		return runner ->{

			demoBeforeAdvice(theAccountDAO, theMembershipDAO, theTestDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TestDAO theTestDAO) {

		// call the business method
		theAccountDAO.addAccount();

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call the business method again
		theAccountDAO.addAccount();

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call a different business method
		theMembershipDAO.addAccount();

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call a different business method
		theMembershipDAO.addSillyMember();

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call a different business method
		boolean tmp = theMembershipDAO.addCoolMember();

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call a different business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount);

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call a different business method
		Account x = new Account();
		boolean y = true;
		theAccountDAO.addAccount(x, y);

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call a different business method
		theMembershipDAO.goToSleep();

		System.out.println('\n' + "Calling a business method again" + '\n');

		// call a different business method
		theTestDAO.testAccount();
	}
}
