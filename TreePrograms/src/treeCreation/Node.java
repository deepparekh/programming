package treeCreation;

public class Node {
	private int data;
	private int hd;
	private Node leftchild;
	private Node rightchild;

	public Node(int data) {
		super();
		this.data = data;

	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public Node getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(Node leftchild) {
		this.leftchild = leftchild;
	}

	public Node getRightchild() {
		return rightchild;
	}

	public void setRightchild(Node rightchild) {
		this.rightchild = rightchild;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", hd=" + hd + ", leftchild=" + leftchild
				+ ", rightchild=" + rightchild + "]";
	}

}
