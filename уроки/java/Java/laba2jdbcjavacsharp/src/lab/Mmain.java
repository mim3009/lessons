package lab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Mmain extends JFrame {

	private JPanel contentPane;
	private static Connection conn;
	private static Statement stmt;
	private JTextField txtSelectFrom;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					Mmain frame = new Mmain();
					frame.setVisible(true);
					conn = Util.getConnection();
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					System.out.println("connected");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mmain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					conn.close();
					stmt.close();
					System.out.println("disconnect");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 623, 220);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("SELECT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String s = txtSelectFrom.getText();
				ResultSet k = stmt.executeQuery(s);
				while(k.next()){
					int id;
					String fio;
					String pol;
					
					id = k.getInt("id");
					if(k.wasNull()){
						id = -1;
					}
					fio = k.getString("fio");
					if(k.wasNull()){
						fio = null;
					}
					pol = k.getString("pol");
					if(k.wasNull()){
						pol = null;
					}
	        		textArea.append("\n\t id="+id);
	        		textArea.append("\n\t fio="+fio);
	        		textArea.append("\n\t pol="+pol);
	        		textArea.append("\n\t -----------------------");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 242, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("INSERT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String s = textField_1.getText();
					String d = textField_4.getText();
					stmt.executeUpdate("INSERT INTO "+s+ " VALUES ( "+d+ ")");
					JOptionPane.showMessageDialog(null, "запись вставлена");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "допущена ошибка или елемент существует");
					}
			}
		});
		btnNewButton_1.setBounds(10, 272, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String f = textField_5.getText();
					String g = textField_6.getText();
					String s = textField_2.getText();
					stmt.executeUpdate("UPDATE " +s+ " SET " +f+ " WHERE " +g);
					JOptionPane.showMessageDialog(null, "запись обновлена");
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "что-то не так");
					}
			}
		});
		btnNewButton_2.setBounds(10, 306, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String h = textField_7.getText();
					String s = textField_3.getText();
					stmt.executeUpdate("DELETE FROM " +s+ " WHERE " +h);
					JOptionPane.showMessageDialog(null, "запись удалена");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "что-то не так");
					}
			}
		});
		btnNewButton_3.setBounds(10, 340, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(109, 242, 532, 23);
		contentPane.add(scrollPane_1);
		
		txtSelectFrom = new JTextField();
		txtSelectFrom.setText("SELECT (\u0447\u0442\u043E) FROM (\u0442\u0430\u0431\u043B\u0438\u0446\u0430) WHERE (\u0443\u0441\u043B\u043E\u0432\u0438\u0435)");
		scrollPane_1.setViewportView(txtSelectFrom);
		txtSelectFrom.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(141, 306, 89, 23);
		contentPane.add(scrollPane_3);
		
		textField_2 = new JTextField();
		scrollPane_3.setViewportView(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(161, 338, 240, 25);
		contentPane.add(scrollPane_4);
		
		textField_3 = new JTextField();
		scrollPane_4.setViewportView(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(141, 272, 220, 23);
		contentPane.add(scrollPane_2);
		
		textField_1 = new JTextField();
		scrollPane_2.setViewportView(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u041A\u0443\u0434\u0430:");
		lblNewLabel.setBounds(109, 276, 38, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0427\u0442\u043E:");
		lblNewLabel_1.setBounds(371, 276, 30, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(405, 272, 236, 23);
		contentPane.add(scrollPane_5);
		
		textField_4 = new JTextField();
		scrollPane_5.setViewportView(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u0427\u0442\u043E:");
		lblNewLabel_2.setBounds(109, 310, 30, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u0423\u0441\u0442\u0430\u043D\u043E\u0432\u0438\u0442\u044C:");
		label.setBounds(240, 310, 73, 14);
		contentPane.add(label);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(308, 306, 136, 23);
		contentPane.add(scrollPane_6);
		
		textField_5 = new JTextField();
		scrollPane_6.setViewportView(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("(\u043A\u043E\u043B\u043E\u043D\u043A\u0430/\u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblNewLabel_3.setBounds(240, 324, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("\u0413\u0434\u0435:");
		label_1.setBounds(452, 310, 30, 14);
		contentPane.add(label_1);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(480, 306, 161, 23);
		contentPane.add(scrollPane_7);
		
		textField_6 = new JTextField();
		scrollPane_7.setViewportView(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_2 = new JLabel("(\u043A\u043E\u043B\u043E\u043D\u043A\u0430/\u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435)");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 7));
		label_2.setBounds(435, 324, 73, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u041E\u0442\u043A\u0443\u0434\u0430:");
		label_3.setBounds(109, 344, 53, 14);
		contentPane.add(label_3);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(445, 340, 196, 23);
		contentPane.add(scrollPane_8);
		
		textField_7 = new JTextField();
		scrollPane_8.setViewportView(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_4 = new JLabel("\u0413\u0434\u0435:");
		label_4.setBounds(411, 344, 30, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("(\u043A\u043E\u043B\u043E\u043D\u043A\u0430/\u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435)");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 7));
		label_5.setBounds(392, 360, 67, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("(\u0437\u043D\u0430\u0447\u0435\u043D\u0438\u044F \u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u043F\u044F\u0442\u0443\u044E)");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 7));
		label_6.setBounds(340, 291, 89, 14);
		contentPane.add(label_6);
		
	
		
		
		
	
	}
}
