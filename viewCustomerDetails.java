package CS425;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class viewCustomerDetails extends JFrame {

	private JPanel contentPane;
	public static JTextField customerID;
	private JTable customerDetailTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewCustomerDetails frame = new viewCustomerDetails();
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
	public viewCustomerDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(10, 10, 193, 57);
		contentPane.add(lblNewLabel);
		
		customerID = new JTextField();
		customerID.setBounds(204, 10, 368, 57);
		contentPane.add(customerID);
		customerID.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 562, 259);
		contentPane.add(scrollPane);
		
		customerDetailTable = new JTable();
		customerDetailTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Employee ID", "Order Number", "Company", "Quantity", "Sale Value", "Prefernce"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(customerDetailTable);
		
		JButton viewAll = new JButton("View All Data");
		viewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ArrayList<Customer> detail = functions.customerDetail();
					
					DefaultTableModel model = (DefaultTableModel)customerDetailTable.getModel();
					
					Object[] row = new Object[7];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getCustomerID();
						
						row[1] = detail.get(i).getEmployeeID();
						
						row[2] = detail.get(i).getOrderNumber();
						
						row[3] = detail.get(i).getCompany();
						
						row[4] = detail.get(i).getQuantity();
						
						row[5] = detail.get(i).getsaleValue();
						
						row[6] = detail.get(i).getPreference();
						
						model.addRow(row);
						
					}
					
					
					
				
				}catch (Exception e1) {
				
				
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
				
				
			}
		});
		viewAll.setFont(new Font("Tahoma", Font.PLAIN, 23));
		viewAll.setBounds(56, 77, 184, 41);
		contentPane.add(viewAll);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {/*this is the search specific function*/
					
					ArrayList<Customer> detail = functions.customerSearchDetail();
					
					DefaultTableModel model = (DefaultTableModel)customerDetailTable.getModel();
					
					model.setRowCount(0);/*resets the table so it only show the customer you are looking for*/
					
					Object[] row = new Object[7];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getCustomerID();
						
						row[1] = detail.get(i).getEmployeeID();
						
						row[2] = detail.get(i).getOrderNumber();
						
						row[3] = detail.get(i).getCompany();
						
						row[4] = detail.get(i).getQuantity();
						
						row[5] = detail.get(i).getsaleValue();
						
						row[6] = detail.get(i).getPreference();
						
						model.addRow(row);
						
					}
					
				
				}catch (Exception e1) {
				
				
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
				
				
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSearch.setBounds(342, 77, 184, 41);
		contentPane.add(btnSearch);
		
		
		
		
	}
}
