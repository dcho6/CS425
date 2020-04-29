package CS425;

public class Model {
	private int model_number, sale_price;
	private String manufacturer;
	
	public Model(int model_number, int sale_price, String manufacturer)
	{
		this.model_number = model_number;
		
		this.sale_price = sale_price;
		
		this.manufacturer = manufacturer;
		
	}
	
	public int getModelNumber()
	{
		return model_number;
	}
	
	public int getSalePrice()
	{
		return sale_price;
	}
	
	public String getManufacturer()
	{
		return manufacturer;
	}
	
	
}
