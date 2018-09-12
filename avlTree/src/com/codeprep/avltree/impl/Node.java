package com.codeprep.avltree.impl;

public class Node {
	
	Node lchild;
	int info;
	Node rchild;
	int balance;
	
	public Node(int i) {
		
		info = i;
		balance = 0;
		lchild = null;
		rchild = null;
	}
}
