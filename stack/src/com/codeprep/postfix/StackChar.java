package com.codeprep.postfix;

import java.util.EmptyStackException;

public class StackChar {
	
	private char [] stackArray;
	private int top;
	
	public StackChar() {
		
		stackArray = new char[10];
		top = -1;
	}
	
	public StackChar(int maxSize) {
		
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public int size(){
		return top + 1;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == stackArray.length -1);
	}
	
	public void push(char x){
		
		if(isFull()){
			System.out.println("Stack Overflow");
			return;
		}
		top = top + 1;
		stackArray[top] = x;
	}
	
	public char pop(){
		
		char x;
		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		x = stackArray[top];
		top = top -1;
		return x;
	}
	
	public char peek(){
		
		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		return stackArray[top];
	}
	
	public void display(){
		
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Stack is");
		for (int i = top; i >= 0; i--) {
			System.out.println(stackArray[i]);
			System.out.println(" ");
		}
	}
}
