import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class App {

	private JFrame frmZlatenLevCalculator;
	private JTextField txtTmp;

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
		btnCalculate.setBounds(161, 135, 97, 25);
		frmZlatenLevCalculator.getContentPane().add(btnCalculate);
		
		txtTmp = new JTextField();
		txtTmp.setText("tmp");
		txtTmp.setBounds(151, 89, 145, 33);
		frmZlatenLevCalculator.getContentPane().add(txtTmp);
		txtTmp.setColumns(10);
		
		
		JTextArea txtrDate = new JTextArea();
		txtrDate.setText(String.valueOf(connect.date));
		txtrDate.setEditable(false);
		txtrDate.setBounds(95, 31, 64, 16);
		frmZlatenLevCalculator.getContentPane().add(txtrDate);
		
		JLabel lblNewLabel = new JLabel("\u0414\u0430\u0442\u0430");
		lblNewLabel.setBounds(53, 31, 56, 16);
		frmZlatenLevCalculator.getContentPane().add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("\u0426\u0435\u043D\u0430 \u043D\u0430 \u0434\u044F\u043B");
		lblPrice.setBounds(208, 31, 75, 16);
		frmZlatenLevCalculator.getContentPane().add(lblPrice);
		
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setText(String.valueOf(connect.value));
		txtrPrice.setEditable(false);
		txtrPrice.setBounds(295, 31, 44, 16);
		frmZlatenLevCalculator.getContentPane().add(txtrPrice);
		
		JLabel lblShares = new JLabel("\u0414\u044F\u043B\u043E\u0432\u0435");
		lblShares.setBounds(95, 97, 56, 16);
		frmZlatenLevCalculator.getContentPane().add(lblShares);
	}
}
