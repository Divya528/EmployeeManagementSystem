package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	Connection connection;
	//Statement statement;
	java.sql.Statement statement;
	
	public Conn() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","Divya@123");
			statement = connection.createStatement();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
