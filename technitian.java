package uio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		frame.setBounds(100, 100, 876, 761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\resizedImage (3).png"));
		lblNewLabel.setBounds(394, 11, 114, 114);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(240, 144, 126, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(240, 224, 126, 27);
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
		date.setBounds(419, 224, 212, 27);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Doctor Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(240, 262, 126, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Major Disease");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(240, 300, 126, 27);
		frame.getContentPane().add(lblNewLabel_4);
			
		JLabel lblNewLabel_5 = new JLabel("Blood Group");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(240, 338, 126, 27);
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
		medicine.setBounds(198, 514, 499, 128);
		frame.getContentPane().add(medicine);
		medicine.setColumns(10);
		
		JCheckBox chk1 = new JCheckBox("New check box");
		chk1.setBackground(Color.PINK);
		chk1.setBounds(296, 411, 120, 23);
		frame.getContentPane().add(chk1);
		
		JCheckBox chk2 = new JCheckBox("New check box");
		chk2.setBackground(Color.PINK);
		chk2.setBounds(495, 411, 114, 23);
		frame.getContentPane().add(chk2);
		
		JCheckBox chk3 = new JCheckBox("New check box");
		chk3.setBackground(Color.PINK);
		chk3.setBounds(296, 458, 120, 23);
		frame.getContentPane().add(chk3);
		
		JCheckBox chk4 = new JCheckBox("New check box");
		chk4.setBackground(Color.PINK);
		chk4.setBounds(495, 458, 114, 23);
		frame.getContentPane().add(chk4);
		
		JButton addrec = new JButton("ADD Record");
		addrec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)c1.getSelectedItem();
				String setAge = age.getText();
				String setDate = date.getText();
				String doctorName = (String)c2.getSelectedItem();
				String disease = (String)c3.getSelectedItem();
				String bloodGroup = (String)c4.getSelectedItem();
				
			}
		});
		addrec.setFont(new Font("Tahoma", Font.BOLD, 14));
		addrec.setBackground(Color.PINK);
		addrec.setBounds(197, 653, 500, 36);
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
		c1.setBounds(419, 146, 212, 27);
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
		c2.setBounds(419, 262, 212, 27);
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
		c3.setBounds(419, 300, 212, 27);
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
		c4.setBounds(419, 338, 212, 27);
		frame.getContentPane().add(c4);
		
		JLabel lblNewLabel_7 = new JLabel("Age");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(240, 182, 114, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		age = new JTextField();
		age.setBounds(419, 184, 212, 29);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel_6.setBounds(0, 0, 860, 722);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
