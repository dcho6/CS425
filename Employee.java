package CS425;

public class Employee {
	private String employee_id, privilege_type, first_name, last_name, username, password, pay_type;
	private int ssn, pay, total_sales;
	
	public Employee (int ssn, String employee_id, String privilege_type, String first_name, String last_name, String username, String password, String pay_type, int pay, int total_sales)
	{
		this.ssn = ssn;
		this.employee_id = employee_id;
		this.privilege_type = privilege_type;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.pay_type = pay_type;
		this.pay = pay;
		this.total_sales = total_sales;
		
	}
	
	public int getSSN()
	{
		return ssn;
		
	}
	
	public String getEmployeeID()
	{
		return employee_id;
	}
	
	public String getPrivilege()
	{
		return privilege_type;
	}
	
	public String getFirstName()
	{
		return first_name;
		
	}
	
	public String getLastName()
	{
		return last_name;
	}
	
	public String getUsername()
	{
		return username;
		
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getPayType()
	{
		return pay_type;
	}
	
	public int getPay()
	{
		return pay;
	}
	
	public int getTotalSales()
	{
		return total_sales;
	}
	
	
}
