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

public class viewEmployeeSales extends JFrame
{

	private JPanel contentPane;
	public static JTextField ssn;
	public static JTextField employeeID;
	private JTable employeeTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewEmployeeSales frame = new viewEmployeeSales();
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
	public viewEmployeeSales() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SSN:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(-10, 10, 193, 57);
		contentPane.add(lblNewLabel);
		
		ssn = new JTextField();
		ssn.setBounds(204, 10, 368, 57);
		contentPane.add(ssn);
		ssn.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(-10, 100, 193, 57);
		contentPane.add(lblNewLabel_1);
		
		employeeID = new JTextField();
		employeeID.setBounds(204, 100, 368, 57);
		contentPane.add(employeeID);
		employeeID.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 613, 259);
		contentPane.add(scrollPane);
		
		employeeTable = new JTable();
		employeeTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"SSN", "Employee ID", "Total Sales"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(employeeTable);
		
		JButton viewAll = new JButton("View All Data");
		viewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ArrayList<Employee> detail = functions.employeeView();
					
					DefaultTableModel model = (DefaultTableModel)employeeTable.getModel();
					
					model.setRowCount(0);/*resets the table*/
					
					Object[] row = new Object[3];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getSSN();
						
						row[1] = detail.get(i).getEmployeeID();
						
						row[2] = detail.get(i).getTotalSales();
						
						model.addRow(row);
						
					}
					
					
					
				
				}catch (Exception e1) {
				
				
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
				
				
			}
		});
		viewAll.setFont(new Font("Tahoma", Font.PLAIN, 23));
		viewAll.setBounds(56, 190, 184, 41);
		contentPane.add(viewAll);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {/*this is the search specific function*/
					
					ArrayList<EmployeeSales> detail = functions.employeeSalesSearch();
				
					DefaultTableModel model = (DefaultTableModel)employeeTable.getModel();
					
					model.setRowCount(0);/*resets the table*/
					
					Object[] row = new Object[3];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getSSN();
						
						row[1] = detail.get(i).getEmployeeID();
						
						row[2] = detail.get(i).getTotalSales();
						
						model.addRow(row);
						
					}
					
				
				}catch (Exception e1) {
				
			
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
				
		
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSearch.setBounds(342, 190, 184, 41);
		contentPane.add(btnSearch);
		
		
		
		
	}
}
