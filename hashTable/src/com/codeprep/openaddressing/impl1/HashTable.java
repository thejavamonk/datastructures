package com.codeprep.openaddressing.impl1;

public class HashTable {
	
	private StudentRecord [] array;
	private int m;	//size of the array
	int n;	//number of records
	
	public HashTable() {
		this(11);
	}
	
	public HashTable(int tableSize) {
		
		m = tableSize;
		array = new StudentRecord[m];
		n = 0;
	}
	
	int hash(int key) {
		return (key % m);
	}
	
	/**
	 * Insert. Implemented using linear probing
	 *
	 * @param record the record
	 */
	public void insert(StudentRecord record) {
		
		int key = record.getStudentId();
		int h = hash(key);
		int location = h;
		
		for(int i=1; i<m; i++) {
			if(array[location] == null || array[location].getStudentId() == -1) {
				
				array[location] = record;
				n++;
				return;
			}
			
			if(array[location].getStudentId() == key) {
				throw new UnsupportedOperationException("Duplicate Key");
			}
			
			location = (h+i)%m;
		}
		System.out.println("Table os full : record can't be inserted");
	}
	
	/**
	 * Search. Implemented using liner probing
	 *
	 * @param key the key
	 * @return the student record
	 */
	public StudentRecord search(int key) {
		
		int h = hash(key);
		int location = h;
		
		for(int i=1; i<m; i++) {
			
			if(array[location] == null) {
				return null;
			}
			if(array[location].getStudentId() == key) {
				return array[location];
			}
			location = (h+i)%m;
		}
		return null;
	}
	
	public void display() {
		
		for(int i = 0; i < m; i++) {
			System.out.println("[" + i + "]");
			
			if(array[i] != null && array[i].getStudentId() != -1) {
				System.out.println(array[i]);
			}else {
				System.out.println("_________");
			}
		}
	}
	
	public StudentRecord delete(int key) {
		
		int h = hash(key);
		int location = h;
		
		for(int i = 1; i < m; i++) {
			if(array[location] == null) {
				return null;
			}
			if(array[location].getStudentId() == key) {
				StudentRecord temp = array[location];
				array[location].setStudentId(-1);
				n--;
				return temp;
			}
			location = (h + i) % m;
		}
		return null;
	}

}
