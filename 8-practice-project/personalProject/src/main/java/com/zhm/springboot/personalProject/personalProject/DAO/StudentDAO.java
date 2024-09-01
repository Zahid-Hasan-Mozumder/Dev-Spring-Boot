package com.zhm.springboot.personalProject.personalProject.DAO;

import com.zhm.springboot.personalProject.personalProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {

}
