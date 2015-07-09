import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class App {

	private JFrame frmZlatenLevCalculator;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDate;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmZlatenLevCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public App() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmZlatenLevCalculator = new JFrame();
		frmZlatenLevCalculator.setTitle("Zlaten lev calculator");
		frmZlatenLevCalculator.setResizable(false);
		frmZlatenLevCalculator.setBounds(100, 100, 450, 300);
		frmZlatenLevCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZlatenLevCalculator.getContentPane().setLayout(null);
		
		Connector connect = new Connector();
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = textField.getText();
				double shares = Double.parseDouble(textFieldValue);
				textField_1.setText(String.valueOf( 
					Math.round(shares*connect.value*100.0) / 100.0));
				try {
					new Log(connect, String.valueOf( 
							Math.round(shares*connect.value*100.0) / 100.0), 
							textField.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnCalculate.setBounds(70, 166, 97, 25);
		frmZlatenLevCalculator.getContentPane().add(btnCalculate);
		
		JLabel lblNewLabel = new JLabel("\u0414\u0430\u0442\u0430");
		lblNewLabel.setBounds(53, 31, 56, 16);
		frmZlatenLevCalculator.getContentPane().add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("\u0426\u0435\u043D\u0430 \u043D\u0430 \u0434\u044F\u043B");
		lblPrice.setBounds(208, 31, 75, 16);
		frmZlatenLevCalculator.getContentPane().add(lblPrice);
		
		JLabel lblShares = new JLabel("\u0414\u044F\u043B\u043E\u0432\u0435");
		lblShares.setBounds(95, 97, 56, 16);
		frmZlatenLevCalculator.getContentPane().add(lblShares);
		
		textField = new JTextField();
		File desktop = 
				new File(System.getProperty("user.home"), "Desktop");
		BufferedReader breadr = 
				new BufferedReader(new FileReader(desktop + "/Desktop" + "_logFile.txt")); 
		String shares = new String();
		shares = breadr.readLine();
		if ( shares != null) textField.setText(shares);
		breadr.close();
		textField.setBounds(153, 94, 116, 22);
		frmZlatenLevCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(208, 167, 116, 22);
		frmZlatenLevCalculator.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText(String.valueOf(connect.date));
		txtDate.setEditable(false);
		txtDate.setBounds(92, 28, 75, 22);
		frmZlatenLevCalculator.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText(String.valueOf(connect.value));
		txtPrice.setEditable(false);
		txtPrice.setBounds(289, 28, 56, 22);
		frmZlatenLevCalculator.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
	}
}
