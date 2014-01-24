import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;




public class AppGui {
	ResultSet result = null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGui window = new AppGui();
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
	public AppGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();                // kentriko gui
		frame.setBounds(200, 200, 580, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon museumImage = new ImageIcon("museum.jpg");
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(34, 28, 529, 430);
		lblNewLabel.setIcon(museumImage);
		frame.getContentPane().add(lblNewLabel);
		
				
		JButton ekthemaButton = new JButton("Επιλογή Εκθέματος");
		ekthemaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = JOptionPane.showInputDialog(null,
						  "Εισάγετε αριθμό Αίθουσας",
						  "",
						  JOptionPane.QUESTION_MESSAGE);
				int aithousa = Integer.parseInt(s1);
				String s2 = JOptionPane.showInputDialog(null,
						  "Εισάγετε αριθμό Εκθέματος",
						  "",
						  JOptionPane.QUESTION_MESSAGE);
				int id = Integer.parseInt(s2);
				User user = new User();
				try {
					result=user.userBrowse(id, aithousa);        //pairnei to apotelesma tou query mesw ths userBrowse
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFrame imfoFrame = new JFrame("Πληροφορίες Εκθέματος");
				imfoFrame.setLayout(null);
				imfoFrame.setVisible(true);
				imfoFrame.setSize(720,750);
				imfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				try {
					while(result.next()) {  
						JPanel panel = new JPanel();
						panel.setBounds(40, 22, 633, 444);
						imfoFrame.add(panel);
						
						JLabel label = new JLabel();
						ImageIcon image = new ImageIcon(result.getString(5));
						label.setIcon(image);
						panel.add(label);
						
						JLabel label2 = new JLabel(result.getString(2));
						label2.setFont(new Font("Tahoma", Font.BOLD, 14));
						label2.setBounds(100, 487, 254, 22);
						imfoFrame.add(label2); 
						
						JLabel label3 = new JLabel("<html>"+result.getString(4)+"</html>"); //html gia na mporei na allazei grammh me <br> to text
						label3.setBounds(100, 540, 447, 134);
						label3.setOpaque(true);
						label3.setBackground(Color.LIGHT_GRAY);
						label3.setVerticalAlignment(SwingConstants.TOP);
						imfoFrame.add(label3);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		ekthemaButton.setBounds(190, 479, 214, 58);
		frame.getContentPane().add(ekthemaButton);
		
	
		JButton adminButton = new JButton("Είσοδος Διαχειριστή");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame frame1 = new LoginFrame();                //anoigma tou frame gia to log in
				frame1.setVisible(true);
				
			}
		});
		adminButton.setIcon(new ImageIcon("icon_admin.png"));
		adminButton.setBounds(341, 587, 205, 58);
		frame.getContentPane().add(adminButton);
	

	}
	
}
