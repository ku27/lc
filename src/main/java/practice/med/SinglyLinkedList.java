package practice.med;

//Java program for reversing the linked list 

public class SinglyLinkedList { 

	static Node head; 

	static class Node { 

		int data; 
		Node next; 

		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	/* Function to reverse the linked list */
	Node reverse(Node node) { 
		Node prev = null; 
		Node current = node; 
		Node next = null; 
		while (current != null) { 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
		} 
		node = prev; 
		return node; 
	} 

	// prints content of double linked list 
	void printList(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	public static void main(String[] args) { 
		SinglyLinkedList list = new SinglyLinkedList(); 
		SinglyLinkedList.head = new Node(85); 
		SinglyLinkedList.head.next = new Node(15); 
		SinglyLinkedList.head.next.next = new Node(4); 
		SinglyLinkedList.head.next.next.next = new Node(20); 
		
		System.out.println("Given Linked list"); 
		list.printList(head); 
		head = list.reverse(head); 
		System.out.println(""); 
		System.out.println("Reversed linked list "); 
		list.printList(head); 
	} 
} 

