import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPass = new JLabel("PASSWORD :");
		lblPass.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		lblPass.setBounds(66, 134, 121, 18);
		contentPane.add(lblPass);
		
		JLabel lblAdmin = new JLabel("ADMIN :");
		lblAdmin.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		lblAdmin.setBounds(102, 89, 68, 18);
		contentPane.add(lblAdmin);
		
		user = new JTextField();
		user.setBounds(178, 78, 184, 29);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(178, 123, 184, 29);
		contentPane.add(pass);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = user.getText(); 
				String passw = pass.getText();
				
				if (uname.equals("group4")& passw.equals("project")) {
						Payrolls window = new Payrolls();
						window.getFrame().setVisible(true);
					
				}else {
					Login lframe =  new Login();
					JOptionPane.showMessageDialog(lframe,"INVALID ACCOUNT");
				}
			}
		});
		btnLogin.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		btnLogin.setBounds(199, 173, 127, 29);
		contentPane.add(btnLogin);
		
	
	}
}
