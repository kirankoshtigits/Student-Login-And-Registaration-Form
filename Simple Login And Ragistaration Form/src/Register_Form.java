
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;


import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;


public class Register_Form extends JFrame {

	private JPanel contentPane;
	private JTextField fnamtext;
	private JTextField lnametext;
	private JTextField addtext;
	private JTextField mobiletext;
	private JTextField usertext;
	private JPasswordField passwordtext;
	private JTextField edutext;
	
	private JLabel v1;
	private JLabel v2;
	private JLabel v3;
	private JLabel v4;
	private JLabel v5;
	private JLabel v6;
	private JLabel v7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Form frame = new Register_Form();
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
	public Register_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registaration Form");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(190, 22, 262, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(135, 73, 87, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(135, 111, 87, 20);
		contentPane.add(lblLastName);
		
		JLabel lblAddess = new JLabel("Addess");
		lblAddess.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddess.setBounds(135, 149, 87, 20);
		contentPane.add(lblAddess);
		
		JLabel lblMobileno = new JLabel("Mobile-No");
		lblMobileno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMobileno.setBounds(135, 190, 87, 20);
		contentPane.add(lblMobileno);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(135, 270, 87, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(135, 317, 87, 20);
		contentPane.add(lblPassword);
		
		fnamtext = new JTextField();
		fnamtext.setBounds(258, 74, 211, 27);
		contentPane.add(fnamtext);
		fnamtext.setColumns(10);
		
		lnametext = new JTextField();
		lnametext.setBounds(258, 112, 211, 27);
		contentPane.add(lnametext);
		lnametext.setColumns(10);
		
		addtext = new JTextField();
		addtext.setBounds(258, 150, 211, 27);
		contentPane.add(addtext);
		addtext.setColumns(10);
		
		mobiletext = new JTextField();
		mobiletext.setBounds(258, 191, 211, 27);
		contentPane.add(mobiletext);
		mobiletext.setColumns(10);
		
		usertext = new JTextField();
		usertext.setBounds(258, 271, 211, 25);
		contentPane.add(usertext);
		usertext.setColumns(10);
		
		passwordtext = new JPasswordField();
		passwordtext.setBounds(258, 315, 211, 27);
		contentPane.add(passwordtext);
		
		JButton submitbutton = new JButton("Submit");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String JDBC_DRIVER="com.mysql.jdbc.Driver";
				String DB_URL="jdbc:mysql://localhost/java_database";
				String DB_USER="root";
				String DB_Pass="";
								
					try
					{
						Class.forName(JDBC_DRIVER);
						Connection conn =DriverManager.getConnection(DB_URL,DB_USER,DB_Pass);
						String sql="INSERT INTO student values(?,?,?,?,?,?,?)";
						PreparedStatement statament1= conn.prepareStatement(sql);
							
						statament1.setString(1,fnamtext.getText());
						statament1.setString(2,lnametext.getText());
						statament1.setString(3,addtext.getText());
						statament1.setString(4,mobiletext.getText());
						statament1.setString(5,edutext.getText());
						statament1.setString(6,usertext.getText());
						statament1.setString(7,passwordtext.getText());
						
						
						int inserted =statament1.executeUpdate();	
						if(inserted>0)
						{
							JOptionPane.showMessageDialog(null,"Data Inserted Sucessfully");
						}
						statament1.close();
						conn.close();
					}
					catch(Exception e1) 
					{
						System.out.println("Error...Connection is faild:"+e1);
					}
			}
		});
		submitbutton.setFont(new Font("Batang", Font.BOLD, 18));
		submitbutton.setBounds(141, 389, 132, 38);
		contentPane.add(submitbutton);
		
		JButton buttoncancel = new JButton("Cancel");
		buttoncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fnamtext.setText("");
				lnametext.setText("");
				addtext.setText("");
				mobiletext.setText("");
				edutext.setText("");
				usertext.setText("");
				passwordtext.setText("");
			}
		});
     
		buttoncancel.setFont(new Font("Batang", Font.BOLD, 18));
		buttoncancel.setBounds(372, 389, 132, 38);
		contentPane.add(buttoncancel);
		
		JLabel lblNewLabel_2 = new JLabel("Education");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(135, 237, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		edutext = new JTextField();
		edutext.setColumns(10);
		edutext.setBounds(258, 233, 211, 27);
		contentPane.add(edutext);
		
		v1 = new JLabel("");
		v1.setForeground(Color.RED);
		v1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		v1.setBounds(479, 73, 154, 20);
		contentPane.add(v1);
		
		v2 = new JLabel("");
		v2.setForeground(Color.RED);
		v2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		v2.setBounds(479, 115, 154, 20);
		contentPane.add(v2);
		
		 v3 = new JLabel("");
		 v3.setForeground(Color.RED);
		v3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		v3.setBounds(479, 153, 154, 20);
		contentPane.add(v3);
		
		 v4 = new JLabel("");
		 v4.setForeground(Color.RED);
		v4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		v4.setBounds(479, 194, 154, 20);
		contentPane.add(v4);
		
		v5 = new JLabel("");
		v5.setForeground(Color.RED);
		v5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		v5.setBounds(479, 238, 154, 20);
		contentPane.add(v5);
		
		v6 = new JLabel("");
		v6.setForeground(Color.RED);
		v6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		v6.setBounds(479, 274, 154, 20);
		contentPane.add(v6);
		
		v7 = new JLabel("");
		v7.setForeground(Color.RED);
		v7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		v7.setBounds(479, 317, 154, 20);
		contentPane.add(v7);
		
	}
}
