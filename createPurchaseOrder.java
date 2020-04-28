package finalProjectCS425;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class createPurchaseOrder extends JFrame {

	private JPanel contentPane;
	private JTextField orderNumber;
	private JTextField customerID;
	private JTextField employeeID;
	private JTextField itemQuantity;
	private JTextField saleValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createPurchaseOrder frame = new createPurchaseOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public createPurchaseOrder() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 10, 172, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCustomerId.setBounds(10, 73, 172, 53);
		contentPane.add(lblCustomerId);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmployeeId.setBounds(10, 136, 172, 53);
		contentPane.add(lblEmployeeId);
		
		JLabel lblItemQuantity = new JLabel("Item Quantity:");
		lblItemQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblItemQuantity.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblItemQuantity.setBounds(10, 199, 172, 53);
		contentPane.add(lblItemQuantity);
		
		JLabel lblSaleValue = new JLabel("Sale Value:");
		lblSaleValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaleValue.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSaleValue.setBounds(10, 262, 172, 53);
		contentPane.add(lblSaleValue);
		
		orderNumber = new JTextField();
		orderNumber.setBounds(192, 10, 336, 53);
		contentPane.add(orderNumber);
		orderNumber.setColumns(10);
		
		customerID = new JTextField();
		customerID.setColumns(10);
		customerID.setBounds(192, 73, 336, 53);
		contentPane.add(customerID);
		
		employeeID = new JTextField();
		employeeID.setColumns(10);
		employeeID.setBounds(192, 136, 336, 53);
		contentPane.add(employeeID);
		
		itemQuantity = new JTextField();
		itemQuantity.setColumns(10);
		itemQuantity.setBounds(192, 199, 336, 53);
		contentPane.add(itemQuantity);
		
		saleValue = new JTextField();
		saleValue.setColumns(10);
		saleValue.setBounds(192, 262, 336, 53);
		contentPane.add(saleValue);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connect = null;
					
					connect = functions.connect();
				
					String query = "INSERT INTO purchaseorder VALUES (?, ?, ?, ?, ?)";/*will be using the text field to fill in the values of ?*/
				
					PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
				
					myStmt.setLong(1, Integer.parseInt(orderNumber.getText()));/*getting the entered value for ssn*/
					
					myStmt.setString(2, customerID.getText());/*getting value enetered for employeeID*/
					
					myStmt.setString(3, employeeID.getText());/*getting value enetered for privilege*/
					
					myStmt.setLong(4, Integer.parseInt(itemQuantity.getText()));/*getting value enetered for password*/
					
					myStmt.setLong(5, Integer.parseInt(saleValue.getText()));/*getting value enetered for password*/
				
					myStmt.executeUpdate();
					
					myStmt.close();} catch(Exception e1){
						

						JOptionPane.showMessageDialog(null, "please enter the correct value in each field");
						
					}
					
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(163, 325, 252, 39);
		contentPane.add(btnNewButton);
	}

}
