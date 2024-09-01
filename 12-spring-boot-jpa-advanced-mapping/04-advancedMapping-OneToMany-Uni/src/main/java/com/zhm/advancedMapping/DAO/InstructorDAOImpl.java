package com.zhm.advancedMapping.DAO;

import com.zhm.advancedMapping.entity.Course;
import com.zhm.advancedMapping.entity.Instructor;
import com.zhm.advancedMapping.entity.InstructorDetail;
import com.zhm.advancedMapping.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class InstructorDAOImpl implements InstructorDAO{

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor theInstructor = entityManager.find(Instructor.class, id);

        List<Course> theCourses = theInstructor.getCourses();

        for(Course theCourse : theCourses){
            theCourse.setInstructor(null);
        }

        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail tmpInstructorDetail = entityManager.find(InstructorDetail.class, id);

        // remove the associated object reference
        // break bi-directional link
        tmpInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tmpInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorAndCoursesJoinFetch(int id) {

        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                                                                + "JOIN FETCH i.courses "
                                                                + "where i.id = :data", Instructor.class);

        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course theCourse = entityManager.find(Course.class, id);
        entityManager.remove(theCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndAssociatedReviewsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c "
                                                            + "JOIN FETCH c.reviews "
                                                            + "where c.id = :data", Course.class);
        query.setParameter("data", id);
        Course theCourse = query.getSingleResult();
        return theCourse;
    }


}
