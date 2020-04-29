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

public class viewEmployeeLimited extends JFrame
{

	private JPanel contentPane;
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
					viewEmployeeLimited frame = new viewEmployeeLimited();
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
	public viewEmployeeLimited() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(10, 10, 193, 57);
		contentPane.add(lblNewLabel_1);
		
		employeeID = new JTextField();
		employeeID.setBounds(204, 10, 368, 57);
		contentPane.add(employeeID);
		employeeID.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 562, 259);
		contentPane.add(scrollPane);
		
		employeeTable = new JTable();
		employeeTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Emp ID", "F Name", "L Name", "Username", "Privilege"}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
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
					
					model.setRowCount(0);/*resets the table so it only show the customer you are looking for*/
					
					Object[] row = new Object[5];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getEmployeeID();
						
						row[1] = detail.get(i).getFirstName();
						
						row[2] = detail.get(i).getLastName();
						
						row[3] = detail.get(i).getUsername();
						
						row[4] = detail.get(i).getPrivilege();
						
						model.addRow(row);
						
					}
					
					
					
				
				}catch (Exception e1) {
				
				
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
				
				
			}
		});
		viewAll.setFont(new Font("Tahoma", Font.PLAIN, 23));
		viewAll.setBounds(56, 85, 184, 41);
		contentPane.add(viewAll);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {/*this is the search specific function*/
					
					ArrayList<EmployeeLimited> detail = functions.employeeLimitedSearch();
				
					DefaultTableModel model = (DefaultTableModel)employeeTable.getModel();
					
					model.setRowCount(0);/*resets the table so it only show the customer you are looking for*/
					
					Object[] row = new Object[5];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getEmployeeID();
						
						row[1] = detail.get(i).getFirstName();
						
						row[2] = detail.get(i).getLastName();
						
						row[3] = detail.get(i).getUsername();
						
						row[4] = detail.get(i).getPrivilege();
						
						model.addRow(row);
						
					}
					
				
				}catch (Exception e1) {
				
			
					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
				}
				
		
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSearch.setBounds(342, 85, 184, 41);
		contentPane.add(btnSearch);
		
		
		
		
	}
}
