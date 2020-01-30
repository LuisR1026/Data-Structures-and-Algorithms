
public class BinarySearchTree {
	Node root;
	public BinarySearchTree(){
		root = null;
	}
	
	public BinarySearchTree(Object[] data) {
		root = null;
		for(int i = 0; i < data.length; i++) {
			insert(data[i]);
		}
	}
	
	public void insert(Object e) {
		if ( root == null) {
			root = new Node(e);	
		}
		else {
			Node parNode = null;
			Node curNode = root;
			while( true ) {
				parNode = curNode;
				if ((e instanceof Integer && (Integer)(e) < (Integer)(curNode.val)) 
						|| e instanceof String && (((String)(e)).compareToIgnoreCase((String)(curNode.val)) < 0)) {
					curNode = curNode.leftChild;
				
					if( curNode == null) {
						parNode.leftChild = new Node(e);
						return;
					}	
				}
				else {
					curNode = curNode.rightChild;
					if( curNode == null) {
						parNode.rightChild = new Node(e);
						return;
					}	
				}
			}
		}	
	}
	
	public Node delete(Object e) {
		Node tmp;
		Node n;
		Node c = root;
		Node p = null;
		while(e instanceof Integer && (c != null && (Integer)(c.val) != (Integer)e) 
				|| e instanceof String && (c != null && ((String)(c.val)).compareToIgnoreCase((String)(e)) != 0)) {
			p = c;
			if ((e instanceof Integer && (Integer)(c.val) < (Integer)e) ||
					(e instanceof String && ((String)(c.val)).compareToIgnoreCase((String)(e)) < 0) ) {
				c = c.rightChild;
			}
			else {
				c = c.leftChild;
			}
		}
		n = c;
		if (e instanceof Integer && (c != null && (Integer)(c.val) == (Integer)e) ||
				e instanceof String && (c != null && ((String)(c.val)).compareToIgnoreCase((String)(e)) == 0)) {
			if (n.rightChild == null) {
				n = n.leftChild;
			}
			else if (n.leftChild == null) {
				n = n.rightChild;
			}
			else {
				tmp = n.leftChild;
				while (tmp.rightChild != null) {
					tmp = tmp.rightChild;
				}
				tmp.rightChild = n.rightChild;
				n = n.leftChild;
			}
			if (c == root) {
				root = n;
			}
			else if (p.leftChild == c) {
				p.leftChild = n;
			}
			else {
				p.rightChild = n;
			}
		}
		else {
			throw new NullPointerException("Element not found.");
		}
		return null;
	}
	
	public Node find(Object e) {
		Node curNode = root;
		if (e instanceof Integer) {
			while((Integer)(curNode.val) != (Integer)(e)) {
				if( (Integer)(e) < (Integer)(curNode.val)) {
					curNode = curNode.leftChild;
				}
				else {
					curNode = curNode.rightChild;
				}
			
				if (curNode == null) {
					return null;
				}
			}	
		}
		else if (e instanceof String) {
			while(((String)(curNode.val)).compareToIgnoreCase((String)(e)) != 0) {
				if( ((String)(e)).compareToIgnoreCase((String)(curNode.val)) < 0 ) {
					curNode = curNode.leftChild;
				}
				else {
					curNode = curNode.rightChild;
				}
			
				if (curNode == null) {
					return null;
				}
			}
		}		
		return curNode;
	}
	
	public Node findMin() {
		return findMin(root);
	}
	
	private Node findMin(Node curNode) {
		if (curNode.leftChild != null) {
			return findMin(curNode.leftChild);
		}
		else {
			return curNode;
		}
	}
	
	public Node findMax() {
		return findMax(root);
	}
	
	private Node findMax(Node curNode) {
		if (curNode.rightChild != null) {
			return findMax(curNode.rightChild);
		}
		else {
			return curNode;
		}
	}
	
	public void printInorder() {
		printInorder(root);
	}
	
	private void printInorder(Node curNode) {
		if(curNode != null) {
			printInorder(curNode.leftChild);
			System.out.println(curNode.toString());
			printInorder(curNode.rightChild);
		}	
	}
	
	public void printPreorder() {
		printPreorder(root);
	}
	private void printPreorder(Node curNode) {
		if(curNode != null) {
			System.out.println(curNode.toString());
			printPreorder(curNode.leftChild);
			printPreorder(curNode.rightChild);
		}
	}
	public void printPostorder() {
		printPostorder(root);
	}
	private void printPostorder(Node curNode) {
		if(curNode != null) {
			printPostorder(curNode.leftChild);
			printPostorder(curNode.rightChild);
			System.out.println(curNode.toString());
		}
	}
}
