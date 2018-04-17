package com.codeprep.binarytree.impl;

public class DemoBinaryTree {
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createTree();
		
		binaryTree.display();
		System.out.println();
		
		System.out.println("PreOrder: ");
		binaryTree.preorder();
		System.out.println("");
		
		System.out.println("Inorder: ");
		binaryTree.inorder();
		System.out.println("");
		
		System.out.println("PostOrder: ");
		binaryTree.postorder();
		System.out.println();
		
		System.out.println("Level order: ");
		binaryTree.levelOrder();
		System.out.println();
		
		System.out.println("Height of the tree is: "+binaryTree.height());
	}
}
