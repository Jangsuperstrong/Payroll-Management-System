import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSlider;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JPanel label;
	

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
		setBounds(100, 100, 1009, 576);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPass = new JLabel("PASSWORD :");
		lblPass.setForeground(new Color(255, 255, 255));
		lblPass.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblPass.setBounds(370, 333, 121, 18);
		contentPane.add(lblPass);
		
		JLabel lblAdmin = new JLabel("ADMIN :");
		lblAdmin.setForeground(new Color(255, 255, 255));
		lblAdmin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblAdmin.setBounds(401, 288, 68, 18);
		contentPane.add(lblAdmin);
		
		user = new JTextField();
		user.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		user.setBounds(483, 283, 184, 29);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		pass.setBounds(483, 328, 184, 29);
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
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnLogin.setBounds(449, 380, 151, 29);
		contentPane.add(btnLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(102, 153, 204));
		lblLogo.setIcon(new ImageIcon("C:\\Users\\CLIENT\\git\\payroll\\src\\Pms\\img\\g4LogoS.png"));
		lblLogo.setBounds(421, 59, 219, 237);
		contentPane.add(lblLogo);
		
		
		
		JLabel lblBorder = new JLabel("");
		Border border = new LineBorder(Color.ORANGE, 4, true);
		lblBorder.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblBorder.setBounds(329, 59, 395, 404);
		contentPane.add(lblBorder);	    
		
		
		JLabel lblBackImg = new JLabel("");
		lblBackImg.setIcon(new ImageIcon("C:\\Users\\CLIENT\\git\\payroll\\src\\Pms\\img\\back.png"));
		lblBackImg.setBounds(0, 0, 1000, 552);
		contentPane.add(lblBackImg);
			
	
	}
}
