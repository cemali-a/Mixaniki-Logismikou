
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminGui extends JFrame {
    private JButton btnNewButton;
	private JPanel contentPane;
	ResultSet result = null;
	int id,aithousa;
	String name;
	String plirofories;
	String image;

	/**
	 * Create the frame.
	 */
	public AdminGui() {
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//########################### eisagwgh ek8ematos ####################################		
		JButton btnNewButton = new JButton("Εισαγωγή Εκθέματος");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame insertFrame = new JFrame("Πληροφορίες Εκθέματος");
				
				insertFrame.setVisible(true);
				insertFrame.setSize(450,550);
				insertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				insertFrame.getContentPane().setLayout(null);
				JLabel label = new JLabel("id:");
				label.setBounds(56, 46, 88, 22);
				final JTextField jt = new JTextField(5);
				jt.setBounds(165, 46, 135, 22);
				
				JLabel label2 = new JLabel("Όνομα:");
				label2.setBounds(56, 107, 88, 21);
				final JTextField jt2 = new JTextField(15);
				jt2.setBounds(165, 107, 135, 22);
				
				JLabel label3 = new JLabel("Αίθουσα:");
				label3.setBounds(56, 148, 88, 22);
				final JTextField jt3 = new JTextField();
				jt3.setBounds(165, 152, 135, 22);
				
				JLabel label4 = new JLabel("Εικόνα:");
				label4.setBounds(56, 199, 88, 22);
				final JTextField jt4 = new JTextField(10);
				jt4.setBounds(165, 199, 135, 22);
				
				JLabel label5 = new JLabel("Πληροφορίες:");
				label5.setBounds(56, 266, 88, 22);
				final JTextField jt5 = new JTextField(35);
				jt5.setBounds(145, 252, 230, 87);
				
				JButton button1 = new JButton("Αποθήκευση");
				button1.setBounds(133, 377, 117, 36);
				
				insertFrame.getContentPane().add(label);
				insertFrame.getContentPane().add(jt);
				insertFrame.getContentPane().add(label2);
				insertFrame.getContentPane().add(jt2);
				insertFrame.getContentPane().add(label3);
				insertFrame.getContentPane().add(jt3);
				insertFrame.getContentPane().add(label4);
				insertFrame.getContentPane().add(jt4);
				insertFrame.getContentPane().add(label5);
				insertFrame.getContentPane().add(jt5);
				insertFrame.getContentPane().add(button1);
				
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {  //patima koumpiou gia apo8hkeysh
						insertFrame.dispose();
						
						id =Integer.parseInt(jt.getText());
						name = jt2.getText();
						aithousa =Integer.parseInt(jt3.getText());
						plirofories = jt5.getText();
						image = jt4.getText();
						
						Administrator admin = new Administrator();
						try {
							admin.adminInsert(id,name,aithousa,plirofories,image);    //apo8hkeysh mesw ths adminInsert
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				
			}
		});

//#####################################################################################
		
		btnNewButton.setBounds(129, 56, 189, 52);
		contentPane.add(btnNewButton);
//######################### Epe3ergasia###############################################		
		JButton btnNewButton1 = new JButton("Επεξεργασία Εκθέματος");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = JOptionPane.showInputDialog(null,
						  "Εισάγετε το id του εκθέματος",
						  "",
						  JOptionPane.QUESTION_MESSAGE);
				int id1= Integer.parseInt(temp);
				temp = JOptionPane.showInputDialog(null,
						  "Εισάγετε την αίθουσα του εκθέματος",
						  "",
						  JOptionPane.QUESTION_MESSAGE);
				int aithousa1 = Integer.parseInt(temp);
				
				Administrator admin = new Administrator();
				
				try {
					result = admin.adminBrowse(id1, aithousa1); //pairnei to apotelesma tou query mesw ths adminBrowse
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				};
				
				
				
				final JFrame editFrame = new JFrame("Πληροφορίες Εκθέματος");
				editFrame.setVisible(true);
				editFrame.setSize(450,550);
				editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				editFrame.getContentPane().setLayout(null);
				
				try {
					while(result.next()) {
						
						JLabel label = new JLabel("id:");
						label.setBounds(56, 46, 88, 22);
						final JTextField jt = new JTextField(result.getString(1),20);     //topo8etei sto ka8e txtfiled ta stixia pou prepei
						jt.setBounds(165, 46, 135, 22);
					
						JLabel label2 = new JLabel("Όνομα:");
						label2.setBounds(56, 107, 88, 21);
						final JTextField jt2 = new JTextField(result.getString(2),20);
						jt2.setBounds(165, 107, 135, 22);
					
						JLabel label3 = new JLabel("Αίθουσα:");
						label3.setBounds(56, 148, 88, 22);
						final JTextField jt3 = new JTextField(result.getString(3),20);
						jt3.setBounds(165, 152, 135, 22);
					
						JLabel label4 = new JLabel("Εικόνα:");
						label4.setBounds(56, 199, 88, 22);
						final JTextField jt4 = new JTextField(result.getString(5),20);
						jt4.setBounds(165, 199, 135, 22);
					
						JLabel label5 = new JLabel("Πληροφορίες:");
						label5.setBounds(56, 266, 88, 22);
						final JTextField jt5 = new JTextField(result.getString(4),200);
						jt5.setBounds(145, 252, 230, 87);
					
					
						JButton button1 = new JButton("Αποθήκευση");
						button1.setBounds(133, 377, 117, 36);
						
						editFrame.getContentPane().add(label);
						editFrame.getContentPane().add(jt);
						editFrame.getContentPane().add(label2);
						editFrame.getContentPane().add(jt2);
						editFrame.getContentPane().add(label3);
						editFrame.getContentPane().add(jt3);
						editFrame.getContentPane().add(label4);
						editFrame.getContentPane().add(jt4);
						editFrame.getContentPane().add(label5);
						editFrame.getContentPane().add(jt5);
						editFrame.getContentPane().add(button1);
					
					
					
						button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {   //patima koumpiou apo8hkeyshs afou exoun ginei oi alages
								editFrame.dispose();
								id =Integer.parseInt(jt.getText());
								name = jt2.getText();
								aithousa =Integer.parseInt(jt3.getText());
								plirofories = jt5.getText();
								image = jt4.getText();
								Administrator admin = new Administrator();
								try {
									admin.adminDelete(id);                //diagrafh ths palias eggrafhs apo thn database mesw ths adminDelete
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									admin.adminInsert(id,name,aithousa,plirofories,image);  //apouhkeysh twn kainouriwn stoixiwn mesw ths adminInsert
								} catch (Exception e1) {
								// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
//########################################################################################	
		btnNewButton1.setBounds(129, 135, 189, 52);
		contentPane.add(btnNewButton1);

//############################## diagrafh ################################################			
		JButton btnNewButton2 = new JButton("Διαγραφή Εκθέματος");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {          //patima koumpiou diagrafhs
				String temp = JOptionPane.showInputDialog(null,
						  "Εισάγετε το id του εκθέματος",
						  "",
						  JOptionPane.QUESTION_MESSAGE);
				int id1= Integer.parseInt(temp);
				Administrator admin = new Administrator();
				try {
					admin.adminDelete(id1);                       //diagrafh stoixiwn mesw ths adminDelete
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
//##########################################################################################		
		btnNewButton2.setBounds(129, 211, 189, 52);
		contentPane.add(btnNewButton2);
//################################ termatismos ##############################################		
		JButton btnNewButton3 = new JButton("Τερματισμός Συστήματος");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrator admin =  new Administrator();
				admin.adminTurnOff();
			}
		});
		btnNewButton3.setBounds(129, 293, 189, 52);
		contentPane.add(btnNewButton3);
//############################################################################################		
	
	}
	
}
