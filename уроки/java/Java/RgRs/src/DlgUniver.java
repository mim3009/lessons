
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DlgUniver extends Dlg implements IDlg{
	private JTextField textFieldRectorName;
	private JTextField textFieldLevel;
	public DlgUniver() {
		setTitle("\u0423\u043D\u0456\u0432\u0435\u0440\u0441\u0438\u0442\u0435\u0442");
		setBounds(100, 100, 172, 227);//TODO
		
		JLabel label_1 = new JLabel("\u041F\u0406\u0411 \u0440\u0435\u043A\u0442\u043E\u0440\u0430");
		getContentPanel().add(label_1);
		
		textFieldRectorName = new JTextField();
		textFieldRectorName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRectorName.setColumns(15);
		getContentPanel().add(textFieldRectorName);
		
		JLabel label_2 = new JLabel("\u0420\u0456\u0432\u0435\u043D\u044C \u0430\u043A\u0440\u0435\u0434\u0438\u0442\u0430\u0446\u0456\u0457");
		getContentPanel().add(label_2);
		
		textFieldLevel = new JTextField();
		textFieldLevel.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLevel.setColumns(5);
		getContentPanel().add(textFieldLevel);
	}
	public DlgUniver(AnyData data) {//TODO
		this();
		Univer u=(Univer) data;
		textFldName.setText(u.name);
		textFieldRectorName.setText(u.rectorName);
		textFieldLevel.setText(String.valueOf(u.level));
	}
	@Override
	public Object getObject() {
		if(!ok) return null;
		String name = textFldName.getText();
		String fioRector = textFieldRectorName.getText();
		int level = Integer.parseInt(textFieldLevel.getText());
		return new Univer(name, fioRector, level);
	}
	@Override
	public void setEditable(boolean b) {
		super.setEditable(b);
		textFieldRectorName.setEditable(b);
		textFieldLevel.setEditable(b);
	}

}
