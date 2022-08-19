package ds_problems.trees;

import complexstructures.BinaryTree;

public class BasicOperations {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();
		
		bt.insertInLevelOrder(1);
		BinaryTree.inorderTraversal(bt.getRoot());
		System.out.println();
		
		bt.insertInLevelOrder(2);
		BinaryTree.inorderTraversal(bt.getRoot());
		System.out.println();
		
		bt.insertInLevelOrder(3);
		BinaryTree.inorderTraversal(bt.getRoot());
		System.out.println();
		
		bt.insertInLevelOrder(4);
		BinaryTree.inorderTraversal(bt.getRoot());
		System.out.println();
		
		bt.insertInLevelOrder(5);
		BinaryTree.inorderTraversal(bt.getRoot());
		System.out.println();
		
		bt.insertInLevelOrder(6);
		BinaryTree.inorderTraversal(bt.getRoot());
		System.out.println();
		
		bt.insertInLevelOrder(7);
		BinaryTree.inorderTraversal(bt.getRoot());
		System.out.println();
		
		bt.insertInLevelOrder(8);
		BinaryTree.inorderTraversal(bt.getRoot());
	}

}
