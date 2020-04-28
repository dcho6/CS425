package finalProjectCS425;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class functions {

	
	public static Connection connect() {
		
		String database = "jdbc:postgresql://localhost/finalproject425";/*this is the location of the database when you saved the tables and stuff on postgress*/
		
		String user = "postgres";
		
		String password = "howlingwolf123";/*whatever password you did for postgres set up*/
		
		try {
			
			Connection connection = DriverManager.getConnection(database, user, password);
			
			return connection;
			
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	
	public static ArrayList<Customer> customerDetail(){/*used to make the table for customer deatil when clicking the view customer detail button*/
		ArrayList<Customer> customerDetail = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from customer_details";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
	
		ResultSet result = myStmt.executeQuery();
		
		Customer customer;
		
		while(result.next()) {
			
			
			customer = new Customer (result.getInt("order_number"), result.getInt("quantity"), result.getInt("sale_value"), result.getString("customer_id"), result.getString("preference"), result.getString("company"), result.getString("employee_id"));
			/*the entry corresponds to the column index of each variable that is made from customer constructor*/
			
			customerDetail.add(customer); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(Exception e1) {
			
			
			System.out.print(e1);
			
		}
		
		return customerDetail;
		
	}
	
	public static ArrayList<Customer> customerSearchDetail(){/*used to make the table for customer deatil when clicking the view customer detail button*/
		ArrayList<Customer> customerDetail = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from customer_details where customer_id = ?";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
		
		myStmt.setString(1, viewCustomerDetails.customerID.getText());
	
		ResultSet result = myStmt.executeQuery();
		
		Customer customer;
		
		while(result.next()) {
			
			
			customer = new Customer (result.getInt("order_number"), result.getInt("quantity"), result.getInt("sale_value"), result.getString("customer_id"), result.getString("preference"), result.getString("company"), result.getString("employee_id"));
			/*the entry corresponds to the column index of each variable that is made from customer constructor*/
			
			customerDetail.add(customer); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(SQLException e1) {
			
			
			JOptionPane.showMessageDialog(null, "Customer not found");
			
		}
		
		return customerDetail;
		
	}
	

	}
