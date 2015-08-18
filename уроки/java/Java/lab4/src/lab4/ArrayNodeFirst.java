package lab4;

public class ArrayNodeFirst extends ArrayNode{
	
	public ArrayNodeFirst(Object data){
		this.data=data;
	}
	
	public Node createNode(Object data){
		ArrayNodeFirst newSon= new ArrayNodeFirst(data);
		newSon.parent = this;
		return newSon;
	}
	
	public void add(Node son){
		ArrayNode newSon = (ArrayNode) son;
		if (firstSon == null) {
			firstSon = newSon;
			return;
		}
		newSon.brother=firstSon;
		firstSon=newSon;
	}


}
