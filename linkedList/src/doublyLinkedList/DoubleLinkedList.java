package doublyLinkedList;

public class DoubleLinkedList {

	private Node start;

	public DoubleLinkedList() {
		this.start = null;
	}

	public void displayList() {

		Node p;
		if (start == null) {
			System.out.println("List is empty");
			return;
		}

		p = start;
		System.out.println("List is :\n");
		while (p != null) {
			System.out.println(p.info);
			p = p.next;
		}
		System.out.println();
	}

}
