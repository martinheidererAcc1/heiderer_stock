package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.CustomerException;

public class CustomerRepository {
	
	// attention: end of line use a space
	private final static String SQL_SELECT_ALL =
			"select CUSTOMER_ID,\r\n" + 
			"       EMAIL,\r\n" + 
			"       FIRSTNAME,\r\n" + 
			"       LASTNAME,\r\n" + 
			"       GENDER,\r\n" + 
			"       BIRTHDATE,\r\n" + 
			"       CREDITS\r\n" + 
			"from customer";
	
	private PreparedStatement selectAllStatement;

	// SELECT ALL -------------------------------------------------------------
	public List<Customer> selectAll( Connection con ) throws CustomerException {
		try {
			// prepare statement if not prepared before
			if ( selectAllStatement == null ) {
				selectAllStatement = con.prepareStatement( SQL_SELECT_ALL );
			}
			//selectAllStatement.executeUpdate();    UPDATES data returns number of rows
			//selectAllStatement.executeQuery();     SELECT returns data
			ResultSet resultSet = selectAllStatement.executeQuery();
			if ( resultSet != null )
			{	
				List<Customer> customers = new ArrayList<>();
				while( resultSet.next() )
				{	
					Integer customerID = resultSet.getInt( 1 );
					String email = resultSet.getString( 2 );
					String firstname = resultSet.getString( 3 );
					String lastname = resultSet.getString( 4 );
					String gender = resultSet.getString( 5 );
					LocalDateTime birthDate = resultSet.getTimestamp( 6 ).toLocalDateTime();
					Double credits = resultSet.getDouble( 7 );
					customers.add( new Customer( customerID, email, firstname, lastname, gender, birthDate, credits ));					
				}
				return customers;

			}
			else {
				throw new CustomerException( "Could not read data from database" );
			}
			
		} catch ( SQLException e ) {
			throw new CustomerException( "Could not execute SQL statement" );
		}
	}

}