package com.practice.linkedlist;

public class SingleLinkedList {

	Node headNode = null;

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		SingleLinkedList.insertData(linkedList, 1);
		SingleLinkedList.insertData(linkedList, 2);
		SingleLinkedList.insertData(linkedList, 3);
		SingleLinkedList.insertData(linkedList, 4);
		SingleLinkedList.insertData(linkedList, 5);
		SingleLinkedList.insertData(linkedList, 6);
		SingleLinkedList.deleteAtGivenKey(linkedList, 6);
		SingleLinkedList.printLinkedList(linkedList);

	}

	// Node creation for linkedlist
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Inserting data to linkedlist
	// Deleting at given key - Geeks for Geeks 3rd Prob
	public static SingleLinkedList insertData(SingleLinkedList linkedList, int data) {
		Node temp = null;
		if (linkedList.headNode == null) {
			linkedList.headNode = new Node(data);
		} else {
			temp = linkedList.headNode;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}

		return linkedList;

	}

	// printing linkedlist
	public static void printLinkedList(SingleLinkedList linkedList) {
		Node temp = linkedList.headNode;
		while (temp.next != null) {
			System.out.print(temp.data + "--");
			temp = temp.next;
		}
		System.out.print(temp.data);
	}

	// Deleting at given key - Geeks for Geeks 4th Prob
	public static SingleLinkedList deleteAtGivenKey(SingleLinkedList linkedList, int key) {
		Node previousNode = null;
		Node temp = linkedList.headNode;
		// Three scenarios will be there headNode,Middle and end
		// Head Node

		if (temp != null && temp.data == key) {
			linkedList.headNode = temp.next;
			return linkedList;
		}
		// In the middle
		while (temp.next != null && temp.data != key) {
			previousNode = temp;
			temp = temp.next;

		}
		if (temp.data == key) {
			previousNode.next = temp.next;
		}
		return linkedList;

	}

}
