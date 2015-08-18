package stu.jtap.labs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lab1Tester extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab1Tester frame = new Lab1Tester();
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
	public Lab1Tester() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 128, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(10, 11, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u043A\u0432\u0430\u0434\u0440\u0430\u0442");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x = textField.getText();
				Integer b = Integer.parseInt(x);
				Integer a = b*b;
				String v = String.valueOf(a);
				textField.setText(v);
			}
		});
		button.setBounds(10, 53, 104, 57);
		contentPane.add(button);
	}
}
