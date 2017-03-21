package singleLinkedList;

import java.util.Scanner;

public class DemoSingleLinkedList {

	public static void main(String[] args) {
		
		int choice, data, k, x;
		
		Scanner scanner = new Scanner(System.in);
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.createList();
		
		while(true){
			System.out.println("1. Display List");
			
			System.out.println("Enter your choice :");
			choice = scanner.nextInt();
			
			if(choice == 2){
				break;
			}
			
			switch(choice){
				
			case 1:
				linkedList.displayList();
				break;
			default:
				System.out.println("No match found for the choice");
				break;
			}
		}
	}

}
