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
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class deleteEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField employeeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteEmployee frame = new deleteEmployee();
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
	public deleteEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 42, 130, 47);
		contentPane.add(lblNewLabel);
		
		employeeID = new JTextField();
		employeeID.setBounds(150, 47, 286, 47);
		contentPane.add(employeeID);
		employeeID.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Connection connect = null;
				
				connect = functions.connect();
			
				String query = "DELETE FROM Employee where employee_id = ?";/*will be using the text field to fill in the values of ?*/
			
				PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
			
				myStmt.setString(1, employeeID.getText());/*parameter for checking the username*/
				
				myStmt.executeUpdate();
				
				myStmt.close();} catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Employee ID Doesn't Exist");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(112, 134, 217, 52);
		contentPane.add(btnNewButton);
		
		
	}
}
