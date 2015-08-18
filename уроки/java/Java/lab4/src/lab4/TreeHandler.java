package lab4;

import java.util.Iterator;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

public class TreeHandler implements Runnable {
	private String name;
	private JTree tree;
	private Tree model;
	
	public TreeHandler(String name, JTree tree) {
		super();
		this.name = name;
		this.tree = tree;
		model = (Tree) tree.getModel();
	}
	
	int fibo(int n){
		if(n<=0) return 0;
		else if (n == 1 || n == 2) return n;
		else return fibo(n-1) + fibo(n-2);
	}
	
	private boolean isNumber(Object nod){
		try{
			Integer.parseInt(nod.toString());
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	public boolean isFinished(Object nod){
		return nod.toString().indexOf("finish") >= 0;
	}
	
	INodeTester tester = new INodeTester() {
		public boolean testNode(Node node) {
			if(!isNumber(node))
			return false;
			Iterator<Node> itr = model.iterator(node);
			itr.next();
			while(itr.hasNext()){
				if(!isFinished(itr.next()))
					return false;
			}
			return true;
		}
	};
	
	void updateTree(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tree.updateUI();
			}
		});
	}
	
	public void run() {
		Node node;
		String nodeName;
		int n;
		System.out.println(name + " стартовал");
		while(true){
			System.out.println(name + " хочет найти узел для обработки.");
			synchronized (tree) {
				while(true){
					Node root = (Node) (model.getRoot());
					if(root == null || !isNumber(root)){
						System.out.println(name + " закончил работу.");
						return;
					}
					System.out.println(name + " захватил дерево и ищет...");
					node = model.findNode(root, tester);
					if(node != null)
						break;
					System.out.println("Пока узлов нет, " + name + " ждет...");
					try {
						tree.wait();
					} catch (InterruptedException e) {}
				}
				System.out.println(name + " нашел узел" + node);
				nodeName = node.toString();
				n = Integer.parseInt(nodeName);
				model.setData(node, this.name + " start with " + nodeName);
				updateTree();
			}
			System.out.println(name + " обрабатывает " + nodeName);
			n = (int) (n>47 ? 47 - Math.random()*7 : n < 20 ? 20 : n);
			fibo(n);
			System.out.println(name + " обработал " + nodeName);
			synchronized (tree) {
				model.setData(node, name + " finish with " + nodeName);
				updateTree();
				tree.notifyAll();
			}
		}
	}

}
