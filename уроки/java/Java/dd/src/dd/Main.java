package dd;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	static JTextField ansField;
	static JTextField ansField2;
	static JButton sum;
	public Main(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calc");
		setResizable(false);
		setSize(128, 160);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setSize(128, 160);
		panel.setLayout(null);
		
		ansField = new JTextField();
		ansField.setSize(50, 25);
		ansField.setLocation(5, 10);
		ansField.setFont(new Font("Arial", Font.BOLD, 24));
		ansField.setEditable(false);
		
		ansField2 = new JTextField();
		ansField2.setSize(50, 25);
		ansField2.setLocation(55, 10);
		ansField2.setFont(new Font("Arial", Font.BOLD, 24));
		ansField2.setEditable(false);
		
		sum = new JButton("+");
		sum.setSize(50, 50);
		sum.setLocation(75, 75);
		
		panel.add(sum);
		add(panel);
		
		sum.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sum){
			int a = Integer.parseInt(ansField.getText());
			int b = Integer.parseInt(ansField2.getText());
			String c = String.valueOf(a+b);
			ansField.setText(c);
		}
		
	}

}
