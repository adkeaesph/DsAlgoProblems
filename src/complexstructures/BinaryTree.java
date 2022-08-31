package complexstructures;

import java.util.LinkedList;
import java.util.Queue;

import corestructures.BinaryTreeNode;

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
	
	public void insertInLevelOrder(T data) {
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(data); 
		if(root == null) {
			root = newNode;
			return;
		}
		
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode<T> tempNode;
		while(!queue.isEmpty()) {
			tempNode = queue.peek();
			queue.remove();
			
			if(tempNode.getLeft() == null) {
				tempNode.setLeft(newNode);
				break;
			} else 
				queue.add(tempNode.getLeft());
			
			if(tempNode.getRight() == null) {
				tempNode.setRight(newNode);
				break;
			} else 
				queue.add(tempNode.getRight());
		}
	}
	
	public static<T> void inorderTraversal(BinaryTreeNode<T> root) {
		if(root == null)
			return;
		inorderTraversal(root.getLeft());
		System.out.print(root.getData() + " ");
		inorderTraversal(root.getRight());
	}
	
	public static<T> void preorderTraversal(BinaryTreeNode<T> root) {
		if(root == null)
			return;
		
		System.out.print(root.getData() + " ");
		preorderTraversal(root.getLeft());
		preorderTraversal(root.getRight());
	}

	public static<T> void postorderTraversal(BinaryTreeNode<T> root) {
		if(root == null)
			return;
		
		postorderTraversal(root.getLeft());
		postorderTraversal(root.getRight());
		System.out.print(root.getData() + " ");
	}
}
