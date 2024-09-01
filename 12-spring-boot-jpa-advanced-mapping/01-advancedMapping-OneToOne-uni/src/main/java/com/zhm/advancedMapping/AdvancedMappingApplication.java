package com.zhm.advancedMapping;

import com.zhm.advancedMapping.DAO.InstructorDAO;
import com.zhm.advancedMapping.entity.Instructor;
import com.zhm.advancedMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
		return runner -> {

			// createInstructor(instructorDAO);

			// createInstructorAnotherWay(instructorDAO);

			// findInstructor(instructorDAO);

			// deleteInstructor(instructorDAO);

		};
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		instructorDAO.deleteById(2);
		System.out.println("Instructor deleted successfully....");
	}

	private void findInstructor(InstructorDAO instructorDAO) {
		Instructor tmpInstructor = instructorDAO.findById(3);
		System.out.println(tmpInstructor);
		System.out.println(tmpInstructor.getInstructorDetail());
	}

	private void createInstructorAnotherWay(InstructorDAO instructorDAO) {
		InstructorDetail tmpInstructorDetail = new InstructorDetail("TravelWithRobin", "Travelling");
		Instructor tmpInstructor = new Instructor("Tariqul", "Islam", "tariqul.islam@gmail.com", tmpInstructorDetail);
		System.out.println(tmpInstructor.toString());
		instructorDAO.save(tmpInstructor);
		System.out.println("Done!");
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		Instructor tmpInstructor = new Instructor("Zahid", "Hasan", "jahidhasanmozumder@gmail.com");
		InstructorDetail tmpInstructorDetail = new InstructorDetail("CodeWithZahid", "Travelling");
		tmpInstructor.setInstructorDetail(tmpInstructorDetail);
		System.out.println(tmpInstructor.toString());
		instructorDAO.save(tmpInstructor);
		System.out.println("Done!");
	}

}
