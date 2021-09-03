import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
	static Connection conn;
	private JFrame frame;
	private JTextField nametf;
	private JTextField mobiletf;
	private JTextField cardno;
	private JTextField cusnametf;
	private JTextField purchasecosttf;
	private JTextField storenametf;
	//private JTable table;
	private JTable table_1;
	private String dob;
	private boolean refreshed=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					try {
						String url = "jdbc:mysql://localhost:3306/stdbms";
						String username="root";
						String password="hellogokul";
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn=DriverManager.getConnection(url,username,password);
						System.out.println("Connected");
						}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow(){
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		Border raised = BorderFactory.createRaisedBevelBorder();
		frame = new JFrame("PSG BANK");
		frame.getContentPane().setBackground(new Color(255, 255, 224));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		
		JLabel lblNewLabel = new JLabel("PSG BANK");
		lblNewLabel.setBackground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(218, 0, 322, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 90, 714, 360);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLocation(98, 25);
		panel.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Customer Application", null, panel, null);
		panel.setLayout(null);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Arial", Font.BOLD, 20));
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setBounds(60, 34, 197, 31);
		panel.add(name);
		
		nametf = new JTextField();
		nametf.setBounds(277, 34, 362, 31);
		nametf.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(nametf);
		nametf.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNumber.setFont(new Font("Arial", Font.BOLD, 20));
		lblMobileNumber.setBounds(60, 81, 197, 31);
		panel.add(lblMobileNumber);
		
		mobiletf = new JTextField();
		mobiletf.setColumns(10);
		mobiletf.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mobiletf.setBounds(277, 81, 362, 31);
		panel.add(mobiletf);
		
		JLabel lblExistingCustomer = new JLabel("Existing Customer");
		lblExistingCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		lblExistingCustomer.setFont(new Font("Arial", Font.BOLD, 20));
		lblExistingCustomer.setBounds(60, 164, 197, 31);
		panel.add(lblExistingCustomer);
		
		JRadioButton yes = new JRadioButton("Yes");
		yes.setFont(new Font("Arial", Font.PLAIN, 15));
		yes.setHorizontalAlignment(SwingConstants.LEFT);
		yes.setBackground(new Color(248, 248, 255));
		yes.setBounds(277, 171, 109, 23);
		panel.add(yes);
		
		JRadioButton no = new JRadioButton("No");
		no.setFont(new Font("Arial", Font.PLAIN, 15));
		no.setHorizontalAlignment(SwingConstants.LEFT);
		no.setBackground(new Color(248, 248, 255));
		no.setBounds(415, 171, 109, 23);
		panel.add(no);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateOfBirth.setFont(new Font("Arial", Font.BOLD, 20));
		lblDateOfBirth.setBounds(60, 123, 197, 31);
		panel.add(lblDateOfBirth);
		
		JLabel lblCardType = new JLabel("Card Number");
		lblCardType.setHorizontalAlignment(SwingConstants.LEFT);
		lblCardType.setFont(new Font("Arial", Font.BOLD, 20));
		lblCardType.setBounds(60, 206, 197, 31);
		panel.add(lblCardType);
		
		cardno = new JTextField();
		cardno.setColumns(10);
		cardno.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cardno.setBounds(277, 206, 362, 31);
		panel.add(cardno);
		
		JLabel lblCardTpe = new JLabel("Card Type");
		lblCardTpe.setHorizontalAlignment(SwingConstants.LEFT);
		lblCardTpe.setFont(new Font("Arial", Font.BOLD, 20));
		lblCardTpe.setBounds(60, 248, 197, 31);
		panel.add(lblCardTpe);
		
		JComboBox dd = new JComboBox();
		dd.setFont(new Font("Arial", Font.PLAIN, 15));
		dd.setModel(new DefaultComboBoxModel(new String[] {"DD", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dd.setBounds(277, 130, 63, 23);
		panel.add(dd);
		
		JComboBox mm = new JComboBox();
		mm.setFont(new Font("Arial", Font.PLAIN, 15));
		mm.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		mm.setBounds(362, 130, 63, 23);
		panel.add(mm);
		
		JComboBox yy = new JComboBox();
		yy.setFont(new Font("Arial", Font.PLAIN, 15));
		yy.setModel(new DefaultComboBoxModel(new String[] {"YYYY ", "1970 ", "1971", "1972 ", "1973 ", "1974 ", "1975 ", "1976 ", "1977 ", "1978 ", "1979 ", "1980 ", "1981 ", "1982 ", "1983", "1984 ", "1985 ", "1986 ", "1987 ", "1988 ", "1989 ", "1990 ", "1991", "1992 ", "1993 ", "1994 ", "1995 ", "1996 ", "1997 ", "1998 ", "1999 ", "2000 ", "2001 ", "2002 ", "2003 ", "2004 ", "2005 ", "2006 ", "2007 ", "2008 ", "2009 ", "2010 ", "2011 ", "2012 ", "2013 ", "2014 ", "2015 ", "2016 ", "2017 ", "2018 ", "2019 ", "2020"}));
		yy.setBounds(449, 130, 98, 23);
		panel.add(yy);
		
		JComboBox cardtype = new JComboBox();
		cardtype.setFont(new Font("Arial", Font.PLAIN, 15));
		cardtype.setModel(new DefaultComboBoxModel(new String[] {"Card Type","Savings","Credit","Student"}));
		cardtype.setBounds(277, 248, 362, 23);
		panel.add(cardtype);
		
		JButton savebtn = new JButton("Save");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dob=dd.getSelectedItem().toString()+'.'+mm.getSelectedItem().toString()+'.'+yy.getSelectedItem().toString();
				String existing = null;
				boolean done=false;
				if(yes.isSelected())
					existing="YES";
				if(no.isSelected())
					existing="NO";
				PreparedStatement fields;
				try {
					fields = conn.prepareStatement("INSERT INTO BANK VALUES(?,?,?,?,?,?);");
					fields.setString(1, nametf.getText());
					fields.setString(2, mobiletf.getText());
					fields.setString(3, dob);
					fields.setString(4, existing);
					fields.setString(5, cardno.getText());
					fields.setString(6, cardtype.getSelectedItem().toString());
					fields.execute();
					fields.close();
					done=true;
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog( savebtn, "Enter The Fields", "Warning", JOptionPane.PLAIN_MESSAGE );
				}
				if(done)
				{
					JOptionPane.showMessageDialog( savebtn, "Successfully Saved", "Warning", JOptionPane.PLAIN_MESSAGE );
					nametf.setText("");
					mobiletf.setText("");
					dd.setSelectedIndex(0);
					mm.setSelectedIndex(0);
					yy.setSelectedIndex(0);
					yes.setSelected(false);
					no.setSelected(false);
					cardno.setText("");
					cardtype.setSelectedIndex(0);
				}
					
			}
		});
		savebtn.setFont(new Font("Arial", Font.PLAIN, 20));
		savebtn.setBounds(177, 290, 139, 31);
		panel.add(savebtn);
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		exitbtn.setFont(new Font("Arial", Font.PLAIN, 20));
		exitbtn.setBounds(328, 290, 139, 31);
		panel.add(exitbtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Transactions", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCustomerName.setFont(new Font("Arial", Font.BOLD, 20));
		lblCustomerName.setBounds(53, 39, 197, 31);
		panel_1.add(lblCustomerName);
		
		cusnametf = new JTextField();
		cusnametf.setEditable(false);
		cusnametf.setColumns(10);
		cusnametf.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cusnametf.setBounds(270, 39, 362, 31);
		panel_1.add(cusnametf);
		
		JButton btnSelectCustomer = new JButton("Select Customer");
		btnSelectCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnSelectCustomer.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSelectCustomer.setBounds(424, 81, 208, 31);
		panel_1.add(btnSelectCustomer);
		
		JLabel lblPurchaseCost = new JLabel("Purchase Cost");
		lblPurchaseCost.setHorizontalAlignment(SwingConstants.LEFT);
		lblPurchaseCost.setFont(new Font("Arial", Font.BOLD, 20));
		lblPurchaseCost.setBounds(53, 134, 197, 31);
		panel_1.add(lblPurchaseCost);
		
		purchasecosttf = new JTextField();
		purchasecosttf.setColumns(10);
		purchasecosttf.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		purchasecosttf.setBounds(270, 134, 362, 31);
		panel_1.add(purchasecosttf);
		
		JLabel lblPayIn = new JLabel("Pay In");
		lblPayIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayIn.setFont(new Font("Arial", Font.BOLD, 20));
		lblPayIn.setBounds(53, 176, 197, 31);
		panel_1.add(lblPayIn);
		
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.setSelected(true);
		rdbtnCash.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCash.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnCash.setBackground(new Color(248, 248, 255));
		rdbtnCash.setBounds(270, 183, 109, 23);
		panel_1.add(rdbtnCash);
		
		JLabel lblStoreName = new JLabel("Store Name");
		lblStoreName.setHorizontalAlignment(SwingConstants.LEFT);
		lblStoreName.setFont(new Font("Arial", Font.BOLD, 20));
		lblStoreName.setBounds(53, 224, 197, 31);
		panel_1.add(lblStoreName);
		
		storenametf = new JTextField();
		storenametf.setColumns(10);
		storenametf.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		storenametf.setBounds(270, 224, 362, 31);
		panel_1.add(storenametf);
		
		JButton btnPerformTransaction = new JButton("Perform Transaction");
		btnPerformTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog( savebtn, "Successfully Saved", "Transaction Status", JOptionPane.PLAIN_MESSAGE );
				cusnametf.setText("");
	        	purchasecosttf.setText("");
	        	storenametf.setText("");
			}
		});
		btnPerformTransaction.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPerformTransaction.setBounds(398, 290, 234, 31);
		panel_1.add(btnPerformTransaction);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Search/Modify", null, panel_2, null);
		panel_2.setLayout(null);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		table_1 = new JTable(tableModel);
		tableModel.addColumn("Customer Name");
		tableModel.addColumn("Card type");
		tableModel.addTableModelListener(table_1);
		table_1.setBounds(10, 11, 689, 196);
		panel_2.add(table_1);
