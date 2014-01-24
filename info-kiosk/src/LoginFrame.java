import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class LoginFrame extends JFrame {
	static boolean result;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 231, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("User Name:");
		userLabel.setBounds(10, 24, 91, 14);
		contentPane.add(userLabel);
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setBounds(10, 49, 91, 14);
		contentPane.add(passLabel);
		
		textField = new JTextField();
		textField.setBounds(81, 20, 115, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		

		passwordField = new JPasswordField();
		passwordField.setBounds(81, 49, 115, 22);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String user = textField.getText();
				String pass = passwordField.getText();
				MySystem sys = new MySystem();
				try {
					result=sys.systemAdminPassword(user,pass);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(result);
				//Throwable t = new Throwable();
				System.out.println(result);
				//trace(result);
				if(result==true)
				{
				AdminGui frame2 = new AdminGui();
				frame2.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Λάθος κωδικός πρόσβασης ή username");
				}	
			
	
			}
		});
		loginButton.setBounds(70, 82, 89, 23);
		contentPane.add(loginButton);
		
		
		
		
	}
}
