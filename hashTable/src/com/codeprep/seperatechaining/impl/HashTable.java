package com.codeprep.seperatechaining.impl;

public class HashTable {
	
	private SingleLinkedList [] array;
	private int m;	//size of the array
	int n;	//number of records
	
	public HashTable() {
		this(11);
	}
	
	public HashTable(int tableSize) {
		
		m = tableSize;
		array = new SingleLinkedList[tableSize];
	}
	
	int hash(int key) {
		return (key % m);
	}
	
	public void insert(StudentRecord record) {
		
		int key = record.getStudentId();
		int h = hash(key);
		
		if(array[h] == null) {
			array[h] = new SingleLinkedList();
		}
		
		array[h].insertInBegining(record);
		n++;
	}
	
	public StudentRecord search(int key) {
		
		int h = hash(key);
		if(array[h] != null) {
			return array[h].search(key);
		}
		return null;
	}
	
	public void display() {
		
		for(int i = 0; i < m; i++) {
			System.out.println("[" + i + "]");
			
			if(array[i] != null) {
				array[i].displayList();
			}else {
				System.out.println("_________");
			}
		}
	}
	
	public void delete(int key) {
		
		int h = hash(key);
		
		if(array[h] != null) {
			array[h].deleteNode(key);
			n--;
		}else {
			System.out.println("Value "+ key +"not present \n");
		}
	
	}

}
