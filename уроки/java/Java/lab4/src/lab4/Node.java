package lab4;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack;

public abstract class Node implements Iterable <Node>, Comparable<Node>, Serializable{
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	protected Object data;
	protected Node parent;
		
	public Node getParent(){
		return parent;
	}
	
	public abstract void add(Node son);

	public void remove() {
		if(this.parent==null) return;
		Iterator<Node>iter=parent.iterator();
		while(iter.hasNext()){
			Node node=iter.next();
			if (node==this)iter.remove();
		}
	}

	public abstract Node createNode(Object data);

	public void setData(Object data) {
		this.data = data;		
	}
	
	public Object getData(){
		return data;
	}
	
	public String toString(){
		return data.toString();
	}
	
	public Node getChild(int index) {
		int i =0;
		for(Node node:this){
			if(i==index)
				return node;
			i++;
		}
		return null;
	}

	public int getChildCount() {
		int i=0;
		for(Node node:this) i++;
		return i;
	}
	
	public int getIndexOfChild(Node son) {
		int i=0;
		for(Node node:this){
			if(node==son)
				return i;
			i++;
		}
		return -1;
	}

	public boolean isLeaf() {
		return getChildCount()==0;
	}

	@Override
	public abstract Iterator iterator();
	
	public int compareTo(Node obj){
		return this.toString().compareTo(obj.toString());
	}

	public void forwardTraverse(ITreeOperation p) {
		p.processNode(this);
		for (Node node : this){
			node.forwardTraverse(p);
		}
		
	}

	public void backwardTraverse(ITreeOperation p) {
		final Stack<Node> stack = new Stack<Node>();
		ITreeOperation ps = new ITreeOperation(){

			@Override
			public void processNode(Node node) {
				stack.push(node);
			}
			
		};
		this.forwardTraverse(ps);
		while (!stack.empty()){
			Node node = stack.pop();
			p.processNode(node);
		}
		
	}

	public Node findNode(INodeTester tester) {
		Node result = null;
		if (tester.testNode(this))
			return this;
		else 
			for (Node node : this){
				result = node.findNode(tester);
				if (result !=null)
					return result;
			}
		return null;
	}

}
