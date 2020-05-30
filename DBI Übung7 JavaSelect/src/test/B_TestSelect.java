package test;

import connection.OracleConnection;
import domain.CustomerException;
import domain.CustomerList;
import service.CustomerService;

public class B_TestSelect
{
	public static void main(String[] args)
	{
		try
		{
			CustomerList customerList = new CustomerList();
			OracleConnection oracon = new OracleConnection();
			CustomerService customerService = new CustomerService(oracon.getConnection());
			customerService.getCustomers(customerList);
			System.out.println(customerList);
			oracon.close();
		} catch (CustomerException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
