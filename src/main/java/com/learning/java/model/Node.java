package com.learning.java.model;

public class Node {

	public int val;
	public Node next;
	
	public Node(int val) {
		super();
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node node) {
		this.next = node;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", node=" + next + "]";
	}

}
