package uio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;    

public class technetian {

	private JFrame frame;
	private JTextField date;
	private JTextField medicine;
	@SuppressWarnings("rawtypes")
	private JComboBox c1;
	@SuppressWarnings("rawtypes")
	private JComboBox c2;
	@SuppressWarnings("rawtypes")
	private JComboBox c3;
	@SuppressWarnings("rawtypes")
	private JComboBox c4;
	private JTextField age;
	private JTextField con;
	private JCheckBox chk1;
	private JCheckBox chk2;
	private JCheckBox chk3;
	private JCheckBox chk4;
	public String x;
	public String y;
	public String z;
	public String o;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					technetian window = new technetian();
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
	public technetian() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 876, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setSize(876, 737);
		frame.setLocationRelativeTo(null);  
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\resizedImage (3).png"));
		lblNewLabel.setBounds(394, 11, 114, 114);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(94, 201, 126, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(449, 201, 126, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		date = new JTextField();
		date.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
				LocalDateTime now = LocalDateTime.now();  
			    date.setText(dtf.format(now));
			}
		});
		date.setBounds(571, 202, 212, 29);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Doctor Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(449, 239, 126, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Major Disease");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(449, 277, 126, 27);
		frame.getContentPane().add(lblNewLabel_4);
			
		JLabel lblNewLabel_5 = new JLabel("Blood Group");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(294, 338, 126, 27);
		frame.getContentPane().add(lblNewLabel_5);
			
		JSeparator separator = new JSeparator();
		separator.setBounds(201, 376, 496, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(201, 376, 35, 128);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(201, 501, 496, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(696, 376, 2, 128);
		frame.getContentPane().add(separator_3);
		
		medicine = new JTextField();
		medicine.setBounds(201, 515, 499, 100);
		frame.getContentPane().add(medicine);
		medicine.setColumns(10);
		
		chk1 = new JCheckBox("high blood pressure");
		chk1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					x = "YES";
				}else {
					x = "NO";
				}
			}
		});
		
		chk1.setBackground(Color.PINK);
		chk1.setBounds(240, 411, 166, 23);
		frame.getContentPane().add(chk1);
		
		chk2 = new JCheckBox("being overweight");
		chk2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					y = "YES";
				}else {
					y = "NO";
				}
			}
		});
		chk2.setBackground(Color.PINK);
		chk2.setBounds(495, 411, 155, 23);
		frame.getContentPane().add(chk2);
		
		chk3 = new JCheckBox("diabetes");
		chk3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					z = "YES";
				}else {
					z = "NO";
				}
			}
		});
		chk3.setBackground(Color.PINK);
		chk3.setBounds(240, 458, 166, 23);
		frame.getContentPane().add(chk3);
		
		chk4 = new JCheckBox("HIV");
		chk4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					o = "YES";
				}else {
					o = "NO";
				}
			}
		});
		chk4.setBackground(Color.PINK);
		chk4.setBounds(495, 458, 155, 23);
		frame.getContentPane().add(chk4);
		
		JButton addrec = new JButton("ADD Record");
		addrec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbConnection conn = new DbConnection();
				String name = (String)c1.getSelectedItem();
				String setAge = age.getText();
				String setDate = date.getText();
				String doctorName = (String)c2.getSelectedItem();
				String disease = (String)c3.getSelectedItem();
				String bloodGroup = (String)c4.getSelectedItem();
				String pres = medicine.getText();
				String cona = con.getText();
				try {
					String sql = "INSERT INTO `allpatientreport`(`Name`, `Age`, `Date`, `DoctorName`, `Disease`, `BloodGroup`, `hbp`, `ow`, `dia`, `hiv`, `prescription`,`contact`) VALUES ('"+name+"','"+setAge+"','"+setDate+"','"+doctorName+"','"+disease+"','"+bloodGroup+"','"+x+"','"+y+"','"+z+"','"+o+"','"+pres+"','"+cona+"')";
					conn.s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Record Added Successfully");
					  new technetian();
					  technetian.main(null);
					  frame.dispose();
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
		addrec.setFont(new Font("Tahoma", Font.BOLD, 14));
		addrec.setBackground(Color.PINK);
		addrec.setBounds(197, 626, 138, 36);
		frame.getContentPane().add(addrec);
		
		c1 = new JComboBox();
		c1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `username` FROM `patient` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						c1.addItem(rs.getString("username"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		c1.setBounds(201, 203, 212, 27);
		frame.getContentPane().add(c1);
		
		c2 = new JComboBox();
		c2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `username` FROM `doctor` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						c2.addItem(rs.getString("username"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		c2.setBounds(571, 241, 212, 27);
		frame.getContentPane().add(c2);
		
		c3 = new JComboBox();
		c3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `name` FROM `disease` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						c3.addItem(rs.getString("name"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		c3.setBounds(571, 279, 212, 27);
		frame.getContentPane().add(c3);
		
		c4 = new JComboBox();
		c4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `name` FROM `bloodgroup` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						c4.addItem(rs.getString("name"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		c4.setBounds(414, 338, 212, 27);
		frame.getContentPane().add(c4);
		
		JLabel lblNewLabel_7 = new JLabel("Age");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(95, 237, 114, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		age = new JTextField();
		age.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection cont = new DbConnection();
				String user = (String)c1.getSelectedItem();
				String sql = "SELECT `age` FROM `patient` WHERE username='"+user+"'";
				try {
					ResultSet rs = cont.s.executeQuery(sql);
					while(rs.next()) {
						age.setText(rs.getString("age"));
					}
				}catch(Exception error) {
					
				}
				
			}
		});
		age.setBounds(201, 240, 212, 29);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Contact");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(94, 277, 79, 27);
		frame.getContentPane().add(lblNewLabel_8);
		
		con = new JTextField();
		con.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection cont = new DbConnection();
				String user = (String)c1.getSelectedItem();
				String sql = "SELECT `contact` FROM `patient` WHERE username='"+user+"'";
				try {
					ResultSet rs = cont.s.executeQuery(sql);
					while(rs.next()) {
						con.setText(rs.getString("contact"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		con.setBounds(201, 282, 212, 29);
		frame.getContentPane().add(con);
		con.setColumns(10);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new fg();
				uio.fg.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(571, 626, 127, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel_6.setBounds(0, 0, 872, 698);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
