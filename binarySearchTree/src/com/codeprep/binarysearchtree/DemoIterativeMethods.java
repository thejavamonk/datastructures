package com.codeprep.binarysearchtree;

import java.util.Scanner;

public class DemoIterativeMethods {
	
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		Scanner scanner = new Scanner(System.in);
		int choice, x;
		
		while(true) {
			System.out.println("1. Display Tree");
			System.out.println("2. Search");
			System.out.println("3. Insert a new Node");
			System.out.println("4. Delete a node");
			System.out.println("5. PreOrder Traversal");
			System.out.println("6. Inorder Traversal");
			System.out.println("7. Postorder Traversal");
			System.out.println("8. Height of tree");
			System.out.println("9. Find Minimum key");
			System.out.println("10. Find Maximum key");
			System.out.println("11. Quit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			
			if(choice == 11) {
				break;
			}
			
			switch (choice) {
			case 1:
				break;

			default:
				break;
			}
		}
	}
}
