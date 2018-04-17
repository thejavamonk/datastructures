package com.codeprep.binarytree.impl;

public class BinaryTree {

	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void display() {
		
		display(root, 0);
		System.out.println();
	}

	private void display(Node p, int level) {
		
		int i;
		if(p == null) {
			return;
		}
		display(p.rChild, level++);
		System.out.println();
		
		for(i = 0; i < level; i++) {
			System.out.println("  ");
		}
		System.out.println(p.info);
		display(p.lChild, level++);
	}
	
	public void preorder() {
		
		preorder(root);
		System.out.println();
	}

	private void preorder(Node p) {
		
		if(p == null) {
			return;
		}
		System.out.println(p.info + " ");
		preorder(p.lChild);
		preorder(p.rChild);
	}
	
	public void inorder() {
		
		inorder(root);
		System.out.println();
	}

	private void inorder(Node p) {
		
		if(p == null) {
			return;
		}
		inorder(p.lChild);
		System.out.println(p.info + " ");
		inorder(p.rChild);
	}
	
	public void postorder() {
		
		postorder(root);
		System.out.println();
	}

	private void postorder(Node p) {
		
		if(p == null) {
			return;
		}
		postorder(p.lChild);
		postorder(p.rChild);
		System.out.println(p.info + " ");
	}
	
	public void levelOrder() {
		
		Node p = root;
		
		if(p == null) {
			System.out.println("Tree is empty");
			return;
		}
		QueueA queue = new QueueA(20);
		queue.insert(root);
		
		while(!queue.isEmpty()) {
			p = queue.delete();
			System.out.println(p.info);
			if(p.lChild != null) {
				queue.insert(p.lChild);
			}
			if(p.rChild != null) {
				queue.insert(p.rChild);
			}
		}
		System.out.println();
	}
	
	public int height() {
		
		return height(root);
	}

	private int height(Node p) {
		
		int hL;
		int hR;
		
		if(p == null) {
			return 0;
		}
		hL = height(p.lChild);
		hR = height(p.rChild);
		
		if(hL > hR) {
			return 1 + hL;
		}
		else {
			return 1 + hR;
		}
	}
	
	public void createTree() {
		
		root = new Node('P');
		root.lChild = new Node('Q');
		root.rChild = new Node('R');
		root.lChild.lChild = new Node('A');
		root.lChild.rChild = new Node('B');
		root.rChild.lChild = new Node('X');
	}
}
