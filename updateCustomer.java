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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class updateCustomer extends JFrame
{

	private JPanel contentPane;
	private JTextField costumerID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField company;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateCustomer frame = new updateCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public updateCustomer()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text2 = new JLabel("Customer ID:");
		text2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		text2.setHorizontalAlignment(SwingConstants.RIGHT);
		text2.setBounds(10, 10, 166, 54);
		contentPane.add(text2);
		
		costumerID = new JTextField();
		costumerID.setBounds(186, 10, 315, 54);
		contentPane.add(costumerID);
		costumerID.setColumns(10);
		
		JLabel text1 = new JLabel("First Name:");
		text1.setHorizontalAlignment(SwingConstants.RIGHT);
		text1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		text1.setBounds(20, 74, 156, 54);
		contentPane.add(text1);
		
		firstName = new JTextField();
		firstName.setBounds(186, 74, 315, 54);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLastName.setBounds(20, 138, 156, 54);
		contentPane.add(lblLastName);
		
		JLabel lblCompany = new JLabel("Company:");
		lblCompany.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCompany.setBounds(20, 202, 156, 54);
		contentPane.add(lblCompany);
		
		lastName = new JTextField();
		lastName.setBounds(186, 138, 315, 54);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		company = new JTextField();
		company.setColumns(10);
		company.setBounds(186, 202, 315, 54);
		contentPane.add(company);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection connect = null;
				
				connect = functions.connect();
			
				String query = "UPDATE Customer "
						+ "SET first_name = ?, "
						+ "last_name = ?, "
						+ "company = ? "
						+ "WHERE customer_id = ?";/*will be using the text field to fill in the values of ?*/
			
				PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
				
				myStmt.setString(1, firstName.getText());/*getting value enetered for employeeID*/
				
				myStmt.setString(2, lastName.getText());/*getting value enetered for privilege*/
				
				myStmt.setString(3, company.getText());/*getting value enetered for password*/
			
				myStmt.setString(4, costumerID.getText());/*getting the entered value for ssn*/
				
				myStmt.executeUpdate();
				
				myStmt.close();} catch(Exception e1){
					

					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(156, 266, 250, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblNotice = new JLabel("Warning: Customer ID must already exist");
		lblNotice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotice.setBounds(10, 320, 450, 45);
		contentPane.add(lblNotice);
		
	}
}
