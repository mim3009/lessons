package d;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*; 
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private HashMap hm = new HashMap();
	private Entry m;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 76, 414, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u041D\u043E\u0432\u044B\u0439");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hm.put(textField.getText(), textField_1.getText());
			}
		});
		btnNewButton.setBounds(10, 42, 198, 23);
		contentPane.add(btnNewButton);
		
		JButton btnD = new JButton("\u041F\u0435\u0440\u0435\u0432\u0435\u0441\u0442\u0438");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String)hm.get(textField.getText());
				if(s == null){
					textField_1.setText("не найдено, допишите словарь пожалуста либо введите иное значение");
					JOptionPane.showMessageDialog(null, "нет такого(");
					textField_1.setText(null);
				}else{ textField_1.setText(s);}
			}
		});
		btnD.setBounds(218, 42, 206, 23);
		contentPane.add(btnD);
	}
}
