package CS425;

public class EmployeeLimited {
	private String employee_id, privilege_type, first_name, last_name, username;
	
	public EmployeeLimited (String employee_id, String privilege_type, String first_name, String last_name, String username)
	{
		this.employee_id = employee_id;
		this.privilege_type = privilege_type;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		
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
	
	
}
