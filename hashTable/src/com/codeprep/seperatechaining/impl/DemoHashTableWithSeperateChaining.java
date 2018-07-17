package com.codeprep.seperatechaining.impl;

import java.util.Scanner;

public class DemoHashTableWithSeperateChaining {
	
	public static void main(String[] args) {
		
		int id, choice;
		String name;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter initial size of the table: ");
		int size = scan.nextInt();
		
		HashTable hashTable = new HashTable(size);
		
		while(true) {
			System.out.println("1. Insert a record");
			System.out.println("2. Search a record");
			System.out.println("3. Delete a record");
			System.out.println("4. Display table");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("Enter your choice: ");
			
			choice = scan.nextInt();
			
			if(choice == 5) {
				break;
			}
			
			switch (choice) {
			case 1:
				
				System.out.println("Enter student id: ");
				id = scan.nextInt();
				System.out.println("Enter student name: ");
				name = scan.next();
				StudentRecord record = new StudentRecord(id, name);
				hashTable.insert(record);
				break;
			case 2:
				
				System.out.println("Enter a key to be searched: ");
				StudentRecord result;
				id = scan.nextInt();
				result = hashTable.search(id);
				if(result == null) {
					System.out.println("Key not found!");
				} else {
					System.out.println(result);
				}
				break;
			case 3:
				
				System.out.println("Enter a key to be deleted: ");
				id = scan.nextInt();
				hashTable.delete(id);
				break;
			case 4:
				hashTable.display();
				break;
			default:
				break;
			}
		}
		scan.close();
	}
}
