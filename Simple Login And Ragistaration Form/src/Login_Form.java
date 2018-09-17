import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Login_Form {

	private JFrame frame;
	private JTextField usertext;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form window = new Login_Form();
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
	public Login_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String JDBC_DRIVER="com.mysql.jdbc.Driver";
		String DB_URL="jdbc:mysql://localhost/java_database";
		String DB_USER="root";
		String DB_Pass="";
		Connection conn=null;
		
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_Pass);
			
			System.out.print("Database connection is Successfull.....!");
			conn.close();
			
		}
		catch(Exception e) 
		{
			System.out.println("Error...Connection is faild:"+e);
		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 608, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(258, 79, 118, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel passtext = new JLabel("Password :");
		passtext.setFont(new Font("Tahoma", Font.BOLD, 18));
		passtext.setBounds(258, 150, 118, 31);
		frame.getContentPane().add(passtext);
		
		usertext = new JTextField();
		usertext.setBounds(371, 82, 199, 31);
		frame.getContentPane().add(usertext);
		usertext.setColumns(10);
		
		passwordtext = new JPasswordField();
		passwordtext.setBounds(371, 150, 199, 31);
		frame.getContentPane().add(passwordtext);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String JDBC_DRIVER="com.mysql.jdbc.Driver";
				String DB_URL="jdbc:mysql://localhost/java_database";
				String DB_USER="root";
				String DB_Pass="";
				Connection conn=null;
				
				try
				{
					Class.forName(JDBC_DRIVER);
					conn = DriverManager.getConnection(DB_URL,DB_USER,DB_Pass);
					
					String query="select * from student where Username=? and Password=? ";
					PreparedStatement stm=conn.prepareStatement(query);
					stm.setString(1,usertext.getText());
					stm.setString(2,passwordtext.getText());
					ResultSet rs=stm.executeQuery();
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
						if(count==1)
						{
							JOptionPane.showMessageDialog(null,"Login is Successfully");
						}
						else if(count>1)
						{
							JOptionPane.showMessageDialog(null,"Duplicate UsreName and Password");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"UserName And Password is Incorrect....Register First..And Try again");
						}
						
				rs.close();
				stm.close();
				}
				catch(Exception e1) 
				{
					System.out.println("Error...Connection is faild:"+e1);
				}
			}
		});
		Image img1=new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		loginbutton.setIcon(new ImageIcon(img1));
		loginbutton.setBackground(Color.LIGHT_GRAY);
		loginbutton.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginbutton.setBounds(286, 234, 103, 31);
		frame.getContentPane().add(loginbutton);
		
		JButton cancelbutton = new JButton("Cancel");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usertext.setText("");
				passwordtext.setText("");
			}
		});
		cancelbutton.setBackground(Color.LIGHT_GRAY);
		cancelbutton.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelbutton.setBounds(449, 234, 103, 31);
		frame.getContentPane().add(cancelbutton);
		
		JLabel lblNewLabel_1 = new JLabel("Login Form");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(255, 175, 175));
		lblNewLabel_1.setFont(new Font("Andalus", Font.BOLD, 28));
		lblNewLabel_1.setBounds(176, 23, 213, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(10, 68, 238, 227);
		frame.getContentPane().add(label);
		
		JLabel label1 = new JLabel("Please Register here..");
		label1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				Register_Form register=new Register_Form();				
				register.setVisible(true);
			}
		});
		label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label1.setBounds(273, 302, 172, 25);
		frame.getContentPane().add(label1);
	}
}
