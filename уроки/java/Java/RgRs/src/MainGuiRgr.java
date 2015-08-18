
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.SelectableChannel;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
import javax.swing.tree.TreeModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGuiRgr extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JTree tree;
	private TreeModelRgr treeModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainGuiRgr frame = new MainGuiRgr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGuiRgr() {
		setTitle("RGR UNIVER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPaneTree = new JScrollPane();
		contentPane.add(scrollPaneTree, BorderLayout.CENTER);
		NodeRgr root = new NodeRgr(new Univer("�����������", "������ �.�.", 4));
		treeModel = new TreeModelRgr(root);
		tree = new JTree(treeModel);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onMouseClicked(e);
			}
			
		});
		tree.setEditable(true);
		tree.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPaneTree.setViewportView(tree);

		JPanel panel_Bt = new JPanel();
		panel_Bt.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_Bt, BorderLayout.EAST);
		panel_Bt.setLayout(new GridLayout(7, 1, 0, 0));

		JButton btn_Add = new JButton("Add");
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBtnAdd();
			}
		});
		panel_Bt.add(btn_Add);

		JButton btn_Remove = new JButton("Remove");
		btn_Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBtnRemove();
			}
		});
		panel_Bt.add(btn_Remove);

		JButton btn_Rename = new JButton("Edit");
		btn_Rename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBtnEdit();
			}
		});

		panel_Bt.add(btn_Rename);
		
				JButton btnStore = new JButton("Store");
				btnStore.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						onBtnStore();
					}
				});
				panel_Bt.add(btnStore);
		
				JButton btnRestore = new JButton("Restore");
				btnRestore.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						onBtnRestore();
					}
				});
				panel_Bt.add(btnRestore);

		JButton btnFind = new JButton("FindDep");
		btnFind.setToolTipText("\u041F\u043E\u0448\u0443\u043A \u043A\u0430\u0444\u0435\u0434\u0440\u0438 \u0437\u0430 \u043D\u0430\u0437\u0432\u043E\u044E");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testFind();
			}
		});
		panel_Bt.add(btnFind);
		
		JButton btnCalcOutDep = new JButton("CalcGroupCnt");
		btnCalcOutDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBtnCalcDep();
			}
		});
		btnCalcOutDep.setToolTipText("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u0432\u0438\u043F\u0443\u0441\u043A\u0430\u044E\u0447\u0438\u0445 \u043A\u0430\u0444\u0435\u0434\u0440");
		panel_Bt.add(btnCalcOutDep);

		JPanel panel_Inpt = new JPanel();
		panel_Inpt.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_Inpt, BorderLayout.NORTH);
		panel_Inpt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblInputData = new JLabel("Input data");
		panel_Inpt.add(lblInputData);

		textField = new JTextField();
		panel_Inpt.add(textField);
		textField.setColumns(10);

		textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textArea.setPreferredSize(new Dimension(4, 46));
		contentPane.add(textArea, BorderLayout.SOUTH);
	}


	private void onBtnRestore() {
		FileDialog fileDialog = new FileDialog(this);
		fileDialog.setMode(FileDialog.LOAD);
		fileDialog.setVisible(true);
		String dr = fileDialog.getDirectory();
		String fn = fileDialog.getFile();
		if (dr == null || fn == null)
			return;
		String fName = dr + fn;
		try {
			// ������� ����� ����� ��� �������������� ������� treeModel
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fName));
			treeModel = (TreeModelRgr) in.readObject(); // �������������
			tree.setModel(treeModel);
			// ������
			in.close(); // ��������� �����
		} catch (Exception e1) {
			// ��������� ����������
			e1.printStackTrace();
		}
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}

	private void onBtnStore() {
		if (treeModel == null)
			return;
		JFileChooser fileChooser = new JFileChooser("������������ ������");
		fileChooser.showSaveDialog(tree);
		File f = fileChooser.getSelectedFile();
		String fName = f.getAbsolutePath();
		try {
			FileOutputStream fileStream = new FileOutputStream(fName);
			ObjectOutputStream out = new ObjectOutputStream(fileStream);
			out.writeObject(treeModel); // ����������� ������
			out.close(); // ��������� �����
		} catch (FileNotFoundException e1) {
			System.out.println("FileNotFound" + fName);
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tree.setModel((new JTree()).getModel());
	}



	private void onBtnEdit() {
		// �������� ������ �� ���������� ���� ������
		NodeRgr node = getSelectedNode();
		// ���� ���� �� ������ ������ ����� null
		if (node == null)
			return;
		AnyData data = (AnyData) node.getData();
		IDlg dlg = data.showDialog(true);
		Object obj = dlg.getObject();
		((JDialog) dlg).dispose();
		// Rename ����
		if (obj == null)
			return;
		treeModel.setData(node, obj);
		// ��������� ��� ������
		expandAll();
		tree.updateUI();
	}

	private void onBtnRemove() {
		// �������� ������ �� ���������� ���� ������
		// ���� ���� �� ������ ������ ����� null
		NodeRgr node = getSelectedNode();
		if (node == null)
			return;
		treeModel.remove(node);
		tree.setSelectionPath(null);
		tree.updateUI();
	}

	private void onBtnAdd() {
		// �������� ������ �� ���������� ���� ������
		NodeRgr parent = getSelectedNode();
		// ���� ���� �� ������ ������ ����� null
		if (parent == null) return;
		AnyData data = (AnyData) parent.getData();
		IDlg dlg = data.showSonDialog();
		if (dlg == null)
			return;
		Object obj = dlg.getObject();
		((JDialog) dlg).dispose();
		if (obj == null)
			return;
		NodeRgr newSon = treeModel.createNode(parent, obj);
		// ��������� ����
		treeModel.add(parent, newSon);
		// ��������� ��� ������
		tree.updateUI();
		//������������� ��� ����
		expandAll();
		
	}
	private void testFind() {
		NodeRgr startNode = getSelectedNode();
		if (startNode == null)
			return;
		final String text = textField.getText();
		//������� ������� �� �����
		NodeRgr node = treeModel.findNode(startNode, new INodeTester() {
			@Override
			public boolean testNode(NodeRgr node) {
				AnyData dt = (AnyData) node.getData();
				if (dt instanceof Dept) {
					Dept dp = (Dept) dt;
					if (dp.name.equals(text) || dp.chiefName.equals(text))
						return true;
				}
				return false;
			}
		});
		if (node == null)
			textArea.setText("�� �������");
		else {
			textArea.setText(node.toString());
			selectNode(node);
			AnyData dt = (AnyData) (node.getData());
			JDialog d = (JDialog) dt.showDialog(false);
			d.dispose();
		}
		
	}
	//ϳ������� ���������� �������
	protected void onBtnCalcDep() {
		NodeRgr node = getSelectedNode();
		if (node == null)
			return;
		
		class CalcDep implements ITreeOperation{
			int count=0;
			@Override
			public void processNode(NodeRgr node) {
				if(node.getData() instanceof Dept){
					Dept d=(Dept)(node.getData());
					if(node.getChildCount() != 0)count= count + node.getChildCount();
				}
			}
		}
		
		CalcDep p=new CalcDep();
		treeModel.forwardTraverse(node, p);
		textArea.setText(String.valueOf(p.count));
	}
	private NodeRgr getSelectedNode() {
		// �������� ������ �� ���������� ���� ������
		// ���� ���� �� ������ ������ ����� null
		Object selectNode = tree.getLastSelectedPathComponent();
		if (selectNode == null) {
			JOptionPane.showMessageDialog(tree, "NodeRgr was not selected",
					this.getTitle(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
		// �������� ������ � ���� ����
		return (NodeRgr) selectNode;
	}

	private int getSelectCol() {
		return tree.getSelectionPath().getPathCount();
	}

	private void onMouseClicked(MouseEvent e) {
		if (e.getClickCount() != 3 || 
				e.getButton() != MouseEvent.BUTTON3)
			return;
		NodeRgr node = getSelectedNode();
		if (node == null)
			return;
		AnyData data = (AnyData) node.getData();
		IDlg dlg = data.showDialog(false);
		((JDialog) dlg).dispose();
	}
	
	// �� ������� ����� 
	private void selectNode(NodeRgr node){
		int n=0;
		for (NodeRgr nod : treeModel) {
			if(nod==node) {
				tree.setSelectionRow(n);
				return;
			};
			n++;
		}	
	}
	// �� ���������� �� ����� 
	void expandAll() {
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}

}
