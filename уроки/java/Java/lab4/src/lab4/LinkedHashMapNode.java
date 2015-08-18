package lab4;

import java.util.LinkedHashMap;
public class LinkedHashMapNode extends MapNode {
	public LinkedHashMapNode(Object data) {
		this.data = data;
		sonMap = new LinkedHashMap<Object, Node>();
	}
	@Override
	public Node createNode(Object data) {
		LinkedHashMapNode son = new LinkedHashMapNode(data);
		son.parent = this;
		return son;
	}
}
