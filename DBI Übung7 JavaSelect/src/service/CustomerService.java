package service;

import java.sql.Connection;

import domain.CustomerException;
import domain.CustomerList;
import persistence.CustomerRepository;

public class CustomerService {
	
	private Connection con;
	private CustomerRepository customerRep;
	
	public CustomerService(Connection con) {
		this.con = con;
		this.customerRep = new CustomerRepository();
	}
	
	public void getCustomers(CustomerList customerList) throws CustomerException {
		customerList.clear();
		customerList.addAll(customerRep.selectAll(con));
	}
}
