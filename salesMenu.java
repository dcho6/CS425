package finalProjectCS425;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class salesMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salesMenu frame = new salesMenu();
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
	public salesMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				createCustomer menu = new createCustomer();
				menu.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(10, 10, 217, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Purchase Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				createPurchaseOrder menu = new createPurchaseOrder();
				menu.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_1.setBounds(10, 58, 271, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Customer Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewCustomerDetails menu = new viewCustomerDetails();
				menu.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_2.setBounds(10, 108, 271, 40);
		contentPane.add(btnNewButton_2);
	}

}
