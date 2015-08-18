package lab4;

public class ArrayNodeSort extends ArrayNode {

	public ArrayNodeSort(Object data){
		this.data=data;
	}
	
	public Node createNode(Object data){
		ArrayNodeSort newSon= new ArrayNodeSort(data);
		newSon.parent = this;
		return newSon;
	}
	
	public void add(Node son){
		ArrayNode newSon = (ArrayNode) son;
		if (firstSon == null) {
			firstSon = newSon;
			return;
		}
		if(newSon.compareTo(firstSon)<0){
			newSon.brother=firstSon;
			firstSon=newSon;
			return;
		}
		ArrayNode current=firstSon;
		while (current.brother != null && newSon.compareTo(current.brother)>=0){
			System.out.println(current);
			current=current.brother;
		}
		newSon.brother=current.brother;
		current.brother=newSon;
	}

}
