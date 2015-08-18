package lab1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingUtilities;

import stat.Histo;
import widgets.Diagram;

public class Forma extends JFrame {

private static final long serialVersionUID = 1L;
private JPanel jContentPane = null;
private Histo histo = null; // @jve:decl-index=0:visual-constraint="741,53"
private Diagram diagram = null;
private JTextArea jTextArea = null;
private JLabel jLabel = null;
private JTextField jTextField = null;
private JButton jButton = null;
private JScrollPane jScrollPane = null;

/**
* This method initializes histo 
* 
* @return stat.Histo 
*/
private Histo getHisto() {
if (histo == null) {
histo = new Histo();
}
return histo;
}

/**
* This method initializes diagram 
* 
* @return widgets.Diagram 
*/
private Diagram getDiagram() {
if (diagram == null) {
diagram = new Diagram();
diagram.setBounds(new Rectangle(0, 0, 284, 162));
}
return diagram;
}

/**
* This method initializes jTextArea 
* 
* @return javax.swing.JTextArea 
*/
private JTextArea getJTextArea() {
if (jTextArea == null) {
jTextArea = new JTextArea();
}
return jTextArea;
}

/**
* This method initializes jTextField 
* 
* @return javax.swing.JTextField 
*/
private JTextField getJTextField() {
if (jTextField == null) {
jTextField = new JTextField();
jTextField.setBounds(new Rectangle(9, 192, 100, 20));
}
return jTextField;
}

/**
* This method initializes jButton 
* 
* @return javax.swing.JButton 
*/
private JButton getJButton() {
if (jButton == null) {
jButton = new JButton();
jButton.setBounds(new Rectangle(119, 176, 162, 25));
jButton.setText("Получить гистограму");
jButton.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
int obem = Integer.parseInt(getJTextField().getText());
histo=getHisto();
histo.init();
for(int i=0;i<obem;i++){
double rand=Math.random();
histo.add(rand); 
}
histo.showRelFrec(diagram);
getJTextArea().append(histo.toString());
}
});
}
return jButton;
}

/**
* This method initializes jScrollPane 
* 
* @return javax.swing.JScrollPane 
*/
private JScrollPane getJScrollPane() {
if (jScrollPane == null) {
jScrollPane = new JScrollPane();
jScrollPane.setBounds(new Rectangle(286, 5, 317, 206));
jScrollPane.setViewportView(getJTextArea());
}
return jScrollPane;
}

/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub
SwingUtilities.invokeLater(new Runnable() {
public void run() {
Forma thisClass = new Forma();
thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
thisClass.setVisible(true);
}
});
}

/**
* This is the default constructor
*/
public Forma() {
super();
initialize();
}

/**
* This method initializes this
* 
* @return void
*/
private void initialize() {
this.setSize(625, 253);
this.setContentPane(getJContentPane());
this.setTitle("JFrame");
}

/**
* This method initializes jContentPane
* 
* @return javax.swing.JPanel
*/
private JPanel getJContentPane() {
if (jContentPane == null) {
jLabel = new JLabel();
jLabel.setBounds(new Rectangle(9, 167, 100, 22));
jLabel.setText("Обьем выборки");
jContentPane = new JPanel();
jContentPane.setLayout(null);
jContentPane.add(getDiagram(), null);
jContentPane.add(jLabel, null);
jContentPane.add(getJTextField(), null);
jContentPane.add(getJButton(), null);
jContentPane.add(getJScrollPane(), null);
}
return jContentPane;
}

}