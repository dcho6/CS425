package CS425;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class hrMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hrMenu frame = new hrMenu();
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
	public hrMenu() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btnNewButton = new JButton("View Employee Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				viewEmployee menu = new viewEmployee();
				menu.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(10, 10, 271, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Employee Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updateEmployee menu = new updateEmployee();
				menu.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_1.setBounds(10, 58, 271, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Employee Sales");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				viewEmployeeSales menu = new viewEmployeeSales();
				menu.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_2.setBounds(10, 108, 271, 40);
		contentPane.add(btnNewButton_2);
	}
}
