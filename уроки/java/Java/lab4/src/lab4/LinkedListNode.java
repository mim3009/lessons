package lab4;

import java.util.LinkedList;

public class LinkedListNode extends ListNode{
	public LinkedListNode(Object data){
		this.data=data;
		sonList = new LinkedList<Node>();
	}
	
public Node createNode (Object data){
	LinkedListNode newSon=new LinkedListNode (data);
	newSon.parent=this;
	return newSon;
}

}