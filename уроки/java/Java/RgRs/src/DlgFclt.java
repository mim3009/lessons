
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DlgFclt extends Dlg implements IDlg{
	private JTextField textFldDeanName;

	public DlgFclt() {
		super();
		setTitle("\u0424\u0430\u043A\u0443\u043B\u044C\u0442\u0435\u0442");
		setBounds(100, 100, 190, 182);
		
		JLabel label_1 = new JLabel("\u0414\u0435\u043A\u0430\u043D");
		getContentPanel().add(label_1);
		
		textFldDeanName = new JTextField();
		textFldDeanName.setHorizontalAlignment(SwingConstants.CENTER);
		textFldDeanName.setColumns(18);
		getContentPanel().add(textFldDeanName);
	}
	public DlgFclt(AnyData data) {
		this();
		Faculty fct=(Faculty) data;
		textFldName.setText(fct.name);
		textFldDeanName.setText(fct.deanName);
	}


	@Override
	public Object getObject() {
		if (ok) {
			String name = textFldName.getText();
			String deanFio = textFldDeanName.getText();
			return new Faculty(name, deanFio);
		}
		return null;
	}

	public void setEditable(boolean b) {
		super.setEditable(b);
		textFldName.setEditable(b);
		textFldDeanName.setEditable(b);
		
	}
}
