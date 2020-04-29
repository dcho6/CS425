package CS425;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class functions {

	
	public static Connection connect() {
		
		String database = "jdbc:postgresql://localhost/company";/*this is the location of the database when you saved the tables and stuff on postgress*/
		
		String user = "postgres";
		
		String password = "pass1123Word!!";/*whatever password you did for postgres set up*/
		
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
	
	
	//Customer functions
	
	public static ArrayList<Customer> customerSearchDetail(){/*used to make the table for customer detail when clicking the view customer detail button*/
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
	
	
	//Employee Functions
	
	public static ArrayList<Employee> employeeView(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<Employee> employeeArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from Employee";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
	
		ResultSet result = myStmt.executeQuery();
		
		Employee employee;
		
		while(result.next()) {
			
			
			employee = new Employee (result.getInt("ssn"), result.getString("employee_id"), result.getString("privilege_type"), result.getString("first_name"), result.getString("last_name"), result.getString("username"), result.getString("password"), result.getString("pay_type"), result.getInt("pay"), result.getInt("total_sales"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			employeeArr.add(employee); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(Exception e1) {
			
			
			System.out.print(e1);
			
		}
		
		return employeeArr;
		
	}
	
	public static ArrayList<Employee> employeeSearchView(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<Employee> employeeArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from Employee WHERE ssn = ? AND employee_id = ?";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
		
		myStmt.setLong(1, Integer.parseInt(viewEmployee.ssn.getText()));
		
		myStmt.setString(2, viewEmployee.employeeID.getText());
		
		ResultSet result = myStmt.executeQuery();
		
		Employee employee;
		
		while(result.next()) {
			
			
			employee = new Employee (result.getInt("ssn"), result.getString("employee_id"), result.getString("privilege_type"), result.getString("first_name"), result.getString("last_name"), result.getString("username"), result.getString("password"), result.getString("pay_type"), result.getInt("pay"), result.getInt("total_sales"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			employeeArr.add(employee); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(SQLException e1) {
			
			
			JOptionPane.showMessageDialog(null, "Employee not found");			
		}
		
		return employeeArr;
		
	}

	
	public static ArrayList<EmployeeSales> employeeSalesSearch(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<EmployeeSales> employeeArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select ssn, employee_id, total_sales from Employee WHERE ssn = ? AND employee_id = ?";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
		
		myStmt.setLong(1, Integer.parseInt(viewEmployeeSales.ssn.getText()));
		
		myStmt.setString(2, viewEmployeeSales.employeeID.getText());
		
		ResultSet result = myStmt.executeQuery();
		
		EmployeeSales employee;
		
		while(result.next()) {
			
			
			employee = new EmployeeSales (result.getInt("ssn"), result.getString("employee_id"),  result.getInt("total_sales"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			employeeArr.add(employee); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(SQLException e1) {
			
			
			JOptionPane.showMessageDialog(null, "Employee not found");			
		}
		
		return employeeArr;
		
	}
	
	public static ArrayList<EmployeeLimited> employeeLimitedSearch(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<EmployeeLimited> employeeArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "SELECT employee_id, privilege_type, first_name, last_name, username FROM Employee WHERE employee_id = ?";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
				
		myStmt.setString(1, viewEmployeeLimited.employeeID.getText());
		
		ResultSet result = myStmt.executeQuery();
		
		EmployeeLimited employee;
		
		while(result.next()) {
			
			
			employee = new EmployeeLimited (result.getString("employee_id"), result.getString("privilege_type"), result.getString("first_name"), result.getString("last_name"), result.getString("username"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			employeeArr.add(employee); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(SQLException e1) {
			
			
			JOptionPane.showMessageDialog(null, "Employee not found");			
		}
		
		return employeeArr;
		
	}
	
	//Model Functions
	
	public static ArrayList<Model> modelView(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<Model> modelArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from Model";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
	
		ResultSet result = myStmt.executeQuery();
		
		Model model;
		
		while(result.next()) {
			
			
			model = new Model(result.getInt("model_number"), result.getInt("sale_price"), result.getString("manufacturer"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			modelArr.add(model); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(Exception e1) {
			
			
			System.out.print(e1);
			
		}
		
		return modelArr;
		
	}
	
	public static ArrayList<Model> modelSearchView(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<Model> modelArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from Model WHERE model_number = ?";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
		
		myStmt.setLong(1, Integer.parseInt(viewModel.modelNumber.getText()));
		
		ResultSet result = myStmt.executeQuery();
		
		Model model;
		
		while(result.next()) {
			
			
			model = new Model(result.getInt("model_number"), result.getInt("sale_price"), result.getString("manufacturer"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			modelArr.add(model); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(SQLException e1) {
			
			
			JOptionPane.showMessageDialog(null, "Model not found");			
		}
		
		return modelArr;
		
	}
	
	
	//Inventory Functions
	
	public static ArrayList<Inventory> inventoryView(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<Inventory> inventoryArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from Inventory";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
	
		ResultSet result = myStmt.executeQuery();
		
		Inventory inventory;
		
		while(result.next()) {
			
			
			inventory = new Inventory(result.getInt("model_number"), result.getString("shelf_location"), result.getInt("stock_quantity"), result.getString("lead_time"), result.getString("category_type"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			inventoryArr.add(inventory); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(Exception e1) {
			
			
			System.out.print(e1);
			
		}
		
		return inventoryArr;
		
	}
	
	public static ArrayList<Inventory> inventorySearchView(){/*used to make the table for employee deatil when clicking the view customer detail button*/
		ArrayList<Inventory> inventoryArr = new ArrayList<>();
		
		try {
		
		
		
		Connection connect = connect();
		
		String query = "select * from Inventory WHERE model_number = ? AND shelf_location = ?";/*will be using the text field to fill in the values of ?*/
		
		PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
		
		myStmt.setLong(1, Integer.parseInt(viewInventory.modelNumber.getText()));
		myStmt.setString(2,  viewInventory.shelfLoc.getText());
		
		ResultSet result = myStmt.executeQuery();
		
		Inventory inventory;
		
		while(result.next()) {
			
			
			inventory = new Inventory(result.getInt("model_number"), result.getString("shelf_location"), result.getInt("stock_quantity"), result.getString("lead_time"), result.getString("category_type"));
			/*the entry corresponds to the column index of each variable that is made from Employee constructor*/
			
			inventoryArr.add(inventory); /*adds each row of the customer table in sql to the array list*/			
			
		}
		
		
		
		} catch(SQLException e1) {
			
			
			JOptionPane.showMessageDialog(null, "Inventory not found");			
		}
		
		return inventoryArr;
		
	}
	
	
	
	
	
}
