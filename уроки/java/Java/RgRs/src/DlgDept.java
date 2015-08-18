import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class DlgDept extends Dlg implements IDlg{
	private JTextField textField_1;
	private JCheckBox checkBox;

	public DlgDept() {
		setTitle("\u041A\u0430\u0444\u0435\u0434\u0440\u0430");
		setBounds(100, 100, 190, 169);
		
		JLabel label_1 = new JLabel("\u0417\u0430\u0432\u0456\u0434\u0443\u0432\u0430\u0447");
		getContentPanel().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(15);
		getContentPanel().add(textField_1);
		
		checkBox = new JCheckBox("\u041A\u0430\u0444\u0435\u0434\u0440\u0430 \u0432\u0438\u043F\u0443\u0441\u043A\u0430\u044E\u0447\u0430 ");
		getContentPanel().add(checkBox);
		checkBox.setVisible(false);
	}
	public DlgDept(AnyData data) {
		this();
		Dept dpt =(Dept) data;
		textFldName.setText(dpt.name);
		textField_1.setText(dpt.chiefName);
		checkBox.setSelected(dpt.spec);
	}

	@Override
	public Object getObject() {
		if(! ok) return null;
		String name = textFldName.getText();
		String cheafFio = textField_1.getText();
		boolean spec = checkBox.isSelected();
		return new Dept(name, cheafFio, spec);
	}

	public void setEditable(boolean b) {
		super.setEditable(b);
		textFldName.setEditable(b);
		textField_1.setEditable(b);
		checkBox.setEnabled(b);
	}
	public JCheckBox getCheckBox() {
		return checkBox;
	}
}
