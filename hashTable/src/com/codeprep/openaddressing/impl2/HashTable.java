package com.codeprep.openaddressing.impl2;

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
	
	public void insertRehashed(StudentRecord record) {
		
		if(n >= m/2) {
			// doubles the size of the hash table and size should be a prime number
			rehash(nextPrime(2 * m));
			System.out.println("New Table size is: "+m);
		}
		insert(record);
	}
	
	private int nextPrime(int x) {
		
		while(!isPrime(x)) {
			x++;
		}
		return x;
	}
	
	private void rehash(int newSize) {
		
		HashTable temp = new HashTable(newSize);
		
		for(int i = 0; i < m; i++) {
			if(array[i] != null && array[i].getStudentId() != -1) {
				temp.insert(array[i]);
			}
		}
		array = temp.array;
		m = newSize;
	}
	
	private boolean isPrime(int x) {
		
		for(int i = 2; i < x; i++) {
			if(x % i == 0) {
				return false;
			}
		}
		return true;
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
	
	public void delete(int key) {
		
		int h = hash(key);
		int location = h;
		
		for(int i = 1; i < m; i++) {
			if(array[location] == null) {
				return;
			}
			if(array[location].getStudentId() == key) {
				array[location].setStudentId(-1);
				n--;
				
				if(n > 0 && n <= m/8) {
					rehash(nextPrime(m/2));
					System.out.println("New table size is: "+m);
				}
			}
			location = (h + i) % m;
		}
	}

}
