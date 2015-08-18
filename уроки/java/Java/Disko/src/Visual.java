
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import widgets.ChooseData;
import java.awt.Rectangle;
import widgets.ChooseRandom;
import rnd.Erlang;
import widgets.Diagram;
import javax.swing.JButton;

import process.Dispatcher;
import java.awt.Color;

public class Visual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private ChooseData chooseDataCountDancers = null;
	private ChooseRandom chooseRandomTimeOfWay = null;
	private ChooseRandom chooseRandomTimeOfDancing = null;
	private ChooseData chooseDataTimeToBegining = null;
	private ChooseData chooseDataTimeOfParty = null;
	private Diagram diagram = null;
	private JButton jButtonStart = null;
	/**
	 * This method initializes chooseDataCountDancers	
	 * 	
	 * @return widgets.ChooseData	
	 */
	protected ChooseData getChooseDataCountDancers() {
		if (chooseDataCountDancers == null) {
			chooseDataCountDancers = new ChooseData();
			chooseDataCountDancers.setBounds(new Rectangle(7, 7, 218, 48));
			chooseDataCountDancers.setText("100");
			chooseDataCountDancers.setTitle("Кількість бажаючих танцювати");
			chooseDataCountDancers.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					getDiagram().setVerticalMaxText(getChooseDataCountDancers().getText());
				}
			});
		}
		return chooseDataCountDancers;
	}

	/**
	 * This method initializes chooseRandomTimeOfWay	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	protected ChooseRandom getChooseRandomTimeOfWay() {
		if (chooseRandomTimeOfWay == null) {
			Erlang erlang = new Erlang();
			erlang.setK(2);
			chooseRandomTimeOfWay = new ChooseRandom();
			chooseRandomTimeOfWay.setBounds(new Rectangle(8, 60, 218, 58));
			chooseRandomTimeOfWay.setRandom(erlang);
			chooseRandomTimeOfWay.setTitle("Тривалість шляху до дискотеки");
		}
		return chooseRandomTimeOfWay;
	}

	/**
	 * This method initializes chooseRandomTimeOfDancing	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	protected ChooseRandom getChooseRandomTimeOfDancing() {
		if (chooseRandomTimeOfDancing == null) {
			chooseRandomTimeOfDancing = new ChooseRandom();
			chooseRandomTimeOfDancing.setBounds(new Rectangle(8, 122, 217, 57));
			chooseRandomTimeOfDancing.setTitle("Час перебування на дискотеці");
		}
		return chooseRandomTimeOfDancing;
	}

	/**
	 * This method initializes chooseDataTimeToBegining	
	 * 	
	 * @return widgets.ChooseData	
	 */
	protected ChooseData getChooseDataTimeToBegining() {
		if (chooseDataTimeToBegining == null) {
			chooseDataTimeToBegining = new ChooseData();
			chooseDataTimeToBegining.setBounds(new Rectangle(11, 184, 217, 48));
			chooseDataTimeToBegining.setText("1");
			chooseDataTimeToBegining.setTitle("Час до відкриття дискотеки");
		}
		return chooseDataTimeToBegining;
	}

	/**
	 * This method initializes chooseDataTimeOfParty	
	 * 	
	 * @return widgets.ChooseData	
	 */
	protected ChooseData getChooseDataTimeOfParty() {
		if (chooseDataTimeOfParty == null) {
			chooseDataTimeOfParty = new ChooseData();
			chooseDataTimeOfParty.setBounds(new Rectangle(13, 239, 216, 48));
			chooseDataTimeOfParty.setText("3");
			chooseDataTimeOfParty.setTitle("Тривалість роботи дискотеки");
		}
		return chooseDataTimeOfParty;
	}

	/**
	 * This method initializes diagram	
	 * 	
	 * @return widgets.Diagram	
	 */
	protected Diagram getDiagram() {
		if (diagram == null) {
			diagram = new Diagram();
			diagram.setBounds(new Rectangle(236, 13, 388, 215));
			diagram.setPainterColor(Color.red);
			diagram.setTitleText("Кількість танцюючих");
		}
		return diagram;
	}

	/**
	 * This method initializes jButtonStart	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStart() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setBounds(new Rectangle(292, 252, 283, 25));
			jButtonStart.setText("Старт");
			jButtonStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Dispatcher d = new Dispatcher();
					getDiagram().clear();
					
					PartyModel partyModel = new PartyModel(Visual.this, d);
					d.start();
				}
			});
		}
		return jButtonStart;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Visual thisClass = new Visual();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Visual() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(666, 338);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		getDiagram().setVerticalMaxText(getChooseDataCountDancers().getText());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getChooseDataCountDancers(), null);
			jContentPane.add(getChooseRandomTimeOfWay(), null);
			jContentPane.add(getChooseRandomTimeOfDancing(), null);
			jContentPane.add(getChooseDataTimeToBegining(), null);
			jContentPane.add(getChooseDataTimeOfParty(), null);
			jContentPane.add(getDiagram(), null);
			jContentPane.add(getJButtonStart(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
