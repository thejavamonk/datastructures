package com.codeprep.stack.array.impl;

import java.util.Scanner;

public class StackUsingArrayDemo {
	
	public static void main(String[] args) {
		
		int choice, x;
		Scanner scanner = new Scanner(System.in);
		
		Stack stack = new Stack(5);
		
		while(true){
			
			System.out.println("1. Push an element on the stack");
			System.out.println("2. Pop an element from the stack");
			System.out.println("3. Display the top element");
			System.out.println("4. Display all stack elements");
			System.out.println("5. Display size of the stack");
			System.out.println("6. Quit");
			System.out.println("Enter your choice: ");
			
			choice = scanner.nextInt();
			
			if(choice == 6)
				break;
			
			switch (choice) {
			case 1:
				System.out.println("Enter elements to be pushed: ");
				x = scanner.nextInt();
				stack.push(x);
				break;
			
			case 2:
				x = stack.pop();
				System.out.println("Popped element: "+x);
				break;
			case 3:
				System.out.println("Element at the top is : "+stack.peek());
				break;
			case 4:
				stack.display();
				break;
			case 5:
				System.out.println("Size of stack "+stack.size());
				break;
			default:
				System.out.println("Unsupported operation");
				break;
			}
		}
		scanner.close();
	}
}
