package CS425;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMenu frame = new adminMenu();
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
	public adminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton createEmployee = new JButton("create employee");
		createEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				createEmployee menu = new createEmployee();
				menu.setVisible(true);
				
			}
		});
		createEmployee.setFont(new Font("Tahoma", Font.PLAIN, 23));
		createEmployee.setBounds(10, 10, 237, 48);
		contentPane.add(createEmployee);
		
		JButton deleteEmployee = new JButton("delete employee");
		deleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteEmployee menu = new deleteEmployee();
				menu.setVisible(true);
				
			}
		});
		deleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 23));
		deleteEmployee.setBounds(10, 68, 237, 48);
		contentPane.add(deleteEmployee);
	}
}
