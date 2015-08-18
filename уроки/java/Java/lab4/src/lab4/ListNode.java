package lab4;
import java.util.Iterator;
import java.util.List;

public abstract class ListNode extends Node {

	protected List<Node> sonList;
	
	public Iterator iterator(){
		return sonList.iterator();
	}
	
	public void add(Node son){
		sonList.add(son);
	}
}
