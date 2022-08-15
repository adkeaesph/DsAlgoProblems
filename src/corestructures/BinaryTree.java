package corestructures;

public class BinaryTree<T> implements Tree<T> {
	private BinaryTreeNode<T> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(T data) {
		root = new BinaryTreeNode<T>(data);
	}
	
	public BinaryTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}
	
	public boolean insertInLevelOrder(T data) {
		if(root == null) {
			root = new BinaryTreeNode<T>(data);
			return true;
		}
		
		if(root.getLeft() == null) {
			root.setLeft(new BinaryTreeNode<T>(data));
			return true;
		} 
		
		if(root.getRight() == null) {
			root.setRight(new BinaryTreeNode<T>(data));
			return true;
		} 
			
		boolean inserted = false;
		BinaryTree<T> leftTree = new BinaryTree<>(root.getLeft());
		inserted = leftTree.insertInLevelOrder(data);
				
		if(inserted)
			return true;
		
		BinaryTree<T> rightTree = new BinaryTree<>(root.getRight());
		return rightTree.insertInLevelOrder(data);
	}
	
	public static<T> void inorderTraversal(BinaryTreeNode<T> root) {
		if(root.getLeft() != null)
			inorderTraversal(root.getLeft());
		if(root != null)
			System.out.print(root.getData() + " ");
		if(root.getRight() != null)
			inorderTraversal(root.getRight());
	}
	
}
