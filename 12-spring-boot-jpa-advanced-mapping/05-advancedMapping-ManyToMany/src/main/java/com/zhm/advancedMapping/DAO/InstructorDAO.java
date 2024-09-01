package com.zhm.advancedMapping.DAO;

import com.zhm.advancedMapping.entity.Course;
import com.zhm.advancedMapping.entity.Instructor;
import com.zhm.advancedMapping.entity.InstructorDetail;
import com.zhm.advancedMapping.entity.Student;

import java.util.List;

public interface InstructorDAO {

    public void save(Instructor theInstructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);

    public List<Course> findCoursesByInstructorId(int id);

    public Instructor findInstructorAndCoursesJoinFetch(int id);

    public void updateInstructor(Instructor theInstructor);

    public Course findCourseById(int id);

    public void updateCourse(Course theCourse);

    public void deleteCourseById(int id);

    public void save(Course theCourse);

    public Course findCourseAndAssociatedReviewsByCourseId(int id);

    public Course findCourseAndStudentByCourseId(int id);

    public Student findStudentAndCourseByStudentId(int id);

    public void updateStudent(Student theStudent);

    public void deleteStudentByStudentId(int id);
}
