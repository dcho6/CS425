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

public class viewModel extends JFrame
{

	private JPanel contentPane;
	public static JTextField modelNumber;
	private JTable modelTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewModel frame = new viewModel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public viewModel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Model Number:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(10, 10, 193, 57);
		contentPane.add(lblNewLabel_1);
		
		modelNumber = new JTextField();
		modelNumber.setBounds(204, 10, 368, 57);
		contentPane.add(modelNumber);
		modelNumber.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 562, 259);
		contentPane.add(scrollPane);
		
		modelTable = new JTable();
		modelTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Model Number", "Sale Price", "Manufacturer"}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(modelTable);
		
		JButton viewAll = new JButton("View All Data");
		viewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ArrayList<Model> detail = functions.modelView();
					
					DefaultTableModel model = (DefaultTableModel)modelTable.getModel();
					
					model.setRowCount(0);/*resets the table so it only show the customer you are looking for*/
					
					Object[] row = new Object[3];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getModelNumber();
						
						row[1] = detail.get(i).getSalePrice();
						
						row[2] = detail.get(i).getManufacturer();
						
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
					
					ArrayList<Model> detail = functions.modelSearchView();
				
					DefaultTableModel model = (DefaultTableModel)modelTable.getModel();
					
					model.setRowCount(0);/*resets the table so it only show the customer you are looking for*/
					
					Object[] row = new Object[3];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getModelNumber();
						
						row[1] = detail.get(i).getSalePrice();
						
						row[2] = detail.get(i).getManufacturer();
						
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
