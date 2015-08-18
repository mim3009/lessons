import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class labor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labor frame = new labor();
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
	public labor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(177, 36, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(177, 67, 168, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(177, 97, 168, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel(
				"\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0425");
		lblNewLabel.setBounds(57, 39, 110, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0435");
		lblNewLabel_1.setBounds(57, 70, 110, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442");
		lblNewLabel_2.setBounds(57, 100, 110, 14);
		contentPane.add(lblNewLabel_2);

		JButton button = new JButton(
				"\u0412\u044B\u0447\u0438\u0441\u043B\u0438\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String g = textField.getText();
				double x = Double.parseDouble(g);
				String a = textField_1.getText();
				double e = Double.parseDouble(a);
				double z;
				try {
					z = CalcClass.calcSinh(x, e);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(),
							"������", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String s1 = "";
			}
			// textField_4.setText(s1);
			// textField_5.setText(mb[i]);
			// CalcClass.sort(masBD);
			// textField_4.setText(CalcClass.ObjArToString(masBD));
		}

		);
		button.setBounds(115, 128, 139, 23);
		contentPane.add(button);

		textField_3 = new JTextField();
		textField_3.setBounds(177, 11, 342, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(363, 97, 120, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel label = new JLabel(
				"\u043C\u0430\u043A\u0441\u0438\u043C\u0430\u043B\u044C\u043D\u043E\u0435");
		label.setBounds(363, 70, 120, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel(
				"\u0432\u0432\u0435\u0434\u0438\u0442\u0435 \u043C\u0430\u0441\u0441\u0438\u0432");
		label_1.setBounds(56, 11, 111, 14);
		contentPane.add(label_1);

		textField_5 = new JTextField();
		textField_5.setBounds(299, 128, 110, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField_3.getText();
				StringTokenizer st = new StringTokenizer(s);
				BigDecimal[] mb = new BigDecimal[st.countTokens()];
				for (int i = 0; st.hasMoreTokens(); i++) {
					mb[i] = new BigDecimal(st.nextToken());
				}
				sort(mb);
				for (int j = 0; j < mb.length; j++) {
					System.out.println(mb[j]);
				}
			}
		});
		btnNewButton.setBounds(16, 125, 89, 23);
		contentPane.add(btnNewButton);
	}

	protected void sort(BigDecimal[] mb) {
		BigDecimal temp;
		boolean exit = false;
		while (!exit) {
			exit = true;
			for (int i = 0; i < mb.length - 1; i++) {
				if (mb[i].compareTo(mb[i + 1]) > 0) {
					temp = mb[i];
					mb[i] = mb[i + 1];
					mb[i + 1] = temp;
					exit = false;
				}

			}

		}
	}
}