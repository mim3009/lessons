package calk;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class form extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 235, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String k = btnNewButton.getText();
				textField.setText(k);
			}
		});
		btnNewButton.setBounds(10, 42, 51, 23);
		contentPane.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_1.getText();
				textField.setText(k+" ");
			}
		});
		btnNewButton_1.setBounds(71, 42, 51, 23);
		contentPane.add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_2.getText();
				textField.setText(k+" ");
			}
		});
		btnNewButton_2.setBounds(132, 42, 51, 23);
		contentPane.add(btnNewButton_2);
		
		final JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_3.getText();
				textField.setText(k+" ");
			}
		});
		btnNewButton_3.setBounds(10, 77, 51, 23);
		contentPane.add(btnNewButton_3);
		
		final JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_4.getText();
				textField.setText(k+" ");
			}
		});
		btnNewButton_4.setBounds(71, 77, 51, 23);
		contentPane.add(btnNewButton_4);
		
		final JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_5.getText();
				textField.setText(k+" ");
			}
		});
		btnNewButton_5.setBounds(132, 77, 51, 23);
		contentPane.add(btnNewButton_5);
		
		final JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_6.getText();
				textField.setText(k+" ");
			}
		});
		btnNewButton_6.setBounds(10, 113, 51, 23);
		contentPane.add(btnNewButton_6);
		
		final JButton btnNewButton_7 = new JButton("8");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_7.getText();
				textField.setText(k+" ");
			}
		});
		btnNewButton_7.setBounds(71, 111, 51, 23);
		contentPane.add(btnNewButton_7);
		
		final JButton btnNewButton_8 = new JButton("9");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_8.getText();
				String f = textField.getText();
				textField.setText(f+" "+k+" ");
			}
		});
		btnNewButton_8.setBounds(132, 111, 51, 23);
		contentPane.add(btnNewButton_8);
		
		final JButton btnNewButton_9 = new JButton("0");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k = btnNewButton_9.getText();
				String f = textField.getText();
				textField.setText(f+" "+k+" ");
			}
		});
		btnNewButton_9.setBounds(10, 147, 51, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("+");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String g = textField.getText();
				textField.setText(g+"+");
			}
		});
		btnNewButton_10.setBounds(192, 42, 53, 23);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("-");
		btnNewButton_11.setBounds(193, 77, 52, 23);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("*");
		btnNewButton_12.setBounds(193, 113, 52, 23);
		contentPane.add(btnNewButton_12);
		
		JButton button = new JButton("/");
		button.setBounds(194, 147, 51, 23);
		contentPane.add(button);
		
		JButton btnNewButton_13 = new JButton("C");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnNewButton_13.setBounds(71, 145, 51, 23);
		contentPane.add(btnNewButton_13);
		
		JButton button_1 = new JButton("=");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				StringTokenizer st = new StringTokenizer(s);
				BigDecimal[] mas = new BigDecimal[st.countTokens()];
				for (int i =0; st.hasMoreTokens();i++){
					mas[i] = new BigDecimal(st.nextToken());
				}
				for(int i=0;;i++){
				System.out.println(mas[i]);
				}
			}
		});
		button_1.setBounds(132, 145, 53, 23);
		contentPane.add(button_1);
	}
	
}

