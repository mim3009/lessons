package lab4;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public abstract class MapNode extends Node {
	protected Map<Object, Node> sonMap;
	@Override
	public void add(Node son) {
		MapNode newSon = (MapNode)son;
		sonMap.put(newSon.getData(), newSon);
	}
	@Override
	public Iterator<Node> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Node>() {
			Set<Entry<Object, Node>> set = sonMap.entrySet();
			Iterator<Entry<Object, Node>> setIter = set.iterator();
			Object key;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return setIter.hasNext();
			}
			@Override
			public Node next() {
				// TODO Auto-generated method stub
				Entry<Object, Node> entr = setIter.next();
				key = entr.getKey();
				return sonMap.get(key);
			}
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				sonMap.remove(key);
			}
		};
	}
}

