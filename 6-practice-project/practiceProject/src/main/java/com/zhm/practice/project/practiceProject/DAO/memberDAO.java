package com.zhm.practice.project.practiceProject.DAO;

import com.zhm.practice.project.practiceProject.entity.member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface memberDAO extends JpaRepository<member, Integer> {

}
