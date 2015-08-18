package lab4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Faculty extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Facult str;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Faculty dialog = new Faculty();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Faculty() {
		setTitle("Faculty");
		setBounds(100, 100, 228, 177);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(93, 11, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 14, 46, 14);
		contentPanel.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 42, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 73, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblKolgroup = new JLabel("KolGroup");
		lblKolgroup.setBounds(37, 45, 46, 14);
		contentPanel.add(lblKolgroup);
		
		JLabel lblKolprep = new JLabel("KolPrep");
		lblKolprep.setBounds(37, 76, 46, 14);
		contentPanel.add(lblKolprep);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						str = newFacult();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public Facult newFacult(){
		String name = textField.getText();
		int KolGroup = Integer.valueOf(textField_1.getText());
		int KolPrep = Integer.valueOf(textField_2.getText());
		Facult strt = new Facult(name,KolGroup,KolPrep);
		return strt;
	}
}
