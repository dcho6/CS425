package CS425;

public class Inventory {

	private int model_number, stock_quantity;
	
	private String shelf_location, lead_time, category;
	
	public Inventory(int model_number, String shelf_location, int stock_quantity, String lead_time, String category)
	{
		
		this.model_number = model_number;
		this.shelf_location = shelf_location;
		this.stock_quantity = stock_quantity;
		this.lead_time = lead_time;
		this.category = category;
	
	}
	
	public int getModelNumber()
	{
		return model_number;
		
	}
	
	public String getShelfLocation()
	{
		return shelf_location;
		
	}
	
	public int getStock()
	{
		return stock_quantity;
	
	}
	
	public String getLead()
	{
		return lead_time;
		
	}
	
	public String getCategory()
	{
		return category;
	}
	
}
