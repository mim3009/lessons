import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public  class Dlg extends JDialog {

	private final JPanel contentPanel = new JPanel();//TODO
	protected boolean ok;//TODO
	private JButton okButton;//TODO
	private JButton cancelButton;//TODO
	private JLabel lblName;
	protected JTextField textFldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dlg dialog = new Dlg();
///dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dlg() {
		setModal(true);//TODO
//setBounds(100, 100, 450, 300);//TODO
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblName = new JLabel("\u041D\u0430\u0437\u0432\u0430");
			contentPanel.add(lblName);
		}
		{
			textFldName = new JTextField();
			textFldName.setPreferredSize(new Dimension(160, 20));
			textFldName.setMinimumSize(new Dimension(80, 20));
			textFldName.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(textFldName);
			textFldName.setColumns(15);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok=true;//TODO
						setVisible(false);//TODO

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok=false;//TODO
						setVisible(false);//TODO

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected JPanel getContentPanel() {//TODO
		return contentPanel;
	}

	
	protected JButton getOkButton() {//TODO
		return okButton;
	}
	public JButton getCancelButton() {//TODO
		return cancelButton;
	}
	
	public void setEditable(boolean b) {//TODO
		textFldName.setEditable(b);
		if(!b){
			okButton.setVisible(false);
			cancelButton.setText("Exit");
		}
	}
	
}
