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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Details extends JFrame {
	public static Connection conn;
	private JTextField nametf;
	private JTextField mobiletf;
	private JTextField cardno;
	private JTable table;
	private String dob;
	private JTextField ddtf;
	private JFrame frame;
	String name1;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					//Details f = new Details("");
					//f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Details(String n) {
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
		name1=n;
		Border raised = BorderFactory.createRaisedBevelBorder();
		JFrame frame = new JFrame("PSG BANK");
		frame.setForeground(Color.LIGHT_GRAY);
		frame.setBackground(new Color(255, 255, 224));
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("PSG BANK");
		lblNewLabel.setBackground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Anton", Font.BOLD, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
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
		
		JComboBox cardtype = new JComboBox();
		cardtype.setFont(new Font("Arial", Font.PLAIN, 15));
		cardtype.setModel(new DefaultComboBoxModel(new String[] {"Card Type","Savings","Credit","Student"}));
		cardtype.setBounds(277, 248, 362, 23);
		panel.add(cardtype);
		
	
		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		exitbtn.setFont(new Font("Arial", Font.PLAIN, 20));
		exitbtn.setBounds(385, 290, 139, 31);
		panel.add(exitbtn);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dob=ddtf.getText();
				String existing = null;
				boolean done=false;
				if(yes.isSelected())
					existing="YES";
				if(no.isSelected())
					existing="NO";
				PreparedStatement fields;
				try {
					fields = conn.prepareStatement("UPDATE stdbms.bank SET name='"+nametf.getText()+"', mobileno = '"+mobiletf.getText()+"',dob='"+dob+"', existingcustomer = '"+existing+"',cardno='"+cardno.getText()+"',cardtype='"+cardtype.getSelectedItem().toString()+"' WHERE name = '"+name1+"'");
//					fields.setString(1, nametf.getText());
//					fields.setString(2, mobiletf.getText());
//					fields.setString(3, dob);
//					fields.setString(4, existing);
//					fields.setString(5, cardno.getText());
//					fields.setString(6, cardtype.getSelectedItem().toString());
					fields.execute();
					fields.close();
					done=true;
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog( save, "Enter The Fields", "Warning", JOptionPane.PLAIN_MESSAGE );
				}
				if(done)
					JOptionPane.showMessageDialog( save, "Successfully Saved", "Warning", JOptionPane.PLAIN_MESSAGE );
			}
		});
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.setBounds(211, 290, 139, 31);
		panel.add(save);
		
		ddtf = new JTextField();
		ddtf.setColumns(10);
		ddtf.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ddtf.setBounds(277, 123, 362, 31);
		panel.add(ddtf);
		//n="Lahfir";
		java.sql.Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * from bank WHERE name = '"+name1+"'");
			if(rs.next())
			{
				nametf.setText(rs.getString(1));
				mobiletf.setText(rs.getString(2));
				ddtf.setText(rs.getString(3));
				if(rs.getString(4).equals("YES"))
					yes.setSelected(true);
				if(rs.getString(4).equals("NO"))
					no.setSelected(true);
				cardno.setText(rs.getString(5));
				cardtype.setSelectedItem(rs.getString(6));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\\\Users\\\\ELCOT\\\\Desktop\\\\54f8735f-81e2-473e-93ca-ef26d514e58c.png"));
		lblNewLabel_1.setBounds(10, 11, 83, 68);
		
		JLabel lblNewLabel_2 = new JLabel("Credit Card Approval System");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(130, 75, 475, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 746, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
