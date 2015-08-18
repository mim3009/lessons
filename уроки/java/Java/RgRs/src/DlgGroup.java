
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgGroup extends Dlg implements IDlg {
	private JTextField textField;
	public DlgGroup() {
		setTitle("\u0413\u0440\u0443\u043F\u043F\u0430");
		
		setBounds(100, 100, 184, 179);//TODO		
		JLabel lblNewLabel = new JLabel("\u0421\u0442\u0430\u0440\u043E\u0441\u0442\u0430");
		getContentPanel().add(lblNewLabel);
		
		textField = new JTextField();
		getContentPanel().add(textField);
		textField.setColumns(15);
	}
	
	public DlgGroup(AnyData data) {
		this();
		Group gr=(Group) data;
		textFldName.setText(gr.name);
		textField.setText(gr.starosta);
	}

	@Override
	public Object getObject() {
		if (ok) {
			String name = textFldName.getText();
			String starosta = textField.getText();
			return new Group(name, starosta);
		}
		return null;
	}
	
	public void setEditable(boolean b) {
		super.setEditable(b);
		textFldName.setEditable(b);
		textField.setEditable(b);
		
	}
}


