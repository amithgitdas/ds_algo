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
		SingleLinkedList.insertData(linkedList, 7);
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

	// Deleting at given key at given position - Geeks for Geeks 5th Prob
	public static SingleLinkedList deleteAtGivenKeyAtPosition(SingleLinkedList linkedList, int pos) {
		Node previousNode = null;
		Node temp = linkedList.headNode;
		int posCnt = 0;
		// Three scenarios will be there headNode,Middle and end
		// Head Node

		if (temp != null && pos == posCnt) {
			linkedList.headNode = temp.next;
			return linkedList;
		}
		// In the middle
		while (temp.next != null && pos != posCnt) {
			previousNode = temp;
			temp = temp.next;
			posCnt++;

		}
		if (pos == posCnt) {
			previousNode.next = temp.next;
		}
		return linkedList;

	}

	// Length of linkedlist - Geeks for Geeks 7th Prob
	public static int lengthOfLinkedListIterative(SingleLinkedList linkedList) {
		int length = 0;
		Node temp = linkedList.headNode;
		if (temp != null) {
			length++;
		}
		while (temp.next != null) {
			temp = temp.next;
			length++;
		}
		System.out.println("length of linkedlist === " + length);
		return length;
	}

	// Length of linkedlist - Geeks for Geeks 7th Prob
	public static int lengthOfLinkedListRecursive(SingleLinkedList linkedList, Node node) {
		if (node != null) {
			return lengthOfLinkedListRecursive(linkedList, node.next) + 1;
		}
		return 0;
	}

	// Searching element in linkedlist iterative -- Geeks for Geeks 8th problem
	// Write a function that searches a given key ‘x’ in a given singly linked
	// list.
	// The function should return true if x is present in linked list and false
	// otherwise.
	public static boolean searchingLinkedListIterative(SingleLinkedList linkedList, int value) {

		Node temp = linkedList.headNode;
		if (temp != null && temp.data == value) {
			return true;
		}
		while (temp.next != null && temp.data != value) {
			temp = temp.next;
		}
		if (temp != null && temp.data == value) {
			return true;
		}
		return false;

	}

	// Searching linkedlist recursive
	public static boolean searchingLinkedListRecursive(SingleLinkedList linkedList, Node node, int value) {
		if (node != null) {

			return searchingLinkedListRecursive(linkedList, node.next, value) || (node.data == value);
		}
		return false;
	}

	// Get Nth node value at any given position
	public static int getNodeAtGivenPos(SingleLinkedList linkedList, int pos) {
		Node temp = linkedList.headNode;
		int posCnt = 0;
		if (temp != null && pos == posCnt) {
			return temp.data;
		}
		while (temp.next != null && pos != posCnt) {
			temp = temp.next;
			posCnt++;

		}
		if (pos == posCnt) {
			return temp.data;
		}
		return 0;

	}

	// Get Nth Node from end of the list
	public static int getNodeAtGivenPosFromEnd(SingleLinkedList linkedList, int pos) {
		int length = lengthOfLinkedListIterative(linkedList);
		return getNodeAtGivenPos(linkedList, length - pos);

	}

	// Get Middle of linkedlist normal way
	public static int getMiddleOfLinkedListNormal(SingleLinkedList linkedList) {
		int length = lengthOfLinkedListIterative(linkedList);
		return getNodeAtGivenPos(linkedList, length / 2);
	}

	// Get Middle of linkedlist easyway
	public static int getMiddleOfLinkedListEasy(SingleLinkedList linkedList) {
		Node oneStep = linkedList.headNode;
		Node twoStep = linkedList.headNode;
		while (oneStep.next != null && twoStep.next != null && twoStep.next.next != null) {
			oneStep = oneStep.next;
			twoStep = twoStep.next.next;
		}
		if (oneStep.next != null && twoStep.next != null && twoStep.next.next == null) {
			oneStep = oneStep.next;
		}

		return oneStep.data;
	}

	// Get the number of times value occured in a list

	public static int countNumberOfTimesIntOccured(SingleLinkedList linkedList, Node node, int val) {
		if (node != null) {
			return countNumberOfTimesIntOccured(linkedList, node.next, val) + ((node.data == val) ? 1 : 0);
		}
		return 0;

	}

}
