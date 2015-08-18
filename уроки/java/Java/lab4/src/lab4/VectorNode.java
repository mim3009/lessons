package lab4;

import java.util.Vector;

public class VectorNode extends ListNode {

	public VectorNode(Object data){
		this.data=data;
		sonList=new Vector<Node>();
	}

	@Override
	public Node createNode(Object data) {
		VectorNode newSon=new VectorNode(data);
		newSon.parent=this;
		return newSon;
	}
	
}
