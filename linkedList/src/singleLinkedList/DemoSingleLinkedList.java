package singleLinkedList;

import java.util.Scanner;

public class DemoSingleLinkedList {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		int choice, data;
		
		scanner = new Scanner(System.in);
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.createList();
		
		while(true){
			System.out.println("1. Display List");
			System.out.println("2. Count the number of nodes");
			System.out.println("3. Search for an element");
			System.out.println("4. Insert in empty list/Insert at the begining of the list");
			System.out.println("5. Insert a node at the end of the list");
			System.out.println("6. Insert a node after a specified node");
			System.out.println("7. Insert a node befor a specified node");
			System.out.println("8. Insert a node at a given position");
			System.out.println("9. Delete first node");
			System.out.println("10. Delete last node");
			System.out.println("11. Delete any node");
			System.out.println("12. Reverse the list");
			System.out.println("13. Bubble sort by exchanging data");
			System.out.println("14. Bubble sort by exchanging links");
			System.out.println("15. Merge sort");
			System.out.println("16. Insert Cycle");
			System.out.println("17. Detect Cycle");
			System.out.println("18. Remove Cycle");
			System.out.println("19. Quit");
			
			System.out.println("Enter your choice :");
			choice = scanner.nextInt();
			
			if(choice == 19){
				break;
			}
			
			switch(choice){
				
			case 1:
				linkedList.displayList();
				break;
			case 2:
				linkedList.countNodes();
			case 3:
				System.out.println("Enter the element to be searched : ");
				data = scanner.nextInt();
				linkedList.search(data);
			case 4:
				System.out.println("Enter the element to be inserted : ");
				data = scanner.nextInt();
				linkedList.insertInBegining(data);
			case 5:
				System.out.println("Enter the element to be inserted");
				data = scanner.nextInt();
				linkedList.insertAtEnd(data);
			default:
				System.out.println("No match found for the choice");
				break;
			}
		}
	}

}
