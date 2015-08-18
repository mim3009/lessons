package zahinf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JLabel;

public class Z extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextArea textArea;
	private JTextField textField_3;
	static Formatter x;

	int v = 5;
	int h = 5;
	String keyWord1 = new String();
	String keyWord2 = new String();
	String word = new String();
	char[] key = new char[5];
	char[] key1 = new char[5];
	char[][] table = new char[v][h];;
	char[][] newTable = new char[h][v];
	char[][] newTable1 = new char[h][v];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z frame = new Z();
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
	public Z() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton(
				"\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					keyWord1 = textField_1.getText();
					keyWord2 = textField_2.getText();
					word = textField.getText().replaceAll(" ", "");

					for (int i = 0, ii = 0; i < h; i++) {
						for (int j = 0; j < v; j++) {
							table[j][i] = word.charAt(ii);
							ii++;
						}
					}

					Z2 z = new Z2();
					z.keyArr(key, keyWord1);
					z.keyArr(key1, keyWord2);
					z.keys(key);
					String str = z.res();
					System.out.println(str);
					for (int j = 0; j < keyWord1.length(); j++) {
						for (int y = 0; y < keyWord1.length(); y++) {
							if ((int) key[j] == (int) keyWord1.charAt(y)) {
								for (int i = 0; i < v; i++) {
									newTable[j][i] = table[i][y];
								}
							}

						}
					}

					z.keys(key1);
					String str2 = z.res();
					System.out.println(str2);
					for (int j = 0; j < keyWord2.length(); j++) {
						for (int y = 0; y < keyWord2.length(); y++) {
							if ((int) key1[j] == (int) keyWord2.charAt(y)) {
								for (int i = 0; i < v; i++) {
									newTable1[i][j] = newTable[i][y];
								}
							}

						}
					}

					for (int i = 0; i < v; i++) {
						for (int j = 0; j < h; j++) {
							System.out.print(newTable1[j][i]);
						}
						System.out.println();
					}
					System.out.println();
					StringBuilder Result = new StringBuilder();
					for (int i = 0; i < v; i++) {
						for (int j = 0; j < h; j++) {
							System.out.print(newTable1[j][i]);
							Result.append(newTable1[j][i]);
						}
						Result.append(" ");
					}
					System.out.println();
					System.out.println();
					textArea.setText(Result.toString());
					String a = textArea.getText();
					x = new Formatter("res//1.txt");
					x.format(str + " " + str2 +" " + a, null);
					x.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(326, 7, 125, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(
				"\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String word = textArea.getText().replaceAll(" ", "");
				keyWord1 = textField_1.getText();
				keyWord2 = textField_2.getText();
				for (int i = 0, ii = 0; i < h; i++) {
					for (int j = 0; j < v; j++) {
						table[i][j] = word.charAt(ii);
						ii++;
					}
				}

				Z2 z = new Z2();
				z.keyArr(key, keyWord1);
				z.keyArr(key1, keyWord2);
				z.keys(key);
				z.keys(key1);
				for (int j = 0; j < keyWord2.length(); j++) {
					for (int y = 0; y < keyWord2.length(); y++) {
						if ((int) keyWord2.charAt(j) == (int) key1[y]) {
							for (int i = 0; i < v; i++) {
								newTable[j][i] = table[y][i];
							}
						}

					}
				}

				for (int i = 0; i < v; i++) {
					for (int j = 0; j < h; j++) {
					}
				}

				for (int j = 0; j < keyWord1.length(); j++) {
					for (int y = 0; y < keyWord1.length(); y++) {
						if ((int) keyWord1.charAt(j) == (int) key[y]) {
							for (int i = 0; i < v; i++) {
								newTable1[i][j] = newTable[i][y];
							}
						}

					}
				}

				for (int i = 0; i < v; i++) {
					for (int j = 0; j < h; j++) {
						System.out.print(newTable1[j][i]);
					}
					System.out.println();
				}
				System.out.println();

				StringBuilder Result = new StringBuilder();
				for (int i = 0; i < v; i++) {
					for (int j = 0; j < h; j++) {
						System.out.print(newTable1[j][i]);
						Result.append(newTable1[j][i]);
					}
				}
				textField_3.setText(Result.toString());
			}

		});
		btnNewButton_1.setBounds(326, 41, 125, 23);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField
				.setText("\u0417\u0410\u0412\u0422\u0420\u0410 \u0412\u0415\u0427\u0415\u0420\u041E\u041C \u0411\u0423\u0414\u0415\u041C \u041A\u0423\u0428\u0410\u0422\u042C!");
		textField.setBounds(113, 8, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("\u0428\u041E\u0420\u0422\u042B");
		textField_1.setBounds(10, 59, 93, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("\u0428\u0422\u0410\u041D\u042B");
		textField_2.setBounds(113, 58, 88, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(113, 90, 338, 16);
		contentPane.add(textArea);

		JLabel label = new JLabel(
				"\u0418\u0441\u0445\u043E\u0434\u043D\u044B\u0439 \u0442\u0435\u043A\u0441\u0442:");
		label.setBounds(10, 11, 112, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u041A\u043B\u044E\u0447 1:");
		label_1.setBounds(10, 45, 46, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u041A\u043B\u044E\u0447 2:");
		label_2.setBounds(111, 45, 46, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel(
				"\u0428\u0438\u0444\u0440\u043E\u0442\u0435\u043A\u0441\u0442:");
		label_3.setBounds(10, 90, 93, 14);
		contentPane.add(label_3);

		textField_3 = new JTextField();
		textField_3.setBounds(189, 118, 262, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_4 = new JLabel(
				"\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u043D\u043D\u043E\u0435 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435");
		label_4.setBounds(10, 121, 174, 14);
		contentPane.add(label_4);
	}
}
