package com.codeprep.avltree.impl;

import java.util.Scanner;

public class DemoAvlTree {

	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();
		int choice, x;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Display Tree");
			System.out.println("2. Insert a new node");
			System.out.println("3. Delete a node");
			System.out.println("4. Delete a node");
			System.out.println("5. Quit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			
			if(choice == 5) {
				break;
			}
			
			switch(choice) {
				
			case 1:
				tree.display();
				break;
			case 2:
				System.out.println("Enter the key to be inserted: ");
				x = scanner.nextInt();
				tree.insert(x);
				break;
			case 3:
				System.out.println("Enter the key to be deleted: ");
				x = scanner.nextInt();
				break;
			case 4:
				tree.inorder();
				break;
			default:
				break;
			}
		}
		scanner.close();
	}
}
