package lab4;

public class LinkedNodeSort extends LinkedNode {
	
	public LinkedNodeSort(Object data){
		this.data=data;
	}
	
	public Node createNode(Object data){
		LinkedNodeSort newSon= new LinkedNodeSort(data);
		newSon.parent = this;
		return newSon;
	}
	
	public void add(Node son){
		LinkedNode newSon = (LinkedNode) son;
		if (firstSon == null) {
			firstSon = newSon;
			return;
		}
		if(newSon.compareTo(firstSon)<0){
			newSon.brother=firstSon;
			firstSon=newSon;
			return;
		}
		LinkedNode current=firstSon;
		while (current.brother != null && newSon.compareTo(current.brother)>=0){
			System.out.println(current);
			current=current.brother;
		}
		newSon.brother=current.brother;
		current.brother=newSon;
	}
	
	
	
}
