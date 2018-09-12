package com.codeprep.avltree.impl;

public class AVLTree {
	
	private Node root;
	static boolean taller;
	static boolean shorter;
	
	public AVLTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return (root == null);
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
		display(p.rchild, level+1);
		System.out.println();
		
		for (i = 0; i < level; i++) {
			System.out.println("   ");
		}
		System.out.println(p.info);
		
		display(p.lchild, level + 1);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node p) {
		
		if(p == null) {
			return;
		}
		inorder(p.lchild);
		System.out.println(p.info + " ");
		inorder(p.rchild);
	}
	
	public void insert(int x) {
		
		root = insert(root, x);
	}
	
	private Node insert(Node p, int x) {
		
		if(p == null) {
			
			p = new Node(x);
			taller = true;
		}
		else if(x < p.info) {
			
			p.lchild = insert(p.lchild, x);
			if(taller == true)
				p = insertLeftSubtreeCheck(p);
		}
		else if(x > p.info) {
			
			p.rchild = insert(p.rchild, x);
			if(taller == true)
				p = insertRightSubtreeCheck(p);
		}
		else {
			System.out.println(x +" already present in tree");
			taller = false;
		}
		return p;
	}

	private Node insertRightSubtreeCheck(Node p) {
		
		switch(p.balance) {
			
		case 0:
			p.balance = -1;
			break;
		case 1:
			p.balance = 0;
			taller = false;
			break;
		case -1:
			p = insertionRightBalance(p);
			taller = false;
		}
		return p;
	}

	private Node insertionRightBalance(Node p) {
		return null;
	}

	private Node insertLeftSubtreeCheck(Node p) {
		
		switch(p.balance) {
		case 0:
			p.balance = 1;
			break;
		case -1:
			p.balance = 0;
			taller = false;
			break;
		case 1:
			p = insertionLeftBalance(p);
			taller = false;
		}
		return p;
	}

	private Node insertionLeftBalance(Node p) {

		return null;
	}
}
