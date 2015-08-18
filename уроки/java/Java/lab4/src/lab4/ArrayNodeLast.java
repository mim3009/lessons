package lab4;

public class ArrayNodeLast extends ArrayNode {
	
	public ArrayNodeLast(Object data){
		this.data=data;
	}
	
	public Node createNode(Object data){
		ArrayNodeLast newSon= new ArrayNodeLast(data);
		newSon.parent = this;
		return newSon;
	}
	
	public void add(Node son){
		ArrayNode newSon = (ArrayNode) son;
		if (firstSon == null) {
			firstSon = newSon;
			return;
		}
		ArrayNode current=firstSon;
		while (current.brother != null){
			System.out.println(current);
			current=current.brother;
		}
		newSon.brother=current.brother;
		current.brother=newSon;
	}

}
