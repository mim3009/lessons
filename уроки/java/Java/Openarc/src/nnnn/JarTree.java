package nnnn;

import java.util.StringTokenizer;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class JarTree implements TreeModel{
	private JarNode root;

	public JarTree(JarNode root) {
		this.root = root;
	}

	@Override
	public JarNode getRoot() {
		return root;
	}

	@Override
	public JarNode getChild(Object parent, int index) {
		JarNode node = (JarNode) parent;
		return node.getChild(index);
	}

	@Override
	public int getChildCount(Object parent) {
		JarNode node = (JarNode) parent;
		return node.getChildCount();
	}

	@Override
	public boolean isLeaf(Object node) {
		JarNode nod = (JarNode) node;
		return (nod.getChildCount() == 0);
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
//		JarNode m_par = (JarNode) parent;
//		JarNode m_child = (JarNode) child;
//		Object[] childs = m_par.getChilds();
//		for (int i = 0; i < childs.length; i++) {
//			if (m_child.Compare(childs[i]))
//				return i;
//		}
		return -1;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
	}

	public void add(JarNode parent, JarNode node) {
		parent.addChild(node);
	}

	public void add(JarNode node) {
		if (root != null)
			root.addChild(node);
	}

	public JarNode getNodeByPath(String path) {
		StringTokenizer str = new StringTokenizer(path, "\\");
		JarNode node = root;
		int cnt = str.countTokens();
		for (int i = 0; i < cnt; i++) {
			node = node.getChild(str.nextToken());
			if (node == null)
				return null;
		}
		return node;
	}

	public void createPath(String path) {
		this.createPath(path, "");
	}

	public void createPath(String path, String data) {
		StringTokenizer str = new StringTokenizer(path, "/");
		String cur;
		JarNode node = root;
		JarNode testNode;
		int cnt = str.countTokens();
		for (int i = 0; i < cnt; i++) {
			cur = str.nextToken();
			testNode = node.getChild(cur);
			if (testNode != null) {
				node = testNode;
				continue;
			}

			else {
				JarNode newNode;

				if (node == root)
					newNode = new JarNode(cur, cur, data);
				else
					newNode = new JarNode(cur, node.getPath() + "\\" + cur,data);
				node.addChild(newNode);
				node = newNode;
			}
		}
	}
}