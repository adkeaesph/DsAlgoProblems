package complexstructures;

import corestructures.NaryTreeNode;

public class NaryTree<T> implements Tree<T> {
	private NaryTreeNode<T> root;
	
	public NaryTree() {
		root = null;
	}
	
	public NaryTree(T data) {
		root = new NaryTreeNode<T>(data);
	}
	
	public NaryTree(NaryTreeNode<T> root) {
		this.root = root;
	}

	public NaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(NaryTreeNode<T> root) {
		this.root = root;
	}
}
