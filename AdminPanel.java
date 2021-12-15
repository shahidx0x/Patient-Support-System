package uio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class adminPanel {

	private JFrame frame;
	private JTextField doc_user;
	private JPasswordField doc_pass;
	private JTextField ad_user;
	private JTextField ad_pass;
	@SuppressWarnings("rawtypes")
	private JComboBox cb;
	private JComboBox<String> cb1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPanel window = new adminPanel();
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
	public adminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 100, 449, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\resizedImage__2_-removebg-preview.png"));
		lblNewLabel.setBounds(148, 11, 136, 103);
		frame.getContentPane().add(lblNewLabel);
		
		doc_user = new JTextField();
		doc_user.setBounds(24, 205, 136, 31);
		frame.getContentPane().add(doc_user);
		doc_user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(24, 180, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		doc_pass = new JPasswordField();
		doc_pass.setBounds(180, 205, 136, 31);
		frame.getContentPane().add(doc_pass);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(180, 180, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton doc_btn = new JButton("ADD");
		doc_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String username = doc_user.getText();
				String password = doc_pass.getText();
				System.out.println("+username+,+password+");
				try {
					DbConnection con = new DbConnection();
					String sql = "INSERT INTO `doctor`(`username`, `password`) VALUES ('"+username+"','"+password+"')";
						con.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "'"+ username +"'Added Successfully");
						  new adminPanel();
						  adminPanel.main(null);
						  frame.dispose();
				}catch(Exception error) {
					
				}
			}
		});
		doc_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		doc_btn.setBounds(326, 205, 89, 31);
		frame.getContentPane().add(doc_btn);
		
		JLabel lblNewLabel_3 = new JLabel("Add Doctor");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(24, 141, 117, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add Admin");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(24, 272, 143, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		ad_user = new JTextField();
		ad_user.setBounds(24, 327, 136, 31);
		frame.getContentPane().add(ad_user);
		ad_user.setColumns(10);
		
		ad_pass = new JTextField();
		ad_pass.setBounds(180, 327, 136, 31);
		frame.getContentPane().add(ad_pass);
		ad_pass.setColumns(10);
		
		JButton ad_btn = new JButton("ADD");
		ad_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = ad_user.getText();
				String password = ad_pass.getText();
				System.out.println("+username+,+password+");
				try {
					DbConnection con = new DbConnection();
					String sql = "INSERT INTO `admin`(`username`, `password`) VALUES ('"+username+"','"+password+"')";
						con.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "'"+ username +"'Added Successfully");
						  new adminPanel();
						  adminPanel.main(null);
						  frame.dispose();
				}catch(Exception error) {
					
				}
			}
		});
		ad_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		ad_btn.setBounds(326, 327, 89, 31);
		frame.getContentPane().add(ad_btn);
		
		JLabel lblNewLabel_5 = new JLabel("UserName");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(24, 312, 75, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(180, 312, 69, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("-----------------------------------------------------------------------------------------------------");
		lblNewLabel_7.setBounds(21, 247, 419, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("-----------------------------------------------------------------------------------------------------");
		lblNewLabel_8.setBounds(24, 377, 416, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Delete Patient");
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(24, 402, 148, 44);
		frame.getContentPane().add(lblNewLabel_9);
		
		cb = new JComboBox();
		cb.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `username` FROM `patient` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						cb.addItem(rs.getString("username"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		cb.setBounds(23, 457, 226, 31);
		frame.getContentPane().add(cb);
		
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete = (String)cb.getSelectedItem();
					DbConnection con = new DbConnection();
					String sql = "DELETE FROM patient WHERE username='"+delete+"'";
					try {
						con.s.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Delete Success");
						  new adminPanel();
						  adminPanel.main(null);
						  frame.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(289, 457, 110, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_10 = new JLabel("Delete Doctor");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(24, 513, 153, 31);
		frame.getContentPane().add(lblNewLabel_10);
		
		cb1 = new JComboBox<String>();
		cb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbConnection con = new DbConnection();
				String sql = "SELECT `username` FROM `doctor` WHERE 1";
				try {
					ResultSet rs = con.s.executeQuery(sql);
					while(rs.next()) {
						cb1.addItem(rs.getString("username"));
					}
				}catch(Exception error) {
					
				}
			}
		});
		cb1.setBounds(24, 555, 225, 31);
		frame.getContentPane().add(cb1);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete = (String)cb1.getSelectedItem();
				DbConnection con = new DbConnection();
				String sql = "DELETE FROM doctor WHERE username='"+delete+"'";
				try {
					con.s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Delete Success");
					 new adminPanel();
					 adminPanel.main(null);
					 frame.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(289, 555, 110, 31);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_11 = new JLabel("-----------------------------------------------------------------------------------------------------");
		lblNewLabel_11.setBounds(24, 608, 416, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("-----------------------------------------------------------------------------------------------------");
		lblNewLabel_12.setBounds(24, 127, 416, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Gradient_builder_2.jpg"));
		lblNewLabel_13.setBounds(0, 0, 440, 729);
		frame.getContentPane().add(lblNewLabel_13);
	
	}
}
