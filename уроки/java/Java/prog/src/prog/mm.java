package prog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import widgets.ChooseRandom;
import stat.Histo;
import widgets.Diagram;
import stat.DiscretHisto;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class mm extends JFrame {

	private JPanel contentPane;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	/**
	 * @wbp.nonvisual location=93,329
	 */
	private final Histo histo = new Histo();
	private ChooseRandom chooseRandom;
	private Diagram diagram;
	/**
	 * @wbp.nonvisual location=25,319
	 */
	private JTextField textField;
	private JButton button_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextArea textArea;
	/**
	 * @wbp.nonvisual location=365,329
	 */
	private final DiscretHisto discretHisto = new DiscretHisto();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mm frame = new mm();
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
	public mm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		chooseRandom = new ChooseRandom();
		chooseRandom.setBounds(22, 11, 375, 39);
		contentPane.add(chooseRandom);

		diagram = new Diagram();
		diagram.setGridByX(10);
		diagram.setBounds(21, 61, 390, 273);
		contentPane.add(diagram);

		JButton jButton = new JButton("\u0413\u0456\u0441\u0442\u043E\u0433\u0440\u0430\u043C\u0430");
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				{
					int chooseCount = Integer.parseInt(textField.getText());
					histo.initFromTo(Integer.parseInt(textField_1.getText()),
							Integer.parseInt(textField_2.getText()),
							Integer.parseInt(textField_3.getText()));
					for(int i = 0; i<chooseCount; i++){
						double rnd = chooseRandom.next();
						histo.add(rnd);
					}
					histo.showRelFrec(diagram);
					System.out.println(histo.toString());
					textArea.setText(histo.toString());
				}
			}
		});
		jButton.setBounds(418, 11, 143, 36);
		contentPane.add(jButton);

		textField = new JTextField();
		textField.setText("1000");
		textField.setBounds(445, 113, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\u041E\u0431\u0441\u044F\u0433 \u0432\u0438\u0431\u0456\u0440\u043A\u0438");
		label.setBounds(454, 100, 89, 14);
		contentPane.add(label);

		JButton jButton1 = new JButton("\u0414\u0438\u0441\u043A\u0440\u0435\u0442\u043D\u0430 \u0433\u0456\u0441\u0442\u043E\u0433\u0440\u0430\u043C\u0430");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int chooseCount = Integer.parseInt(textField.getText());
					if(!(chooseRandom.random instanceof rnd.Discret))
					return;
					//discretHisto.initFromTo(2, 5);
					discretHisto.initFromTo(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));
					for(int i=0; i<chooseCount; i++){
					discretHisto.addFrequencyForValue(1, chooseRandom.next());
					}
					discretHisto.showRelFrec(diagram);
					System.out.println(discretHisto.toString());
					textArea.setText(discretHisto.toString());
					}
					});
			
		jButton1.setBounds(418, 144, 143, 46);
		contentPane.add(jButton1);

		jButton2 = new JButton("\u0406\u043D\u0442\u0435\u0433\u0440\u0430\u043B\u044C\u043D\u0430 \u0444\u0443\u043D\u043A\u0446\u0456\u044F");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					double from = Double.parseDouble(textField_1.getText());
					double to = Double.parseDouble(textField_2.getText());
					double step = Double.parseDouble(textField_3.getText());
					int count = (int) ((to-from)/step);
					double [] X = new double[count];
					double [] Y = new double[count];
					for(int i = 0; i<count; i++){
					X[i] = from + i*step;
					Y[i] = chooseRandom.probability(X[i]); 
					}
					diagram.drawDependency(X, Y, Color.BLACK, true);
					System.out.println(diagram.toString());
					}
					});
		
					jButton2.setBounds(418, 201, 143, 46);
		contentPane.add(jButton2);

		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setBounds(433, 272, 49, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("10");
		textField_2.setBounds(512, 272, 49, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("10");
		textField_3.setBounds(469, 314, 49, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		label_1 = new JLabel("\u041E\u0442");
		label_1.setBounds(449, 258, 46, 14);
		contentPane.add(label_1);

		label_2 = new JLabel("\u0414\u043E");
		label_2.setBounds(530, 258, 46, 14);
		contentPane.add(label_2);

		label_3 = new JLabel("\u0428\u0430\u0433");
		label_3.setBounds(479, 300, 46, 14);
		contentPane.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(571, 40, 260, 294);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	public ChooseRandom getChooseRandom() {
		return chooseRandom;
	}
	public Diagram getDiagram() {
		return diagram;
	}
}
