package com.zhm.crud.cruddemo.DAO;

import com.zhm.crud.cruddemo.entity.customer;

import java.util.List;

public interface CustomerDAO {

    // create an instance of the customer object in the database
    public void save(customer aCustomer);

    // read an instance from database as object
    public customer findById(int customer_id);

    // read all the available instances from the database
    public List<customer> findAll();

    // read all the available instances from the database which satisfy the condition
    public List<customer> findByLastName(String lastName);

    // update a single instance of the database
    public void updateSingleByLastName(int customer_id, String lastName);

    // delete a single instance from the database
    public void delete(int customer_id);

    // delete all the available instances from the database
    public int deleteAll();
}
