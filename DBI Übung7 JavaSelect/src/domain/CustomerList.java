package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerList {
	private List<Customer> customers;
	
	public CustomerList() {
		customers = new ArrayList<>();
	}	
		
	public void add(Customer c) {
		customers.add(c);
	}
	
	public void clear() {
		customers.clear();
	}

	public void remove(Customer c) {
		customers.remove(c);
	}

	public void remove(Customer... ccc) {
		for (Customer a: ccc) {
			remove(a);
		}
	}

	public void add(Customer... ccc) {
		for (Customer a: ccc) {
			add(a);
		}
	}
	
	public void addAll( List<Customer> customerList ) {
		customers.addAll( customerList );
	}
	
	public List<Customer> getCustomers(){
		return Collections.unmodifiableList( customers );
	}
	
	@Override
	public String toString() {
		return "CustomerList [customers=" + customers + "]";
	}
}
