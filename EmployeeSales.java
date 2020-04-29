package CS425;

public class EmployeeSales {
	private String employee_id;
	private int ssn, total_sales;
	
	public EmployeeSales (int ssn, String employee_id, int total_sales)
	{
		this.ssn = ssn;
		this.employee_id = employee_id;
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
	
	public int getTotalSales()
	{
		return total_sales;
	}
	
	
}
