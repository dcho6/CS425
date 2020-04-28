package finalProjectCS425;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> detail = functions.customerDetail();
			
			Object[] row = new Object[7];
			
			for(int i=0; i<detail.size();i++) {
				
				System.out.print(detail.get(i).getCustomerID());
	
				
			}
			
		
		
	}

}
