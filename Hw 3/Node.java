
public class Node {
	Object val; 
	Node leftChild;
	Node rightChild;
	
	public Node(Object val) {
		this.val = val;
		this.leftChild = null;
		this.rightChild = null;
	}
		
	public void setLeftChild(Node leftChild ) {
		this.leftChild = leftChild;
	}
	public void setRightChild(Node rightChild ) {
		this.rightChild = rightChild;
	}
	public void setVal(Object val ) {
		this.val = val;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	public Object getVal() {
		return val;
	}
	public String toString() {
		if (val instanceof Integer) {
			return ""+(Integer)val;
		}
		else if (val instanceof String) {
			return (String)val;
		}
		else {
			return "";
		}
	}
	
}
