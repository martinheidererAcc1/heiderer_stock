package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import domain.CustomerException;

public class OracleConnection {
	private Connection con;
	
	public OracleConnection() throws CustomerException {
		try {
			// load database driver
			// Class.forName VS import -> http://stackoverflow.com/questions/19674752/difference-between-import-and-class-forname-in-java
			// DOWNLOAD ORACLE DRIVER -> http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html
			// CHOOSE FILE -> ojdbc6.jar
			// RIGHT CLICK PROJECT -> JAVA BUILD PATH -> ADD EXTERNAL JAR -> ojdbc6.jar
			Class.forName( "oracle.jdbc.OracleDriver" );
			
			// by default open the connection
			open();
		}
		catch (ClassNotFoundException e) {
			throw new CustomerException("Couldnt find database driver!");
		}
	}
	
	public void open() throws CustomerException {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL", "DEMO", "oracle");
		}
		catch (SQLException e) {
			throw new CustomerException("Couldnt open database connection!");
		}
	}
	
	public void close() throws CustomerException {
		try {
			con.close();
		}
		catch (SQLException e) {
			throw new CustomerException("Couldnt close database connection!");
		}
	}
	
	public Connection getConnection() {
		return con;
	}	
}