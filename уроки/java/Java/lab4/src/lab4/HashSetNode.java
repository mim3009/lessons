package lab4;

import java.util.HashSet;
@SuppressWarnings("unchecked")
public class HashSetNode extends SetNode {
	public HashSetNode(Object data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		sonSet = new HashSet<Node>();
	}
	@Override
	public Node createNode(Object data) {
		// TODO Auto-generated method stub
		HashSetNode son = new HashSetNode(data);
		son.parent = this;
		return son;
	}
}
