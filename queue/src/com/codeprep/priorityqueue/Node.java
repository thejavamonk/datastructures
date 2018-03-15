package com.codeprep.priorityqueue;

public class Node {

	public int info;
	public int priority;
	public Node link;

	public Node(int element, int elementPriority) {
		this.info = element;
		this.priority = elementPriority;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

}
