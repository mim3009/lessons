package lab4;

import java.util.Iterator;

public abstract class ArrayNode extends Node {

	protected ArrayNode firstSon;
	protected ArrayNode brother;
	
	private class ArrayIterator implements Iterator<Node>{

		private ArrayNode current = firstSon;
		private ArrayNode result;
		private ArrayNode predPesult;
		
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
	public Iterator<Node> iterator() {
		return new ArrayIterator();
	}

}
