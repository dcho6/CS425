package CS425;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class updateInventory extends JFrame
{
	private JPanel contentPane;
	private JTextField modelNumber;
	private JTextField shelf_location;
	private JTextField stockQuantity;
	private JTextField leadTime;
	private JTextField category;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateInventory frame = new updateInventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public updateInventory()
	{		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		modelNumber = new JTextField();
		modelNumber.setBounds(166, 10, 407, 45);
		contentPane.add(modelNumber);
		modelNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Model No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(-10, 5, 166, 45);
		contentPane.add(lblNewLabel);
		
		shelf_location = new JTextField();
		shelf_location.setBounds(166, 70, 407, 45);
		contentPane.add(shelf_location);
		shelf_location.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Shelf Loc:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(-10, 65, 166, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock Quant:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 120, 146, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblleadTime = new JLabel("Lead Time:");
		lblleadTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblleadTime.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblleadTime.setBounds(10, 181, 146, 45);
		contentPane.add(lblleadTime);
		
		JLabel lblNewLabel_3 = new JLabel("Category:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(20, 236, 136, 45);
		contentPane.add(lblNewLabel_3);
		
		stockQuantity = new JTextField();
		stockQuantity.setColumns(10);
		stockQuantity.setBounds(166, 125, 407, 45);
		contentPane.add(stockQuantity);
		
		leadTime = new JTextField();
		leadTime.setColumns(10);
		leadTime.setBounds(166, 186, 407, 45);
		contentPane.add(leadTime);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(166, 236, 407, 45);
		contentPane.add(category);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connect = null;
				
					connect = functions.connect();
				
					String query = "UPDATE Inventory "
							+ "SET stock_quantity = ?, "
							+ "lead_time = ?, "
							+ "category_type  = ? "
							+ "WHERE model_number = ? AND shelf_location = ?";/*will be using the text field to fill in the values of ?*/
				
					PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
				
					myStmt.setLong(1, Integer.parseInt(stockQuantity.getText()));/*getting value entered for privilege*/
					
					myStmt.setString(2, leadTime.getText());/*getting value entered for stockQuantity*/
					
					myStmt.setString(3, category.getText());/*getting value entered for leadTime*/
					
					myStmt.setLong(4, Integer.parseInt(modelNumber.getText()));/*getting value entered for modelNumber*/
				
					myStmt.setString(5, shelf_location.getText());/*getting value entered for shelf location*/
					
					myStmt.executeUpdate();
					
					myStmt.close();
				
				}catch (Exception e1) {
				
				
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(219, 300, 261, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNotice = new JLabel("Warning: Model No. and Shelf Location must already exist");
		lblNotice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotice.setBounds(70, 350, 450, 45);
		contentPane.add(lblNotice);
		
	}
	
	
}
