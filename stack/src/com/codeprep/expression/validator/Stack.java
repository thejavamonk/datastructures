package com.codeprep.expression.validator;

import java.util.EmptyStackException;

public class Stack {
	
	private char[] stackArray;
	private int top;
	
	public Stack(){
		stackArray = new char[10];
		top = -1;
	}
	
	public Stack(int maxSize){
		
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
	
	public int peek(){
		
		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		return stackArray[top];
	}
	
	public void display(){
		
		int i;
		
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Stack is");
		for (i = top; i >= 0; i--) {
			System.out.println(stackArray[i]);
			System.out.println(" ");
		}
	}
}
