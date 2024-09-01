package com.zhm.crud.cruddemo;

import com.zhm.crud.cruddemo.dao.StudentDAO;
import com.zhm.crud.cruddemo.entity.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating a new student object:");
		student tempStudent = new student("Zahid Hasan", "Mozumder", "jahidhasanmozumder@gmail.com");

		// save the student object
		System.out.println("Saving the student info in database....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated ID: " + tempStudent.getId());
	}
}
