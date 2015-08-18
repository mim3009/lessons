package lab4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPopupMenu;




























import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ButtonGroup;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Forma_dereva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_2;
	private JTextField textField;
	private JTextArea textArea;
	private JTree tree;
	private Tree treeModel;
	private BufferedWriter bw;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_4;
	private JRadioButton rdbtnNewRadioButton_5;
	private JRadioButton rdbtnNewRadioButton_6;
	private JRadioButton rdbtnNewRadioButton_7;
	private JRadioButton rdbtnNewRadioButton_8;
	private JRadioButton rdbtnNewRadioButton_9;
	private JRadioButton rdbtnNewRadioButton_10;
	private JRadioButton rdbtnNewRadioButton_11;
	private JRadioButton rdbtnNewRadioButton_12;
	private JRadioButton rdbtnNewRadioButton_13;
	private JRadioButton rdbtnNewRadioButton_14;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forma_dereva frame = new Forma_dereva();
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
	public Forma_dereva() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				try {
					bw = new BufferedWriter(new FileWriter("Log.txt"));
					Date d = new Date();
					bw.write(String.valueOf(d)+" - время открытия окна");
					bw.newLine();
					Component[] arrRb = panel_2.getComponents();
					for(Component component : arrRb){
						if(component instanceof JRadioButton){
							final JRadioButton rb = (JRadioButton) component;
							rb.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									String s = rb.getText();
									try {
										bw.write("выбрана радиоклавиша: " + s);
										bw.newLine();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
							});
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			public void windowClosing(WindowEvent e) {
				 super.windowClosing(e);
				 try {
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setTitle("Project\"PolimorphTree\"");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblInputData = new JLabel("Input data");
		panel.add(lblInputData);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onBtnAdd();
				writeString("добавление значения в дерево");
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onBtnRemove();
				writeString("Удаление значения из дерева");
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rename");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onBtnRename();
				writeString("обьект переименован");
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ForwardTravers");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node node = getSelectNode();
				treeModel.forwardTraverse(node, Tree.PRINT_TREE_NODE);
			}
		});
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("BackTraverse");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node node = getSelectNode();
				treeModel.backwardTraverse(node, Tree.PRINT_TREE_NODE);
			}
		});
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("TreeIterrator");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testIterator();
			}
		});
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Find");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testFind();
			}

			
		});
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Store");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBtnStore();
			}
		});
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Restore");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBtnRestore();
			}
		});
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("MultiThreadsRendering");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiThreadsRendering();
			}
		});
		panel_1.add(btnNewButton_9);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		rdbtnNewRadioButton = new JRadioButton("LinkedNodeFirst");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root = new LinkedNodeFirst("LinkedNodeFirst Root");
				treeModel = new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		panel_2.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("LinkedNodeLast");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node root = new LinkedNodeLast("LinkedNodeLast Root");
				treeModel = new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_2.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("LinkedNodeSort");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node root = new LinkedNodeSort("LinkedNodeSort Root");
				treeModel = new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		panel_2.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("ArrayNodeFirst");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root = new ArrayNodeFirst("ArrayNodeFirst Root");
				treeModel = new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		panel_2.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("ArrayNodeLast");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root = new ArrayNodeLast("ArrayNodeLast Root");
				treeModel = new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		panel_2.add(rdbtnNewRadioButton_4);
		
		rdbtnNewRadioButton_5 = new JRadioButton("ArrayNodeSort");
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root = new ArrayNodeSort("ArrayNodeSort Root");
				treeModel = new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		panel_2.add(rdbtnNewRadioButton_5);
		
		rdbtnNewRadioButton_6 = new JRadioButton("VectorNode");
		buttonGroup_2.add(rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node root = new VectorNode("VectorTreeRoot");
				treeModel = new Tree(root);
				tree.setModel(treeModel);
			}
		});
		panel_2.add(rdbtnNewRadioButton_6);
		
		rdbtnNewRadioButton_7 = new JRadioButton("LinkedListNode");
		buttonGroup_2.add(rdbtnNewRadioButton_7);
		rdbtnNewRadioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node root=new LinkedListNode("LinkedListTreeRoot");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		panel_2.add(rdbtnNewRadioButton_7);
		
		rdbtnNewRadioButton_8 = new JRadioButton("ArrayListNode");
		buttonGroup_2.add(rdbtnNewRadioButton_8);
		rdbtnNewRadioButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node root=new ArrayListNode("ArrayListTreeRoot");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		panel_2.add(rdbtnNewRadioButton_8);
		
		rdbtnNewRadioButton_9 = new JRadioButton("HashSetNode");
		rdbtnNewRadioButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root=new HashSetNode("HashSetNode");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_3.add(rdbtnNewRadioButton_9);
		panel_2.add(rdbtnNewRadioButton_9);
		
		rdbtnNewRadioButton_10 = new JRadioButton("LinkedHashSetNode");
		rdbtnNewRadioButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root=new LinkedHashSetNode("LinkedHashSetNode");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_3.add(rdbtnNewRadioButton_10);
		panel_2.add(rdbtnNewRadioButton_10);
		
		rdbtnNewRadioButton_11 = new JRadioButton("TreeSetNode");
		rdbtnNewRadioButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root=new TreeSetNode("TreeSetNode");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_3.add(rdbtnNewRadioButton_11);
		panel_2.add(rdbtnNewRadioButton_11);
		
		rdbtnNewRadioButton_12 = new JRadioButton("HashMapNode");
		rdbtnNewRadioButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root=new HashMapNode("HashMapNode");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_4.add(rdbtnNewRadioButton_12);
		panel_2.add(rdbtnNewRadioButton_12);
		
		rdbtnNewRadioButton_13 = new JRadioButton("LinkedHashMapNode");
		rdbtnNewRadioButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root=new LinkedHashMapNode("LinkedHashMapNode");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_4.add(rdbtnNewRadioButton_13);
		panel_2.add(rdbtnNewRadioButton_13);
		
		rdbtnNewRadioButton_14 = new JRadioButton("TreeMapNode");
		rdbtnNewRadioButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node root=new TreeMapNode("TreeMapNode");
				treeModel=new Tree(root);
				tree.setModel(treeModel);
			}
		});
		buttonGroup_4.add(rdbtnNewRadioButton_14);
		panel_2.add(rdbtnNewRadioButton_14);
		
		tree = new JTree();
		contentPane.add(tree, BorderLayout.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tree, popupMenu);
		
		JButton btnShowdialog = new JButton("ShowDialog");
		btnShowdialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Faculty dialog = new Faculty();
				dialog.setVisible(true);
				onBtnAdd2();
			}
		});
		popupMenu.add(btnShowdialog);
	
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		textArea = new JTextArea();
		panel_3.add(textArea);
		
		
	}
	private Node getSelectNode(){
		Object selectNode=tree.getLastSelectedPathComponent();
		if (selectNode==null){
			JOptionPane.showMessageDialog(tree, "Node was not selected","LabTree", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		Node node=(Node)selectNode;
		return node;
	}
	
	private void onBtnAdd(){
		Node parent=getSelectNode();
		if (parent==null)
			return;
		String text=textField.getText();
		Node newSon=treeModel.createNode(parent,text);
		treeModel.add(parent,newSon);
		tree.updateUI();
		for (int i=0; i< tree.getRowCount(); i++) tree.expandRow(i);
	}
	
	private void onBtnAdd2(){
		Node parent = getSelectNode();
		if(parent==null)
			return;
		int t = tree.getSelectionPath().getPathCount();
		System.out.println(t);
		switch(t){
		case 1: {
			Faculty dlg1 = new Faculty();
			Node newSon = treeModel.createNode(parent,dlg1.str.getName());
			treeModel.add(parent, newSon);}
		case 2: Group dlg2 = new Group();
		case 3: Student dlg3 = new Student();
		}	
		tree.updateUI();
	}
	
	private void onBtnRemove(){
		Node node = getSelectNode();
		if (node==null)
			return;
		treeModel.remove(node);
		tree.updateUI();
	}
	
	private void onBtnRename(){
		Node node = getSelectNode();
		if(node == null)
			return;
		String text = textField.getText();
		Node newNode = treeModel.createNode(node, text);
		treeModel.setData(node, newNode);;
		tree.updateUI();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void testIterator(){
		Node node = getSelectNode();
		if(node==null) return;
		String s = textField.getText();
		Iterator<Node> itr = treeModel.iterator(node);
		while (itr.hasNext()){
			Node nd = itr.next();
			if(nd.getData().toString().equals(s)){
				itr.remove();
			}
		}
		tree.updateUI();
	}
	
	private void testFind() {
		Node startNode = getSelectNode();
		if(startNode==null) return;
		INodeTester tester = new INodeTester(){

			@Override
			public boolean testNode(Node node) {
				String s = (String) node.getData();
				String text = textField.getText();
				return text.equals(s);
			}
		};
		Node node = treeModel.findNode(startNode, tester );
		if(node==null) textArea.setText("не найдено");
		else { 
			textArea.setText(node.toString());;
			//tree.setSelectionRow();
		}	
	}
	
	private void onBtnStore() {
		JFileChooser fileChoser = new JFileChooser("Сериализация дерева");
		fileChoser.showSaveDialog(tree);
		File f = fileChoser.getSelectedFile();
		try{
			FileOutputStream fileStream = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fileStream);
			out.writeObject(treeModel);
			out.close();
		}catch (IOException e1){ e1.printStackTrace();}
		tree.setModel((new JTree()).getModel());
	}

	private void onBtnRestore() {
		FileDialog fileDialog = new FileDialog(this);
		fileDialog.setMode(FileDialog.LOAD);
		fileDialog.setVisible(true);
		String dr = fileDialog.getDirectory();
		String fn = fileDialog.getFile();
		if(dr == null || fn == null) return;
		String fName = dr + fn;
		try{
			FileInputStream fStream = new FileInputStream(fName);
			ObjectInputStream in = new ObjectInputStream(fStream);
			treeModel = (Tree) 	in.readObject();
			tree.setModel(treeModel);
			in.close();
		}catch (Exception e1){e1.printStackTrace();}
		for(int i=0;i< tree.getRowCount();i++){
			tree.expandRow(i);
		}
		Object root = treeModel.getRoot();
		String rootClassName = root.getClass().getSimpleName();
		Component[] arrRb = panel_2.getComponents();
		for(Component component : arrRb){
			if(component instanceof JRadioButton){
				JRadioButton rb = (JRadioButton) component;
				if(rb.getText().equals(rootClassName)){
					rb.setSelected(true);
					break;
				}
			}
		}
	}
	
	private void writeString(String string) {
		try {
			bw.write(string);
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	protected void multiThreadsRendering(){
		if(treeModel == null)
			return;
		System.out.println("Протокол работы потоков");
		String strN = textField.getText();
		int n = Integer.parseInt(strN);
		System.out.println("Число потоков " + n);
		for(int i = 0; i < n; i++){
			String name = "Thread_" + String.valueOf(i+1);
			TreeHandler th = new TreeHandler(name, tree);
			Thread thread = new Thread(th,name);
			thread.start();
		}
	}
	
}
	

