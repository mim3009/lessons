package lab4;

import java.util.Iterator;

public abstract class LinkedNode extends Node {

	protected LinkedNode firstSon;
	protected LinkedNode brother;
	
	private class LinkedIterator implements Iterator<Node>{

		private LinkedNode current = firstSon;
		private LinkedNode result;
		private LinkedNode predPesult;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Node next() {
			predPesult = result;
			result = current;
			current = current.brother;
			return result;
		}

		@Override
		public void remove() {
			if (result == firstSon)
				firstSon = current;
			else 
				predPesult.brother = current;
		}
		
	}
	
	@Override
	public void add(Node son) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node createNode(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Node> iterator() {
		return new LinkedIterator();
	}

}
