package lab4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Group extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Group dialog = new Group();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Group() {
		setTitle("Group");
		setBounds(100, 100, 172, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField_2 = new JTextField();
			textField_2.setBounds(60, 74, 86, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(60, 41, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField = new JTextField();
			textField.setBounds(60, 11, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(10, 14, 46, 14);
			contentPanel.add(lblName);
		}
		{
			JLabel lblKolstud = new JLabel("KolStud");
			lblKolstud.setBounds(10, 44, 46, 14);
			contentPanel.add(lblKolstud);
		}
		{
			JLabel lblFiostar = new JLabel("FIOStar");
			lblFiostar.setBounds(10, 77, 46, 14);
			contentPanel.add(lblFiostar);
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
