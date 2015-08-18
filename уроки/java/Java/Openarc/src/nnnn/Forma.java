package nnnn;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JProgressBar;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Forma extends JFrame {

	private JPanel contentPane;
	private JTextField txtPath;
	private JTree tree;
	private JarTree treeModel;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					Forma frame = new Forma();
					frame.setVisible(true);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Forma() {
		setTitle("Forma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtPath = new JTextField();
		txtPath.setBounds(108, 206, 506, 24);
		contentPane.add(txtPath);
		txtPath.setColumns(10);
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(10, 206, 93, 24);
		btnBrowse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ChooseFile();
			}
		});
		contentPane.add(btnBrowse);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 141, 184);
		contentPane.add(scrollPane);
		tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setBackground(Color.WHITE);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				JarNode node = (JarNode) e.getPath().getLastPathComponent();
				textArea.setText(node.getData());
			}
		});
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(161, 11, 453, 184);
		contentPane.add(scrollPane_1);
		textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPane_1.setViewportView(textArea);
	}

	public JTree getTree() {
		return tree;
	}

	private void ChooseFile() {
		JFileChooser f = new JFileChooser();
		f.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "JAR Archives";
			}

			@Override
			public boolean accept(File f) {
				return (f.getName().endsWith(".jar") || f.isDirectory());
			}
		});
		f.showOpenDialog(this);
		if (f.getSelectedFile() == null)
			return;
		String path = f.getSelectedFile().getAbsolutePath();
		txtPath.setText(path);
		try {
			JarViewer jve = new JarViewer(txtPath.getText(), tree);
			treeModel = jve.getTree();
			tree.setModel(treeModel);
			tree.updateUI();
			Thread th = new Thread(jve);
			th.start();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public JTextArea getTextArea() {
		return textArea;
	}
}