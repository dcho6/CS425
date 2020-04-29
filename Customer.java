package CS425;

public class Customer {/*this is used to create the customer data for our array list*/
	
	private String customerID, preference, company, employeeID;
	
	private int orderNumber, quantity, saleValue;
	
	public Customer(int orderNumber, int quantity, int saleValue, String customerID, String preference, String company, String employeeID) {
		
		this.orderNumber=orderNumber;
		
		this.quantity=quantity;
		
		this.saleValue=saleValue;
		
		this.customerID=customerID;
		
		this.company=company;
		
		this.employeeID=employeeID;
		
		this.preference=preference;
		
	}
	public int getOrderNumber() {
	
		return orderNumber;
		
	}
	
	public int getQuantity() {
		
		return quantity;
		
	}public int getsaleValue() {
	
		return saleValue;
		
	}
	
	public String getCustomerID() {
		
		return customerID;
		
	}
	
	public String getPreference() {
		
		return preference;
		
	}public String getCompany() {
		
		return company;
		
	}public String getEmployeeID() {
		
		return employeeID;
		
	}

}
