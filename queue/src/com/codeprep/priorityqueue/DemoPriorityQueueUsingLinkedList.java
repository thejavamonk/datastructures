package com.codeprep.priorityqueue;

import java.util.Scanner;

public class DemoPriorityQueueUsingLinkedList {
	
	public static void main(String[] args) {
		
		int choice, element, elementPriority;
		Scanner scanner = new Scanner(System.in);
		
		PriorityQueueL queueL = new PriorityQueueL();
		
		while(true) {
			
			System.out.println("1. Insert a new element");
			System.out.println("2. Delete an element");
			System.out.println("3. Display the queue");
			System.out.println("4. Quit");
			System.out.println("Enter your choice : ");
			choice = scanner.nextInt();
			
			if(choice >= 4) {
				break;
			}
			
			switch (choice) {
			case 1:
				System.out.println("Enter the element to be inserted : ");
				element = scanner.nextInt();
				System.out.println("Enter its priority");
				elementPriority = scanner.nextInt();
				queueL.insert(element, elementPriority);
				break;
			case 2:
				System.out.println("Deleted element is "+ queueL.delete());
				break;
			case 3:
				queueL.display();
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
		scanner.close();
	}
}
