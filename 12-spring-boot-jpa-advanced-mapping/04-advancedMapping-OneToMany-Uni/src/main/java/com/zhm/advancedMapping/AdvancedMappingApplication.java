package com.zhm.advancedMapping;

import com.zhm.advancedMapping.DAO.InstructorDAO;
import com.zhm.advancedMapping.entity.Course;
import com.zhm.advancedMapping.entity.Instructor;
import com.zhm.advancedMapping.entity.InstructorDetail;
import com.zhm.advancedMapping.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
		return runner -> {
			// createCourseAndReviews(instructorDAO);

			// findCourseAndReviews(instructorDAO);

			deleteCourseAndReviews(instructorDAO);
		};
	}

	private void deleteCourseAndReviews(InstructorDAO instructorDAO) {
		int id = 10;
		instructorDAO.deleteCourseById(id);
		System.out.println("Done deleting course of id : " + id);
	}

	private void findCourseAndReviews(InstructorDAO instructorDAO) {
		int id = 10;
		Course theCourse = instructorDAO.findCourseAndAssociatedReviewsByCourseId(id);
		System.out.println(theCourse);
		System.out.println(theCourse.getReviews());
	}

	private void createCourseAndReviews(InstructorDAO instructorDAO) {

		// create a course
		Course theCourse = new Course("CSE-101");

		// add some reviews
		Review theReview1 = new Review("Cool course.");
		Review theReview2 = new Review("Awesome.");
		Review theReview3 = new Review("What a waste of time.");

		// add the reviews to the course
		theCourse.addReview(theReview1);
		theCourse.addReview(theReview2);
		theCourse.addReview(theReview3);

		// save the course and leverage the cascade all
		instructorDAO.save(theCourse);
	}

	private void deleteCourse(InstructorDAO instructorDAO) {
		int id = 18;
		instructorDAO.deleteCourseById(id);
		System.out.println("Done deleting id : " + id);
	}

	private void updateCourse(InstructorDAO instructorDAO) {
		int id = 10;
		Course theCourse = instructorDAO.findCourseById(id);
		theCourse.setTitle("BAN-101");
		instructorDAO.updateCourse(theCourse);
	}

	private void updateInstructor(InstructorDAO instructorDAO) {
		int id = 1;
		Instructor theInstructor = instructorDAO.findInstructorById(id);
		theInstructor.setFirstName("Md. Zahid Hasan");
		theInstructor.setLastName("Mozumder");
		instructorDAO.updateInstructor(theInstructor);
	}

	// When we are having default fetching type as Lazy then
	// we can read instructor and associated courses together at a time
	private void findCoursesForInstructorJoinFetch(InstructorDAO instructorDAO) {
		int id = 4;
		Instructor tmpInstructor = instructorDAO.findInstructorAndCoursesJoinFetch(id);
		System.out.println(tmpInstructor);
		System.out.println(tmpInstructor.getCourses());
	}

	// When we are having default fetching type as Lazy then
	// we need to read instructor and associated courses separately
	private void findCoursesForInstructor(InstructorDAO instructorDAO) {
		int id = 3;
		Instructor tmpInstructor = instructorDAO.findInstructorById(id);
		List<Course> courses = instructorDAO.findCoursesByInstructorId(id);

		System.out.println(courses);
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {
		InstructorDetail tmpInstructorDetail = new InstructorDetail("TravelWithRobin", "Travelling");
		Instructor tmpInstructor = new Instructor("Tariqul", "Islam", "tariqul.islam@gmail.com", tmpInstructorDetail);
		Course tmpCourse1 = new Course("GED-101");
		Course tmpCourse2 = new Course("GED-103");
		tmpInstructor.addCourse(tmpCourse1);
		tmpInstructor.addCourse(tmpCourse2);

		System.out.println("Instructor details: ");
		System.out.println(tmpInstructor);
		System.out.println("Courses details: ");
		System.out.println(tmpCourse1);
		System.out.println(tmpCourse2);

		instructorDAO.save(tmpInstructor);
		System.out.println("Done...");
	}

	private void deleteInstructorDetailById(InstructorDAO instructorDAO) {
		int id = 4;
		instructorDAO.deleteInstructorDetailById(id);
		System.out.println("Successfully deleted Instructor detail of id : " + id);
	}

	private void findInstructorDetail(InstructorDAO instructorDAO) {
		int id = 3;
		InstructorDetail tmpInstructorDetail =  instructorDAO.findInstructorDetailById(id);
		System.out.println(tmpInstructorDetail);
		System.out.println(tmpInstructorDetail.getInstructor());
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int id = 3;
		instructorDAO.deleteInstructorById(id);
		System.out.println("Instructor deleted successfully of id : " + id);
	}

	private void findInstructor(InstructorDAO instructorDAO) {
		int id = 4;
		Instructor tmpInstructor = instructorDAO.findInstructorById(id);
		System.out.println(tmpInstructor);
		//System.out.println(tmpInstructor.getCourses());
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
