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
		setBounds(100, 100, 395, 126);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u041F\u043E\u0442\u043E\u0447\u043D\u0430\u044F \u0434\u0430\u0442\u0430");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date curTime = new Date(); 
				DateFormat dtfrm = DateFormat.getDateInstance(); 
				String fDate = dtfrm.format(curTime); 
				textField.setText(fDate);
			}
		});
		btnNewButton.setBounds(106, 42, 154, 23);
		contentPane.add(btnNewButton);
		textField = new JTextField();
		textField.setBounds(35, 11, 301, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
