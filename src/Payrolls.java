
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Payrolls {

	private JFrame frame;
	private JTextField txtEmployeeNo;
	private JTextField txtEmployeeName;
	private JTextField txtPostCode;
	private JTextField txtEmployeeAddress;
	private JTextField txtBasicSalary;
	private JTextField txtMealAllowance;
	private JTextField txtOT;
	private JTextField txtGrossPay;
	private JTextField txtNetPay;
	private JTextField txtSSSNumber;
	private JTextField txtTax;
	private JTextField txtSSSContri;
	private JTextField txtLoan;
	private JTextField txtDeductions;
	private JTextField txtEmployerName;
	private JTextField txtPayDate;
	
	double BasicSalary;
	double MealAllowance;
	double OT;
	double Gross;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payrolls window = new Payrolls();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payrolls() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		
		getFrame().addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				//========================================================================
				int refs= 1325 + (int) (Math.random()*4238);
				//========================================================================
					Calendar timer = Calendar.getInstance();
					timer.getTime();
					SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
					tTime.format(timer.getTime());
					SimpleDateFormat Tdate = new SimpleDateFormat("dd-MMM-yyyy");
					Tdate.format(timer.getTime());
					txtPayDate.setText(Tdate.format(timer.getTime()));
					
					String sRef = String.format("EmpNo" +  refs);
					txtEmployeeNo.setText(sRef);
			}
		});
		getFrame().setBounds(0, 0, 1288, 750);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Ref No.:");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 210, 179, 33);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEmployeeName.setBounds(28, 254, 179, 33);
		getFrame().getContentPane().add(lblEmployeeName);
		
		JLabel lblPostCode = new JLabel("Post Code:");
		lblPostCode.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblPostCode.setBounds(28, 331, 179, 33);
		getFrame().getContentPane().add(lblPostCode);
		
		JLabel lblEmployeeAddress = new JLabel("Employee Add:");
		lblEmployeeAddress.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEmployeeAddress.setBounds(28, 296, 179, 33);
		getFrame().getContentPane().add(lblEmployeeAddress);
		
		txtEmployeeNo = new JTextField();
		txtEmployeeNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEmployeeNo.setBounds(217, 220, 222, 28);
		getFrame().getContentPane().add(txtEmployeeNo);
		txtEmployeeNo.setColumns(10);
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEmployeeName.setColumns(10);
		txtEmployeeName.setBounds(217, 257, 222, 28);
		getFrame().getContentPane().add(txtEmployeeName);
		
		txtPostCode = new JTextField();
		txtPostCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPostCode.setColumns(10);
		txtPostCode.setBounds(217, 333, 222, 28);
		getFrame().getContentPane().add(txtPostCode);
		
		txtEmployeeAddress = new JTextField();
		txtEmployeeAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEmployeeAddress.setColumns(10);
		txtEmployeeAddress.setBounds(217, 296, 222, 28);
		getFrame().getContentPane().add(txtEmployeeAddress);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary:");
		lblBasicSalary.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblBasicSalary.setBounds(28, 402, 179, 33);
		getFrame().getContentPane().add(lblBasicSalary);
		
		JLabel lblMealAllowance = new JLabel("Meal Allowance:");
		lblMealAllowance.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblMealAllowance.setBounds(28, 440, 179, 33);
		getFrame().getContentPane().add(lblMealAllowance);
		
		JLabel lblNewLabel_1_2 = new JLabel("Over Time:");
		lblNewLabel_1_2.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(28, 481, 179, 33);
		getFrame().getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gross Pay:");
		lblNewLabel_1_3.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(28, 550, 179, 33);
		getFrame().getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Net Pay:");
		lblNewLabel_1_2_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(28, 629, 179, 33);
		getFrame().getContentPane().add(lblNewLabel_1_2_1);
		
		txtBasicSalary = new JTextField();
		txtBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtBasicSalary.setColumns(10);
		txtBasicSalary.setBounds(217, 410, 222, 28);
		getFrame().getContentPane().add(txtBasicSalary);
		
		txtMealAllowance = new JTextField();
		txtMealAllowance.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMealAllowance.setColumns(10);
		txtMealAllowance.setBounds(217, 449, 222, 28);
		getFrame().getContentPane().add(txtMealAllowance);
		
		txtOT = new JTextField();
		txtOT.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtOT.setColumns(10);
		txtOT.setBounds(217, 488, 222, 28);
		getFrame().getContentPane().add(txtOT);
		
		txtGrossPay = new JTextField();
		txtGrossPay.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtGrossPay.setColumns(10);
		txtGrossPay.setBounds(217, 550, 222, 28);
		getFrame().getContentPane().add(txtGrossPay);
		
		txtNetPay = new JTextField();
		txtNetPay.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNetPay.setColumns(10);
		txtNetPay.setBounds(217, 626, 222, 28);
		getFrame().getContentPane().add(txtNetPay);
		
		JLabel lblNewLabel_1 = new JLabel("Pay Date:");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(474, 181, 140, 33);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tax Period:");
		lblNewLabel_1_4.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(474, 257, 140, 33);
		getFrame().getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tax Code:");
		lblNewLabel_1_5.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(474, 292, 140, 33);
		getFrame().getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("SSS Code:");
		lblNewLabel_1_4_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_4_1.setBounds(474, 331, 140, 33);
		getFrame().getContentPane().add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("SSS Number:");
		lblNewLabel_1_5_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_5_1.setBounds(474, 380, 140, 33);
		getFrame().getContentPane().add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Tax:");
		lblNewLabel_1_4_2.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_4_2.setBounds(474, 434, 92, 33);
		getFrame().getContentPane().add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Loan:");
		lblNewLabel_1_4_1_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_4_1_1.setBounds(474, 514, 118, 33);
		getFrame().getContentPane().add(lblNewLabel_1_4_1_1);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("SSS Contribution:");
		lblNewLabel_1_5_1_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_5_1_1.setBounds(445, 567, 179, 33);
		getFrame().getContentPane().add(lblNewLabel_1_5_1_1);
		
		JLabel lblNewLabel_1_5_1_1_1 = new JLabel("Deductions:");
		lblNewLabel_1_5_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_1_5_1_1_1.setBounds(474, 629, 129, 33);
		getFrame().getContentPane().add(lblNewLabel_1_5_1_1_1);
		
		JComboBox<?> cmbTaxPeriod = new JComboBox();
		cmbTaxPeriod.setFont(new Font("Tahoma", Font.BOLD, 18));
		cmbTaxPeriod.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbTaxPeriod.setBounds(615, 257, 148, 31);
		getFrame().getContentPane().add(cmbTaxPeriod);
		
		JComboBox cmbTaxCode = new JComboBox();
		cmbTaxCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		cmbTaxCode.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G"}));
		cmbTaxCode.setBounds(615, 296, 148, 31);
		getFrame().getContentPane().add(cmbTaxCode);
		
		JComboBox cmbNICode = new JComboBox();
		cmbNICode.setFont(new Font("Tahoma", Font.BOLD, 18));
		cmbNICode.setModel(new DefaultComboBoxModel(new String[] {"A0000", "A3000", "B4000", "C5000", "D6000", "E7000", "F8000", "G9000"}));
		cmbNICode.setBounds(615, 333, 148, 31);
		getFrame().getContentPane().add(cmbNICode);
		
		txtSSSNumber = new JTextField();
		txtSSSNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtSSSNumber.setBounds(615, 382, 148, 28);
		getFrame().getContentPane().add(txtSSSNumber);
		txtSSSNumber.setColumns(10);
		
		txtTax = new JTextField();
		txtTax.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTax.setColumns(10);
		txtTax.setBounds(615, 439, 148, 28);
		getFrame().getContentPane().add(txtTax);
		
		txtSSSContri = new JTextField();
		txtSSSContri.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtSSSContri.setColumns(10);
		txtSSSContri.setBounds(615, 567, 148, 28);
		getFrame().getContentPane().add(txtSSSContri);
		
		txtLoan = new JTextField();
		txtLoan.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtLoan.setColumns(10);
		txtLoan.setBounds(615, 516, 148, 28);
		getFrame().getContentPane().add(txtLoan);
		
		txtDeductions = new JTextField();
		txtDeductions.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtDeductions.setColumns(10);
		txtDeductions.setBounds(615, 634, 148, 28);
		getFrame().getContentPane().add(txtDeductions);
		
		JTextArea rtfPaySlip = new JTextArea();
		rtfPaySlip.setFont(new Font("Courier New", Font.PLAIN, 18));
		rtfPaySlip.setBounds(871, 237, 388, 296);
		getFrame().getContentPane().add(rtfPaySlip);
		
		JButton btnNewButton = new JButton("Net Wages");
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double A00, A30, B40, C50, D60, E70, F80, G90;
				double deduction, Loan1, Loan, SSSContri, TotalDeduction, NetPay;
				
				BasicSalary = Double.parseDouble(txtBasicSalary.getText());
				MealAllowance = Double.parseDouble(txtMealAllowance.getText());
				OT = Double.parseDouble(txtOT.getText());
				Gross = BasicSalary + MealAllowance + OT;
				String GrossPay = String.format("php%.2f", Gross);
				txtGrossPay.setText(GrossPay);
				
				//============================================================================================
				
				
				try {
					
					if (cmbNICode.getSelectedItem().equals("A0000")) {
						A00 = (Gross * 9)/100;
						deduction = Gross - A00;
						Loan1 =(deduction * 12)/100;
						
						Loan = Loan1 + A00;
						Loan = Gross - Loan;
						Loan = (Loan *5.9)/100;
						
						SSSContri = Loan + Loan1 + A00;
						SSSContri = Gross - SSSContri;
						SSSContri = (SSSContri *4.2)/100;
						
						String TaxPaid = String.format("%.2f", A00);
						txtTax.setText(TaxPaid);
						txtTax.setText("php" + TaxPaid);
						
						String LoanPaid = String.format("%.2f", A00);
						txtLoan.setText(LoanPaid);
						txtLoan.setText("php" + LoanPaid);
						
						String SSSContriPaid = String.format("%.2f", A00);
						txtSSSContri.setText(SSSContriPaid);
						txtSSSContri.setText("php" + SSSContriPaid);
						
						TotalDeduction = A00 + Loan1 + Loan + SSSContri;
						NetPay = Gross - TotalDeduction;
						
						String TDeduction = String.format("%.2f", TotalDeduction);
						txtDeductions.setText(TDeduction);
						txtDeductions.setText("php" + TDeduction);
						
						String TNetPay = String.format("%.2f", NetPay);
						txtNetPay.setText(TNetPay);
						txtNetPay.setText("php" + TNetPay);
						
	
						
					
					}
						
						else if (cmbNICode.getSelectedItem().equals("A3000")) {
							A30 = 3000/12;
							A00 = (Gross * 9)/100;
							deduction = Gross - A00;
							Loan1 =(deduction * 12)/100;
							
							Loan = Loan1 + A00;
							Loan = Gross - Loan;
							Loan = (Loan *5.9)/100;
							
							SSSContri = Loan + Loan1 + A00;
							SSSContri = Gross - SSSContri;
							SSSContri = (SSSContri *4.2)/100;
							
							String TaxPaid = String.format("%.2f", A00);
							txtTax.setText(TaxPaid);
							txtTax.setText("php" + TaxPaid);
							
							String LoanPaid = String.format("%.2f", A00);
							txtLoan.setText(LoanPaid);
							txtLoan.setText("php" + LoanPaid);
							
							String SSSContriPaid = String.format("%.2f", A00);
							txtSSSContri.setText(SSSContriPaid);
							txtSSSContri.setText("php" + SSSContriPaid);
							
							TotalDeduction = A00 + Loan1 + Loan + SSSContri;
							NetPay = Gross - TotalDeduction;
							
							String TDeduction = String.format("%.2f", TotalDeduction);
							txtDeductions.setText(TDeduction);
							txtDeductions.setText("php" + TDeduction);
							
							String TNetPay = String.format("%.2f", NetPay);
							txtNetPay.setText(TNetPay);
							txtNetPay.setText("php" + TNetPay);
					
							
						}
							
					else if (cmbNICode.getSelectedItem().equals("B4000")) {
								B40 = 4000/12;
								A00 = (Gross * 9)/100;
								deduction = Gross - A00;
								Loan1 =(deduction * 12)/100;
								
								Loan = Loan1 + A00;
								Loan = Gross - Loan;
								Loan = (Loan *5.9)/100;
								
								SSSContri = Loan + Loan1 + A00;
								SSSContri = Gross - SSSContri;
								SSSContri = (SSSContri *4.2)/100;
								
								String TaxPaid = String.format("%.2f", A00);
								txtTax.setText(TaxPaid);
								txtTax.setText("php" + TaxPaid);
								
								String LoanPaid = String.format("%.2f", A00);
								txtLoan.setText(LoanPaid);
								txtLoan.setText("php" + LoanPaid);
								
								String SSSContriPaid = String.format("%.2f", A00);
								txtSSSContri.setText(SSSContriPaid);
								txtSSSContri.setText("php" + SSSContriPaid);
								
								TotalDeduction = A00 + Loan1 + Loan + SSSContri;
								NetPay = Gross - TotalDeduction;
								
								String TDeduction = String.format("%.2f", TotalDeduction);
								txtDeductions.setText(TDeduction);
								txtDeductions.setText("php" + TDeduction);
								
								String TNetPay = String.format("%.2f", NetPay);
								txtNetPay.setText(TNetPay);
								txtNetPay.setText("php" + TNetPay);
								
							
								
								
					}
					
					else if (cmbNICode.getSelectedItem().equals("C5000")) {
								C50 = 5000/12;
								A00 = (Gross * 9)/100;
								deduction = Gross - A00;
								Loan1 =(deduction * 12)/100;
								
								Loan = Loan1 + A00;
								Loan = Gross - Loan;
								Loan = (Loan *5.9)/100;
								
								SSSContri = Loan + Loan1 + A00;
								SSSContri = Gross - SSSContri;
								SSSContri = (SSSContri *4.2)/100;
								
								String TaxPaid = String.format("%.2f", A00);
								txtTax.setText(TaxPaid);
								txtTax.setText("php" + TaxPaid);
								
								
								String LoanPaid = String.format("%.2f", A00);
								txtLoan.setText(LoanPaid);
								txtLoan.setText("php" + LoanPaid);
								
								String SSSContriPaid = String.format("%.2f", A00);
								txtSSSContri.setText(SSSContriPaid);
								txtSSSContri.setText("php" + SSSContriPaid);
								
								TotalDeduction = A00 + Loan1 + Loan + SSSContri;
								NetPay = Gross - TotalDeduction;
								
								String TDeduction = String.format("%.2f", TotalDeduction);
								txtDeductions.setText(TDeduction);
								txtDeductions.setText("php" + TDeduction);
								
								String TNetPay = String.format("%.2f", NetPay);
								txtNetPay.setText(TNetPay);
								txtNetPay.setText("php" + TNetPay);
								
								
					}
					
					else if (cmbNICode.getSelectedItem().equals("D6000")) {
								D60 = 6000/12;
								A00 = (Gross * 9)/100;
								deduction = Gross - A00;
								Loan1 =(deduction * 12)/100;
								
								Loan = Loan1 + A00;
								Loan = Gross - Loan;
								Loan = (Loan *5.9)/100;
								
								SSSContri = Loan + Loan1 + A00;
								SSSContri = Gross - SSSContri;
								SSSContri = (SSSContri *4.2)/100;
								
								String TaxPaid = String.format("%.2f", A00);
								txtTax.setText(TaxPaid);
								txtTax.setText("php" + TaxPaid);
								
								
								
								String LoanPaid = String.format("%.2f", A00);
								txtLoan.setText(LoanPaid);
								txtLoan.setText("php" + LoanPaid);
								
								String SSSContriPaid = String.format("%.2f", A00);
								txtSSSContri.setText(SSSContriPaid);
								txtSSSContri.setText("php" + SSSContriPaid);
								
								TotalDeduction = A00 + Loan1 + Loan + SSSContri;
								NetPay = Gross - TotalDeduction;
								
								String TDeduction = String.format("%.2f", TotalDeduction);
								txtDeductions.setText(TDeduction);
								txtDeductions.setText("php" + TDeduction);
								
								String TNetPay = String.format("%.2f", NetPay);
								txtNetPay.setText(TNetPay);
								txtNetPay.setText("php" + TNetPay);
								
								
								
								
								
						}
					
					else if (cmbNICode.getSelectedItem().equals("E7000")) {
								E70 = 7000/12;
								A00 = (Gross * 9)/100;
								deduction = Gross - A00;
								Loan1 =(deduction * 12)/100;
								
								Loan = Loan1 + A00;
								Loan = Gross - Loan;
								Loan = (Loan *5.9)/100;
								
								SSSContri = Loan + Loan1 + A00;
								SSSContri = Gross - SSSContri;
								SSSContri = (SSSContri *4.2)/100;
								
								String TaxPaid = String.format("%.2f", A00);
								txtTax.setText(TaxPaid);
								txtTax.setText("php" + TaxPaid);
								
								
								
								String LoanPaid = String.format("%.2f", A00);
								txtLoan.setText(LoanPaid);
								txtLoan.setText("php" + LoanPaid);
								
								String SSSContriPaid = String.format("%.2f", A00);
								txtSSSContri.setText(SSSContriPaid);
								txtSSSContri.setText("php" + SSSContriPaid);
								
								TotalDeduction = A00 + Loan1 + Loan + SSSContri;
								NetPay = Gross - TotalDeduction;
								
								String TDeduction = String.format("%.2f", TotalDeduction);
								txtDeductions.setText(TDeduction);
								txtDeductions.setText("php" + TDeduction);
								
								String TNetPay = String.format("%.2f", NetPay);
								txtNetPay.setText(TNetPay);
								txtNetPay.setText("php" + TNetPay);
								
								
								
								
								
						}
					
					else if (cmbNICode.getSelectedItem().equals("F8000")) {
								F80 = 8000/12;
								A00 = (Gross * 9)/100;
								deduction = Gross - A00;
								Loan1 =(deduction * 12)/100;
								
								Loan = Loan1 + A00;
								Loan = Gross - Loan;
								Loan = (Loan *5.9)/100;
								
								SSSContri = Loan + Loan1 + A00;
								SSSContri = Gross - SSSContri;
								SSSContri = (SSSContri *4.2)/100;
								
								String TaxPaid = String.format("%.2f", A00);
								txtTax.setText(TaxPaid);
								txtTax.setText("php" + TaxPaid);
								
								
								
								String LoanPaid = String.format("%.2f", A00);
								txtLoan.setText(LoanPaid);
								txtLoan.setText("php" + LoanPaid);
								
								String SSSContriPaid = String.format("%.2f", A00);
								txtSSSContri.setText(SSSContriPaid);
								txtSSSContri.setText("php" + SSSContriPaid);
								
								TotalDeduction = A00 + Loan1 + Loan + SSSContri;
								NetPay = Gross - TotalDeduction;
								
								String TDeduction = String.format("%.2f", TotalDeduction);
								txtDeductions.setText(TDeduction);
								txtDeductions.setText("php" + TDeduction);
								
								String TNetPay = String.format("%.2f", NetPay);
								txtNetPay.setText(TNetPay);
								txtNetPay.setText("php" + TNetPay);
								
								
								
								
								
						}
					
					else if (cmbNICode.getSelectedItem().equals("G9000")) {
								G90 = 9000/12;
								A00 = (Gross * 9)/100;
								deduction = Gross - A00;
								Loan1 =(deduction * 12)/100;
								
								Loan = Loan1 + A00;
								Loan = Gross - Loan;
								Loan = (Loan *5.9)/100;
								
								SSSContri = Loan + Loan1 + A00;
								SSSContri = Gross - SSSContri;
								SSSContri = (SSSContri *4.2)/100;
								
								String TaxPaid = String.format("%.2f", A00);
								txtTax.setText(TaxPaid);
								txtTax.setText("php" + TaxPaid);
								
								
								
								String LoanPaid = String.format("%.2f", A00);
								txtLoan.setText(LoanPaid);
								txtLoan.setText("php" + LoanPaid);
								
								String SSSContriPaid = String.format("%.2f", A00);
								txtSSSContri.setText(SSSContriPaid);
								txtSSSContri.setText("php" + SSSContriPaid);
								
								TotalDeduction = A00 + Loan1 + Loan + SSSContri;
								NetPay = Gross - TotalDeduction;
								
								String TDeduction = String.format("%.2f", TotalDeduction);
								txtDeductions.setText(TDeduction);
								txtDeductions.setText("php" + TDeduction);
								
								String TNetPay = String.format("%.2f", NetPay);
								txtNetPay.setText(TNetPay);
								txtNetPay.setText("php" + TNetPay);
								
								
								
					}
					txtGrossPay.setText(GrossPay);
				} catch (NumberFormatException e) {
					JOptionPane.showConfirmDialog(null, "Enter a Valid Number", "Payroll System",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
				
				
				//============================================================================================
				
				
				String sBasicSalary = String.format("php%.2f", BasicSalary);
				txtBasicSalary.setText(sBasicSalary);
				
				String sMealAllowance = String.format("php%.2f", MealAllowance);
				txtMealAllowance.setText(sMealAllowance);
				
				String sOT = String.format("php%.2f", OT);
				txtOT.setText(sOT);
			}
		});
		btnNewButton.setBounds(926, 564, 140, 33);
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnPaySlip = new JButton("Pay Slip");
		btnPaySlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paydate = txtPayDate.getText();
				String name = txtEmployeeName.getText();
				String address = txtEmployeeAddress.getText();
				String postal =  txtPostCode.getText();
				String  netpay = txtNetPay.getText();
				String deductions= txtDeductions.getText();
				String msg = "" + name;
		        msg += " \n";
				//=============================================================================================
		        try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll1", "root", "1234");

                    String query = "INSERT INTO account values('" + paydate + "','" + name + "','" + address + "','" +
                        postal + "','" + netpay + "','" + deductions + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Hello sir/mam " +  "The payslip is sucessfully save to our database. ");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				rtfPaySlip.append("GROUP 4 PAYROLL SYSTEM\n");
				
				rtfPaySlip.append("Pay Date: " + txtPayDate.getText() + "\n");
				rtfPaySlip.append("Emp. Ref: " + txtEmployeeNo.getText() + "\n");
				rtfPaySlip.append("Emp. Name: " + txtEmployeeName.getText() + "\n"); 
				rtfPaySlip.append("Basic Salary: " + txtBasicSalary.getText() + "\n");
				rtfPaySlip.append("Meal Allowance: " + txtMealAllowance.getText() + "\n");
				rtfPaySlip.append("Over Time: " + txtOT.getText() + "\n");
				rtfPaySlip.append("SSS Contribution: " + txtSSSContri.getText() + "\n");
				rtfPaySlip.append("Loan: " + txtLoan.getText() + "\n");
				rtfPaySlip.append("Tax Code: " + cmbNICode.getSelectedItem() + "\n");
				rtfPaySlip.append("Tax Paid: " + txtTax.getText() + "\n");
				rtfPaySlip.append("Gross Pay: " + txtGrossPay.getText() + "\n");
				rtfPaySlip.append("Deductions: " + txtDeductions.getText() + "\n");
				rtfPaySlip.append("Net Pay: " + txtNetPay.getText() + "\n");
				
				//rtfPaySlip.append("Basic Salary: + txtEmployeeName.getText() + "Tax Paid: " + txtTax.getText() + "\n");
				}
		});
		
		btnPaySlip.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnPaySlip.setBounds(1097, 564, 140, 33);
		getFrame().getContentPane().add(btnPaySlip);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rtfPaySlip.setText(null);
				txtPayDate.setText(null);
				txtEmployerName.setText(null);
				txtEmployeeName.setText(null);
				txtEmployeeAddress.setText(null);
				txtEmployeeNo.setText(null);
				txtPostCode.setText(null);
				txtBasicSalary.setText(null);
				txtMealAllowance.setText(null);
				txtOT.setText(null);
				txtGrossPay.setText(null);
				txtTax.setText(null);
				txtLoan.setText(null);
				txtSSSContri.setText(null);
				txtNetPay.setText(null);
				txtSSSNumber.setText(null);
				txtDeductions.setText(null);
			}
		});
		
	
		
		btnReset.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnReset.setBounds(926, 608, 140, 33);
		getFrame().getContentPane().add(btnReset);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setFrame(new JFrame("Exit"));
				if (JOptionPane.showConfirmDialog(getFrame(), "Confirm if you want to exit", "Payroll Systems",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				System.exit(0);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(1097, 608, 140, 33);
		getFrame().getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pay Slip:");
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(871, 172, 155, 51);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		JLabel lblEmployersName = new JLabel("Employer's Name:");
		lblEmployersName.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEmployersName.setBounds(28, 171, 179, 33);
		getFrame().getContentPane().add(lblEmployersName);
		
		txtEmployerName = new JTextField();
		txtEmployerName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEmployerName.setColumns(10);
		txtEmployerName.setBounds(217, 181, 222, 28);
		getFrame().getContentPane().add(txtEmployerName);
		
		txtPayDate = new JTextField();
		txtPayDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPayDate.setColumns(10);
		txtPayDate.setBounds(615, 186, 148, 28);
		getFrame().getContentPane().add(txtPayDate);
		
		JLabel lblNewLabel_3 = new JLabel("Group4 Payroll Management System");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel_3.setBounds(299, 30, 1045, 98);
		getFrame().getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\reg.jpg"));
		lblNewLabel_4.setBounds(37, 11, 170, 149);
		getFrame().getContentPane().add(lblNewLabel_4);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(lblNewLabel_4, popupMenu);
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
