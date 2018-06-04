package com.codeprep.binarysearchtree;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public boolean searchIterative(int x) {
		
		Node p = root;
		while(p != null) {
			
			if(x < p.info) { 	// Move to left child
				p = p.lchild;
			}
			else if(x > p.info) {  // Move to right child
				p = p.rchild;
			}
			else {		// x found
				return true;
			}
		}
		return false;
	}
	
	public boolean search(int x) {
		return (searchRecursive(root, x) != null);
	}
	
	private Node searchRecursive(Node p, int x) {
		
		if(p == null) {
			return null;	// Key is not found
		}
		if(x < p.info) {	// Search in left subtree
			return searchRecursive(p.lchild, x);
		}
		if(x > p.info) {	// Search in right subtree
			return searchRecursive(p.rchild, x);
		}
		return p;	// key is found
	}
	
	public int minimumIterative() {
		if(isEmpty()) {
			throw new NullPointerException("Tree is empty!");
		}
		Node p = root;
		while(p.lchild != null) {
			p = p.lchild;
		}
		return p.info;
	}
	
	public int maxIterative() {
		if(isEmpty()) {
			throw new NullPointerException("Tree is empty");
		}
		Node p = root;
		while(p.rchild != null) {
			p = p.rchild;
		}
		return p.info;
	}
	
	public int min() {
		
		if(isEmpty()) {
			throw new NullPointerException("Tree is empty");
		}
		return minRecursive(root).info;
	}

	private Node minRecursive(Node p) {
		
		if(p.lchild == null) {
			return p;
		}
		return minRecursive(p.lchild);
	}
	
	public int maxRecursive() {
		if(isEmpty()) {
			throw new NullPointerException("Tree is empty");
		}
		return maxRecursive(root).info;
	}

	private Node maxRecursive(Node p) {
		if(p.rchild == null) {
			return p;
		}
		return maxRecursive(p.rchild);
	}
	
	public void insertIterative(int x) {
		
		Node p = root;
		Node parentNode = null;
		
		while(p != null){
			parentNode = p;
			if(x < p.info) {
				p = p.lchild;
			}
			else if(x > p.info) {
				p = p.rchild;
			}
			else {
				System.out.println(x + "already present in the tree");
				return;
			}
		}
		
		Node temp = new Node(x);
		if(parentNode == null) {
			root = temp;
		}
		else if(x < parentNode.info) {
			parentNode.lchild = temp;
		}
		else
		{
			parentNode.rchild = temp;
		}
	}
	
	public void insert(int x) {
		root = insertRecursive(root, x);
	}

	private Node insertRecursive(Node p, int x) {
		if(p == null) {
			p = new Node(x);
		}
		else if(x < p.info) {
			p.lchild = insertRecursive(p.lchild, x);
		}
		else if(x > p.info) {
			p.rchild = insertRecursive(p.rchild, x);
		}
		else {
			System.out.println(x + "already present in the tree");
		}
		return p;
	}
	
	public void deleteIterative(int x) {
		
		Node p = root;
		Node parent = null;
		
		while(p != null) {
			
			if(x == p.info) {
				break;
			}
			parent = p;
			if(x < p.info) {
				p = p.lchild;
			}
			else {
				p = p.rchild;
			}
		}
		
		if(p == null) {
			System.out.println(x + "not found");
			return;
		}
		
		// Case C: 2 children
		// Find inorder successor and its parent
		
		Node s, ps;
		
		if(p.lchild != null && p.rchild != null) {
			
			ps = p;
			s = p.rchild;
			while(s.lchild != null) {
				
				ps = s;
				s = s.lchild;
			}
			p.info = s.info;
			p = s;
			parent = ps;
		}
		
		// Case B and case A: or no child
		Node ch;
		if(p.lchild != null) {
			ch = p.lchild;
		}
		else {
			ch = p.rchild;
		}
		
		if(parent == null) {
			root = ch;
		}
		else if(p == parent.lchild) {
			parent.lchild = ch;
		}
		else {
			parent.rchild = ch;
		}
	}
	
	public void deleteRecursive(int x) {
		
		root = delete(root, x);
	}

	private Node delete(Node p, int x) {
		
		Node ch, s;
		
		if(p == null) {
			System.out.println(x + "not found");
			return p;
		}
		if(x < p.info) {
			p.lchild = delete(p.lchild, x);
		}
		else if(x > p.info) {
			p.rchild = delete(p.rchild, x);
		}
		else {
			
			if(p.lchild != null && p.rchild != null) {
				
				s = p.rchild;
				while(s.lchild != null) {
					s = s.lchild;
				}
					p.info = s.info;
					p.rchild = delete(p.rchild, s.info);
			}
			else {
				
				if(p.lchild != null) {
					ch = p.lchild;
				}
				else {
					ch = p.rchild;
				}
				p = ch;
			}
		}
		return null;
	}
}
