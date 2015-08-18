package nnnn;
import java.util.TreeMap;

public class JarNode {
	private TreeMap<String, JarNode> map;
	private Object[] arrOfMap;
	private String name;
	private String path;
	private String data;

	public JarNode(String name, String path, String data) {
		this.name = name;
		this.path = path;
		this.data = data;
		map = new TreeMap<String, JarNode>();
		arrOfMap = map.values().toArray();
	}

	public JarNode getChild(int index) {
		if (index >= arrOfMap.length)
			return null;
		return (JarNode) arrOfMap[index];
	}

	public JarNode getChild(String name) {
		return map.get(name);
	}

	public int getChildCount() {
		return arrOfMap.length;
	}

	public Object[] getChilds() {
		return (Object[]) arrOfMap;
	}

	public boolean Compare(JarNode node) {
		if (this.path.compareTo(node.getPath()) == 0)
			return true;
		else
			return false;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		return name;
	}

	public void addChild(JarNode node) {
		map.put(node.name, node);
		arrOfMap = map.values().toArray();
	}
}