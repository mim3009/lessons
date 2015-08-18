package lab4;

import java.util.TreeSet;
@SuppressWarnings("unchecked")
public class TreeSetNode extends SetNode {
	public TreeSetNode(Object data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		sonSet = new TreeSet<Node>();
	}
	@Override
	public Node createNode(Object data) {
		// TODO Auto-generated method stub
		TreeSetNode son = new TreeSetNode(data);
		son.parent = this;
		return son;
	}
}
