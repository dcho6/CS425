package CS425;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class createEmployee extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField ssn;
	private JTextField employeeID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField username;
	private JTextField password;
	private JTextField pay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createEmployee frame = new createEmployee();
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
	public createEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ssn = new JTextField();
		ssn.setBounds(166, 10, 362, 45);
		contentPane.add(ssn);
		ssn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SSN:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(57, 5, 99, 45);
		contentPane.add(lblNewLabel);
		
		employeeID = new JTextField();
		employeeID.setBounds(166, 70, 407, 45);
		contentPane.add(employeeID);
		employeeID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(-10, 65, 166, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 120, 146, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLastName.setBounds(10, 181, 146, 45);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(20, 236, 136, 45);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(20, 291, 136, 45);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblPay = new JLabel("Pay Type:");
		lblPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPay.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPay.setBounds(20, 346, 136, 45);
		contentPane.add(lblPay);
		
		JLabel lblPay_1 = new JLabel("Pay:");
		lblPay_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPay_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPay_1.setBounds(20, 401, 136, 45);
		contentPane.add(lblPay_1);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(166, 125, 407, 45);
		contentPane.add(firstName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(166, 186, 407, 45);
		contentPane.add(lastName);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(166, 236, 407, 45);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(166, 291, 407, 45);
		contentPane.add(password);
		
		pay = new JTextField();
		pay.setColumns(10);
		pay.setBounds(166, 401, 407, 45);
		contentPane.add(pay);
		
		JComboBox privilege = new JComboBox();
		privilege.setFont(new Font("Tahoma", Font.PLAIN, 23));
		privilege.setModel(new DefaultComboBoxModel(new String[] {"admin", "HR", "engineer", "sales"}));
		privilege.setBounds(166, 457, 407, 45);
		contentPane.add(privilege);
		
		JComboBox payType = new JComboBox();
		payType.setFont(new Font("Tahoma", Font.PLAIN, 23));
		payType.setModel(new DefaultComboBoxModel(new String[] {"Hourly", "Salary"}));
		payType.setBounds(166, 346, 407, 45);
		contentPane.add(payType);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connect = null;
				
					connect = functions.connect();
				
					String query = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";/*will be using the text field to fill in the values of ?*/
				
					PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
				
					myStmt.setLong(1, Integer.parseInt(ssn.getText()));/*getting the entered value for ssn*/
					
					myStmt.setString(2, employeeID.getText());/*getting value enetered for employeeID*/
					
					myStmt.setString(3, (String)privilege.getSelectedItem());/*getting value enetered for privilege*/
					
					myStmt.setString(4, firstName.getText());/*getting value enetered for firstName*/
					
					myStmt.setString(5, lastName.getText());/*getting value enetered for lastName*/
					
					myStmt.setString(6, password.getText());/*getting value enetered for password*/
					
					myStmt.setString(7, (String)payType.getSelectedItem());/*getting value enetered for payType*/
					
					myStmt.setLong(8, Integer.parseInt(pay.getText()));/*getting value enetered for pay*/
					
					myStmt.setLong(9, 0);/*setting total sales to zero*/
				
					myStmt.setString(10, username.getText());/*getting value enetered for username*/
				
					myStmt.executeUpdate();
					
					myStmt.close();
				
				}catch (Exception e1) {
				
				
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(219, 512, 261, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblPriveledge = new JLabel("Privilege:");
		lblPriveledge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriveledge.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPriveledge.setBounds(20, 456, 136, 45);
		contentPane.add(lblPriveledge);
		
		
	}
}
