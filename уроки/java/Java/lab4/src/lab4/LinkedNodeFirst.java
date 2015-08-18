package lab4;

public class LinkedNodeFirst extends LinkedNode {

	public LinkedNodeFirst(Object data){
		this.data=data;
	}
	
	public Node createNode(Object data){
		LinkedNodeFirst newSon= new LinkedNodeFirst(data);
		newSon.parent = this;
		return newSon;
	}
	
	public void add(Node son){
		LinkedNode newSon = (LinkedNode) son;
		if (firstSon == null) {
			firstSon = newSon;
			return;
		}
		newSon.brother=firstSon;
		firstSon=newSon;
	}
}
