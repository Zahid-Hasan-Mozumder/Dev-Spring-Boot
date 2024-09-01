package com.zhm.advancedMapping.DAO;

import com.zhm.advancedMapping.entity.Instructor;

public interface InstructorDAO {

    public void save(Instructor theInstructor);

    public Instructor findById(int id);

    public void deleteById(int id);
}
