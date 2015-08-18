package lab4;

public class LinkedNodeLast extends LinkedNode{

	public LinkedNodeLast(Object data){
		this.data=data;
	}
	
	public Node createNode(Object data){
		LinkedNodeLast newSon= new LinkedNodeLast(data);
		newSon.parent = this;
		return newSon;
	}
	
	public void add(Node son){
		LinkedNode newSon = (LinkedNode) son;
		if (firstSon == null) {
			firstSon = newSon;
			return;
		}
		LinkedNode current=firstSon;
		while (current.brother != null){
			System.out.println(current);
			current=current.brother;
		}
		newSon.brother=current.brother;
		current.brother=newSon;
	}
	
}
