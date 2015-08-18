package lab4;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashMapNode extends MapNode {
	public HashMapNode(Object data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		sonMap = new HashMap<Object, Node>();
	}
	@Override
	public Node createNode(Object data) {
		// TODO Auto-generated method stub
		HashMapNode son = new HashMapNode(data);
		son.parent = this;
		return son;
	}

}
