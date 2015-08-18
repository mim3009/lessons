
import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack;

public class NodeRgr implements Comparable<NodeRgr>, Serializable {

	private Object data;
	private NodeRgr parent;
	private NodeRgr[] sonArray;
	private int sonCount;

	public NodeRgr(Object data) {
		this.data = data;
		sonArray = new NodeRgr[2];
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
		if (this.parent != null){
			this.remove();
			this.parent.add(this);
		}
	}

	public String toString() {
		return data.toString();
	}

	public NodeRgr createNode(Object data) {
		NodeRgr newSon = new NodeRgr(data);
		newSon.parent = this;
		return newSon;
	}

	public void add(NodeRgr son) {
		if (sonCount == sonArray.length)
			growSonArray();
		int i;
		for (i = 0; i < sonCount; i++) {
			if (sonArray[i].compareTo(son) > 0)
				break;
		}
		for (int j = sonCount; j > i; j--)
			sonArray[j] = sonArray[j - 1];
		sonArray[i] = son;
		sonCount++;

	}

	private void growSonArray() {
		NodeRgr[] newArr = new NodeRgr[sonArray.length + 2];
		for (int i = 0; i < sonArray.length; i++)
			newArr[i] = sonArray[i];
		sonArray = newArr;
	}

	public void remove() {
		int i;
		for (i = 0; parent.sonArray[i] != this; i++)
			;
		for (i = i; i < parent.sonArray.length - 1; i++)
			parent.sonArray[i] = parent.sonArray[i + 1];
		parent.sonCount--;
	}

	public int getChildCount() {
		return sonCount;
	}

	public NodeRgr getChild(int index) {
		return sonArray[index];
	}

	public int getIndexOfChild(NodeRgr son) {
		for (int i = 0; i < sonCount; i++)
			if (sonArray[i] == son)
				return i;
		return -1;
	}

	public int compareTo(NodeRgr obj) {
		return this.toString().compareTo(obj.toString());
	}

	public void forwardTraverse(ITreeOperation p) {
		p.processNode(this);
		for (int i = 0; i < sonCount; i++)
			sonArray[i].forwardTraverse(p);
	}

	public void backwardTraverse(ITreeOperation p) {
		// Создаем стек
		final Stack<NodeRgr> stack = new Stack<NodeRgr>();
		// Создаем обработчик для занесения в стек
		ITreeOperation ps = new ITreeOperation() {
			@Override
			public void processNode(NodeRgr node) {
				stack.push(node);
			}
		};
		// Прямой проход с занесением в стек
		this.forwardTraverse(ps);
		// Обработка стека
		while (!stack.empty()) {
			NodeRgr node = stack.pop();
			p.processNode(node);
		}
	}

	public NodeRgr findNode(INodeTester tester) {
		NodeRgr result = null;
		if (tester.testNode(this))
			return this;
		else
			for (int i = 0; i < sonCount; i++) {
				result = sonArray[i].findNode(tester);
				if (result != null)
					return result;
			}
		return null;
	}

	public void traverse() {
		System.out.println(this);
		for (int i = 0; i < sonCount; i++)
			sonArray[i].traverse();
	}

	public boolean isLeaf() {
		return sonCount == 0;
	}

}
