package lab4;

import java.util.LinkedHashSet;
@SuppressWarnings("unchecked")
public class LinkedHashSetNode extends SetNode {
	public LinkedHashSetNode(Object data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		sonSet = new LinkedHashSet<Node>();
	}	
	@Override
	public Node createNode(Object data) {
		// TODO Auto-generated method stub
		LinkedHashSetNode son = new LinkedHashSetNode(data);
		son.parent = this;
		return son;
	}
}

