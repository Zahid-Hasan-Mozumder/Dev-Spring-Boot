package com.zhm.crud.cruddemo.DAO;

import com.zhm.crud.cruddemo.entity.customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public CustomerDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement save method
    @Transactional
    public void save(customer aCustomer){
        entityManager.persist(aCustomer);
    }

    // implement findById method
    public customer findById(int customer_id){
        return entityManager.find(customer.class, customer_id);
    }

    // implement findAll method
    public List<customer> findAll(){
        TypedQuery<customer> theQuery = entityManager.createQuery("FROM customer order by firstName desc", customer.class);
        return theQuery.getResultList();
    }

    // implement findByLastName method
    public List<customer> findByLastName(String lastName){
        TypedQuery<customer> theQuery = entityManager.createQuery("FROM customer WHERE lastName=:thedata", customer.class);
        theQuery.setParameter("thedata", lastName);
        return theQuery.getResultList();
    }

    // implement updateSingleByLastName method
    @Transactional
    public void updateSingleByLastName(int customer_id, String lastName){
        customer tmp = entityManager.find(customer.class, customer_id);
        tmp.setLastName(lastName);
        entityManager.merge(tmp);
    }

    // implement delete method
    @Transactional
    public void delete(int customer_id){
        customer tmp = entityManager.find(customer.class, customer_id);
        entityManager.remove(tmp);
    }

    //  implement deleteAll method
    @Transactional
    public int deleteAll(){
        int numRowsDeleted = entityManager.createQuery("DELETE FROM customer").executeUpdate();
        return numRowsDeleted;
    }
}
