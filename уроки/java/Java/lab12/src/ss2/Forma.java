package ss2;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	

public class Forma extends JFrame {

	private JPanel contentPane;
	private TimerTask tt;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forma frame = new Forma();
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
	public Forma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStart();
			}
		});
		btnStart.setBounds(169, 227, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tt.cancel();
			}
		});
		btnStop.setBounds(262, 227, 89, 23);
		contentPane.add(btnStop);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 341, 205);
		contentPane.add(panel);
	}
	private void onStart(){
		Timer t = new Timer(true);
		tt = new MyTask1(panel);
		t.schedule(tt, 100, 14000);
	}
}
