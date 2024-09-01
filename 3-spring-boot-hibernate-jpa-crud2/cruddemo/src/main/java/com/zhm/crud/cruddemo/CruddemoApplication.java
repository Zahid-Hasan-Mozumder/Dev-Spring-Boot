package com.zhm.crud.cruddemo;

import com.zhm.crud.cruddemo.DAO.CustomerDAO;
import com.zhm.crud.cruddemo.entity.customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CustomerDAO customerDAO){
		return runner -> {

			// create_customer(customerDAO);

			// create_multiple_customer(customerDAO);

			// readCustomer(customerDAO);

			// queryfy(customerDAO);

			// queryfyByLastName(customerDAO);

			// updateSingleByLastName(customerDAO);

			// deleteSingleInstance(customerDAO);

			// deleteAll(customerDAO);
		};
	}

	private void deleteAll(CustomerDAO customerDAO) {
		int numRowsDeleted = customerDAO.deleteAll();
		System.out.println(numRowsDeleted + " instance deleted.");
	}

	private void deleteSingleInstance(CustomerDAO customerDAO) {
		customerDAO.delete(203002003);
		System.out.println("Deleted successfully....");
	}

	private void updateSingleByLastName(CustomerDAO customerDAO) {
		customerDAO.updateSingleByLastName(203002001, "Kanerdul");
		System.out.println("Updated successfully");
		System.out.println(customerDAO.findById(203002001).toString());
	}

	private void queryfyByLastName(CustomerDAO customerDAO) {
		List<customer> theCustomers = customerDAO.findByLastName("Mozumder");

		for(customer tmpCustomer : theCustomers){
			System.out.println(tmpCustomer);
		}
	}

	private void queryfy(CustomerDAO customerDAO) {
		List<customer> theCustomers = customerDAO.findAll();

		for(customer tmpCustomer : theCustomers){
			System.out.println(tmpCustomer);
		}
	}

	private void readCustomer(CustomerDAO customerDAO) {
		customer myCustomer = customerDAO.findById(203002003);
		System.out.println(myCustomer.toString());
	}

	private void create_customer(CustomerDAO customerDAO) {
		// create an object of customer
		System.out.println("Creating objects of the customer....");
		customer c1 = new customer("Mehedi Hasan", "Mridul", "Narshingdi", "dickhead@gmail.com");

		// save the object in database
		System.out.println("Saving the created objects in the database....");
		customerDAO.save(c1);

		// display the id of the saved object
		System.out.println("Saved customer. Generated cutomer_id: " + c1.getCustomer_id());
	}

	private void create_multiple_customer(CustomerDAO customerDAO){

		// create objects of customer
		System.out.println("Creating objects of the customer....");
		customer c1 = new customer("Mehedi Hasan", "Mridul", "Narshingdi", "dickhead@gmail.com");
		customer c2 = new customer("Abu Saleh Mohammad", "Nayeem", "Mirpur", "asmnayeem@gmail.com");
		customer c3 = new customer("Zahid Hasan", "Mozumder", "Mohammadpur", "jahidhasanmozumder@gmail.com");

		// save the objects in database
		System.out.println("Saving the created objects in the database....");
		customerDAO.save(c1);
		customerDAO.save(c2);
		customerDAO.save(c3);

		// display the id of the saved objects
		System.out.println("Saved customer. Generated cutomer_id: " + c1.getCustomer_id());
		System.out.println("Saved customer. Generated cutomer_id: " + c2.getCustomer_id());
		System.out.println("Saved customer. Generated cutomer_id: " + c3.getCustomer_id());

		// The id value will be changed in object but not in the mapped instance in database
		c1.setCustomer_id(203002015);
		System.out.println("After change, Generated cutomer_id: " + c1.getCustomer_id());

	}
}
