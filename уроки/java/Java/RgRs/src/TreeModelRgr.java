import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;



public class TreeModelRgr implements TreeModel, Iterable<NodeRgr>, Serializable {


	private NodeRgr root;

	public TreeModelRgr(NodeRgr root) {
		super();
		this.root = root;
	}

	public void add(NodeRgr parent, NodeRgr son) {
		parent.add(son);
	}

	public void remove(NodeRgr node) {
		if (node == root)
			root = null;
		node.remove();
	}

	public NodeRgr createNode(NodeRgr parent, Object data) {
		return parent.createNode(data);
	}

	public void setData(NodeRgr node, Object data) {
		node.setData(data);
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public int getChildCount(Object parent) {
		NodeRgr p = (NodeRgr) parent;
		return p.getChildCount();
	}

	@Override
	public Object getChild(Object parent, int index) {
		NodeRgr p = (NodeRgr) parent;
		return p.getChild(index);
	}

	
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		NodeRgr p = (NodeRgr) parent;
		NodeRgr son = (NodeRgr) child;
		return p.getIndexOfChild(son);
	}

	@Override
	public boolean isLeaf(Object node) {
		NodeRgr nod = (NodeRgr) node;
		return nod.isLeaf();
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		NodeRgr node = (NodeRgr) path.getLastPathComponent();
		node.setData(newValue);

	}


	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}

	public void forwardTraverse(NodeRgr pNode, ITreeOperation p) {
		pNode.forwardTraverse(p);
	}

	public void backwardTraverse(NodeRgr node, ITreeOperation p) {
		node.backwardTraverse(p);
	}
	public void traverse(NodeRgr node) {
		node.traverse();
	}

	
	public NodeRgr findNode(NodeRgr startNode, INodeTester tester){
		return startNode.findNode(tester);		
	}

	public Vector<NodeRgr> toList(NodeRgr startNode) {
		final Vector<NodeRgr> list = new Vector<NodeRgr>();
		forwardTraverse(startNode, new ITreeOperation() {
			@Override
			public void processNode(NodeRgr node) {
				list.add(node);
			}
		});
		return list;
	}

	@Override
	public Iterator<NodeRgr> iterator() {
		return new TreeIterator();
	}
	public Iterator<NodeRgr> iterator(NodeRgr node) {
		return new TreeIterator(node);
	}

	private class TreeIterator implements Iterator<NodeRgr> {
		List<NodeRgr> list; 
		int index = 0;
		//Конструктор без параметров для обхода дерева от корня
		TreeIterator(){
			list=toList(root);
		}
		//Конструктор для обхода дерева от заданного узла
		TreeIterator(NodeRgr startNode){
			list=toList(startNode);
		}

		@Override
		public boolean hasNext() {
			return index < list.size();
		}

		@Override
		public NodeRgr next() {
			index++;
			return list.get(index - 1);
		}

		@Override
		public void remove() {
			index--;
			NodeRgr delNode = list.get(index);
			//Удаление в списке узла и всех его потомков  
			delNode.forwardTraverse(new ITreeOperation() {
				@Override
				public void processNode(NodeRgr node) {
					list.remove(node);
				}
			});
			//Удаление узла в дереве
			TreeModelRgr.this.remove(delNode);
		}
	}
}
