package lab4;

import java.util.Iterator;
import java.util.Set;



public abstract class SetNode extends Node {
	protected Set<Node> sonSet;

	@Override
	public void add(Node son) {
		sonSet.add(son);
		return;
	}

	@Override
	public Node createNode(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		return sonSet.iterator();
	}
	

}
