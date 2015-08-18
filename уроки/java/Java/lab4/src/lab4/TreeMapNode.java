package lab4;

import java.util.HashMap;
import java.util.TreeMap;
public class TreeMapNode extends MapNode {
	public TreeMapNode(Object data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		sonMap = new TreeMap<Object, Node>();
	}
	@Override
	public Node createNode(Object data) {
		// TODO Auto-generated method stub
		TreeMapNode son = new TreeMapNode(data);
		son.parent = this;
		return son;
	}
}
