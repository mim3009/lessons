package lab4;

import java.util.ArrayList; 

public class ArrayListNode extends ListNode{
	public ArrayListNode(Object data){
		this.data=data;
		sonList = new ArrayList<Node>();
	}
	
public Node createNode (Object data){
	ArrayListNode newSon=new ArrayListNode (data);
	newSon.parent=this;
	return newSon;
}

}