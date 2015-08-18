package lab4;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Tree implements TreeModel, Serializable, Iterable<Node> {
	public static final ITreeOperation PRINT_TREE_NODE = new ITreeOperation(){
		public void processNode(Node node){
			System.out.println(node.getData());
		}
	};
	
	public void forwardTraverse(Node pNode, ITreeOperation p){
		pNode.forwardTraverse(p);
	}
	
	public void backwardTraverse(Node node, ITreeOperation p){
		node.backwardTraverse(p);
	}
	
	public Vector<Node> toList(Node startNode){
		final Vector<Node> list = new Vector<Node>();
		forwardTraverse(startNode, new ITreeOperation(){

			@Override
			public void processNode(Node node) {
				list.add(node);
			}
			
		});
		return list;
		
	}
	
	private class TreeIterator implements Iterator<Node>{
		List<Node> list;
		int index =0;
		
		TreeIterator(){
			list=toList(root);
		}
		
		TreeIterator(Node startNode){
			list = toList(startNode);
		}
		
		@Override
		public boolean hasNext() {
			return index<list.size();
		}

		@Override
		public Node next() {
			index++;
			return list.get(index-1);
		}

		@Override
		public void remove() {
			index--;
			Node delNode = list.get(index);
			delNode.forwardTraverse(new ITreeOperation(){

				@Override
				public void processNode(Node node) {
					list.remove(node);
					
				}
				
			});
			Tree.this.remove(delNode);
		}
		
	}
	
	private Node root;

	public Tree(Node root) {
		super();
		this.root = root;
	}
	public void add(Node parent, Node son){
		parent.add(son);
	}
	public void remove(Node node){
		if (node==root) root=null;
		node.remove();
	}
	public Node createNode(Node parent, Object data){
		return parent.createNode(data);
	}
	public void setData(Node node, Object data){
		node.setData(data);
	}
	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getChild(Object parent, int index) {
		Node p=(Node)parent;
		return p.getChild(index);
	}
	@Override
	public int getChildCount(Object parent) {
		Node p=(Node)parent;
		return p.getChildCount();
	}
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		Node p=(Node)parent;
		Node son=(Node)child;
		return p.getIndexOfChild(son);
	}
	
	@Override
	public Object getRoot() {
		return root;
	}
	@Override
	public boolean isLeaf(Object node) {
		Node nod=(Node)node;
		return nod.isLeaf();
	}
	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Node> iterator() {
		// TODO Auto-generated method stub
		return new TreeIterator();
	}
	
	public Iterator<Node> iterator(Node node){
		return new TreeIterator(node);
	}
	
	public  Node findNode(Node startNode, INodeTester tester){
		return startNode.findNode(tester);
	}
	
}