//		java.sql.Statement stmt;
//		try {
//			stmt = conn.createStatement();
//			ResultSet rs=stmt.executeQuery("SELECT * from stdbms.bank");
//			int i=0;
//			while(rs.next())
//			{
//				tableModel.insertRow(i, new Object[] { rs.getString(1),rs.getString(6)});
//				i++;
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 43, 689, 196);
		panel_2.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					tableModel.setRowCount(0);
					java.sql.Statement stmt;
					try {
						stmt = conn.createStatement();
						ResultSet rs=stmt.executeQuery("SELECT * from stdbms.bank order by 'name'");
						int i=0;
						while(rs.next())
						{
							tableModel.insertRow(i, new Object[] { rs.getString(1),rs.getString(6)});
							i++;
						}
						//btnNewButton_1.setEnabled(false);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\refresh-page-option.png"));
		btnNewButton_1.setBounds(657, 3, 42, 29);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("View Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details frame1 = new Details(table_1.getModel().getValueAt(table_1.getSelectedRow(),table_1.getSelectedColumn()).toString());
				System.out.println(table_1.getModel().getValueAt(table_1.getSelectedRow(),table_1.getSelectedColumn()).toString());
				//frame1.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnNewButton.setBounds(367, 260, 307, 39);
		panel_2.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\54f8735f-81e2-473e-93ca-ef26d514e58c.png"));
		lblNewLabel_1.setBounds(10, 11, 83, 68);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JButton btnPerformTransaction_1 = new JButton("Perform Transaction");
		btnPerformTransaction_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cusnametf.setText(table_1.getModel().getValueAt(table_1.getSelectedRow(),table_1.getSelectedColumn()).toString());
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnPerformTransaction_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnPerformTransaction_1.setBounds(42, 260, 307, 39);
		panel_2.add(btnPerformTransaction_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog( rootPane, "Are You Sure? Do You want to Delete?", "Warning",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	try {
								java.sql.Statement stmt;
								stmt = conn.createStatement();
								stmt.executeUpdate("DELETE FROM stdbms.bank WHERE name = '"+table_1.getModel().getValueAt(table_1.getSelectedRow(),table_1.getSelectedColumn()).toString()+"'");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}  
			            }
			            else if(result == JOptionPane.NO_OPTION) {
			            	
			            }
			}
		});
		btnNewButton_2.setBounds(10, 12, 98, 26);
		panel_2.add(btnNewButton_2);
		
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog( rootPane, "Are You Sure? Do You want to Delete? Cannot be UNDONE!", "Warning",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	try {
								java.sql.Statement stmt;
								stmt = conn.createStatement();
								stmt.executeUpdate("DELETE FROM stdbms.bank;");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}  
			            }
			            else if(result == JOptionPane.NO_OPTION) {
			            	
			            }
			}
		});
		btnDeleteAll.setBounds(120, 12, 98, 26);
		panel_2.add(btnDeleteAll);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Credit Card Approval System");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(130, 75, 475, 14);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
