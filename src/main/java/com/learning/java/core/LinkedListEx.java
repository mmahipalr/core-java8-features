package com.learning.java.core;

import com.learning.java.model.Node;

public class LinkedListEx {
	
	private Node head;
	
	private Node last;
	
	public Node add(int val) {
		Node node = new Node(val);
		if(head == null) {
			head = node;
		} else {
			last.setNext(node);
		}
		last = node;
		return node;
	}

	
	public boolean contains(int val) {
		if(head != null) {
			Node temp = head;
			while(temp != null) {
				if(temp.getVal() == val) {
					return true;
				}
				temp = temp.getNext();
			}
		}
		
		return false;
	}
	
	public Node reverse() {
		Node previous = null;
		Node temp = head;
		Node next = null;
		if(head != null) {
			while(temp != null) {  // 1,5, 8
				next = temp.getNext(); //null
				temp.setNext(previous); //8-> 5-> 1
				previous = temp; // 5
				temp = next;  //null
			}
			head = previous;
		}
		return head;
	}
	
	public Node reverse(Node node) {
		//Node temp = node;
		System.out.println("reverse node");
		if(node == null || node.getNext() == null) {
			return node;
		}
		
		System.out.println("node "+node);
		Node r = reverse(node.getNext());
		System.out.println("r "+r);
		System.out.println("node2 "+node);
		node.next.next = node;
		node.next = null;
		System.out.println("node3 "+node);
		System.out.println("r2 "+r);
		return r;
	}
	
	
	
	
	public Node reverse(Node node, Node previous, Node next) {
		Node temp = node;
		if(temp != null) {
			next = temp.getNext(); //null
			temp.setNext(previous); //8-> 5-> 1
			previous = temp; // 5
			temp = next;  //null
			node = temp;
			return reverse(node, previous, next);
		} else {
			return previous;
		}
	}
	
	
	public boolean isCyclic(){ 
		Node fast = head; 
		Node slow = head; 
		
		while(fast!= null && fast.next != null){ 
			fast = fast.next.next; slow = slow.next;
			//if fast and slow pointers are meeting then LinkedList is cyclic 
			if(fast == slow ){
				return true; 
			} 
		} 
	return false; 
	}
		
	public static void main(String[] args) {
		LinkedListEx linkedList = new LinkedListEx();
		linkedList.add(1);
		linkedList.add(5);
		linkedList.add(8);
		linkedList.add(9);
		linkedList.add(10);
		
	//	1 -> 5 -> 8 ->9 -> 1 
		
		
		//  1, 0, 5, 0, 6, 0
		
		System.out.println(linkedList.head);
		
		System.out.println(linkedList.contains(4));
		
		System.out.println(linkedList.reverse());
		
		System.out.println(linkedList.reverse(linkedList.head));
		
	//	System.out.println(linkedList.reverse(linkedList.head, null, null));
		
		Node node = new Node(7);
		Node node1 = new Node(8);
		Node node2 = new Node(9);
		node.next = node1;
		node1.next = node;
		node.next = null;
		System.out.println(node+" "+node1);
		
		
		
	}
}
