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

public class viewInventory extends JFrame
{

	private JPanel contentPane;
	public static JTextField modelNumber;
	public static JTextField shelfLoc;
	private JTable inTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewInventory frame = new viewInventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public viewInventory() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Model Number:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(-10, 10, 193, 57);
		contentPane.add(lblNewLabel);
		
		modelNumber = new JTextField();
		modelNumber.setBounds(204, 10, 368, 57);
		contentPane.add(modelNumber);
		modelNumber.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Shelf Location:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(-10, 100, 193, 57);
		contentPane.add(lblNewLabel_1);
		
		shelfLoc = new JTextField();
		shelfLoc.setBounds(204, 100, 368, 57);
		contentPane.add(shelfLoc);
		shelfLoc.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 613, 259);
		contentPane.add(scrollPane);
		
		inTable = new JTable();
		inTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Model No.", "Shelf Loc.", "Stock", "Lead Time", "Category"}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(inTable);
		
		JButton viewAll = new JButton("View All Data");
		viewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ArrayList<Inventory> detail = functions.inventoryView();
					
					DefaultTableModel model = (DefaultTableModel)inTable.getModel();
					
					model.setRowCount(0);/*resets the table*/
					
					Object[] row = new Object[9];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getModelNumber();
						
						row[1] = detail.get(i).getShelfLocation();
						
						row[2] = detail.get(i).getStock();
						
						row[3] = detail.get(i).getLead();
						
						row[4] = detail.get(i).getCategory();
						
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
					
					ArrayList<Inventory> detail = functions.inventorySearchView();
				
					DefaultTableModel model = (DefaultTableModel)inTable.getModel();
					
					model.setRowCount(0);/*resets the table so it only show the customer you are looking for*/
					
					Object[] row = new Object[5];
					
					for(int i=0; i<detail.size();i++) {
						
						row[0] = detail.get(i).getModelNumber();
						
						row[1] = detail.get(i).getShelfLocation();
						
						row[2] = detail.get(i).getStock();
						
						row[3] = detail.get(i).getLead();
						
						row[4] = detail.get(i).getCategory();
						
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
