import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class Student extends Dlg implements IDlg {
	private JTextField textField;


	public Student() {
		setTitle("\u0421\u0442\u0443\u0434\u0435\u043D\u0442");
		setBounds(100, 100, 184, 179);//TODO		
		JLabel lblNewLabel = new JLabel("\u0441\u0440.\u0431\u0430\u043B");
		getContentPanel().add(lblNewLabel);
		
		textField = new JTextField();
		getContentPanel().add(textField);
		textField.setColumns(15);
	}
	
	public Student(AnyData data) {
		this();
		Stud st=(Stud) data;
		textFldName.setText(st.name);
		textField.setText(st.srbal);
	}

	@Override
	public Object getObject() {
		if (ok) {
			String name = textFldName.getText();
			String srbal = textField.getText();
			return new Stud(name, srbal);
		}
		return null;
	}
	
	public void setEditable(boolean b) {
		super.setEditable(b);
		textFldName.setEditable(b);
		textField.setEditable(b);
	}
}
