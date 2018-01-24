package com.codeprep.stack.linkedlist.impl;

import java.util.EmptyStackException;

public class Stack {
	
	private Node top;
	
	public Stack(){
		
		top = null;
	}
	
	public int size(){
		
		int s = 0;
		Node p = top;
		while(p != null){
			p = p.link;
			s++;
		}
		return s;
	}
	
	public void push(int x){
		
		Node temp = new Node(x);
		temp.link = top;
		top = temp;
	}
	
	public int pop(){
		
		int x;
		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		x = top.info;
		top = top.link;
		return x;
	}
	
	public int peek(){
		
		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		return top.info;
	}
	
	public boolean isEmpty(){
		
		return (top == null);
	}
	
	public void display(){
		
		Node p = top;
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Stack is: ");
		while(p != null){
			
			System.out.println(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}
}
