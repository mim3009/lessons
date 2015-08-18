package lab4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Student extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Student dialog = new Student();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Student() {
		setTitle("Student");
		setBounds(100, 100, 203, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(91, 21, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(35, 24, 46, 14);
			contentPanel.add(lblName);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(91, 52, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblAge = new JLabel("Age");
			lblAge.setBounds(35, 55, 46, 14);
			contentPanel.add(lblAge);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(91, 83, 86, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblSrbal = new JLabel("SrBal");
			lblSrbal.setBounds(35, 86, 46, 14);
			contentPanel.add(lblSrbal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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

}
