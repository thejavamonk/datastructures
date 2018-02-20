package com.codeprep.queue.circularlist.impl;

import java.util.NoSuchElementException;

public class QueueCL {
	
	private Node rear;
	
	public QueueCL() {
		
		rear = null;
	}
	
	public boolean isEmpty() {
		return rear == null;
	}
	
	public void insert(int x) {
		
		Node temp = new Node(x);
		if(isEmpty()) {
			rear = temp;
			rear.link = rear;
		}
		else {
			temp.link = rear.link;
			rear.link = temp;
			rear = temp;
		}
	}
	
	public int delete() {
		
		if(isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		Node temp;
		if(rear.link == rear) { // If only one element
			
			temp = rear;
			rear = null;
		}
		else {
			temp = rear.link;
			rear.link = temp.link;
		}
		return temp.info;
	}
	
	public int peek() {
		
		if(isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		return rear.link.info;
	}
	
	public void display() {
		
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		
		System.out.println("Queue is : ");
		Node p = rear.link;
		
		do {
			System.out.println(p.info);
			p = p.link;
		}while(p != rear.link);
		System.out.println();
	}
	
	public int size() {
		
		if(isEmpty()) {
			return 0;
		}
		int s = 0;
		Node p = rear.link;
		do {
			s++;
			p = p.link;
		}while(p != rear.link);
		return s;
	}
}
