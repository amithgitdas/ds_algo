package com.practice.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

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

	public static SingleLinkedList createDataWithLoop(SingleLinkedList linkedList, int data) {
		Node temp = null;
		Node loopNode = null;
		int vcnt = 0;
		if (linkedList.headNode == null) {
			linkedList.headNode = new Node(data);
			vcnt++;
		} else {
			temp = linkedList.headNode;
			while (temp.next != null) {
				temp = temp.next;
				vcnt++;
				if (vcnt == 3) {
					loopNode = temp;
				}
			}
			temp.next = new Node(data);
		}
		if (data == 7) {
			temp.next.next = loopNode;
		}

		return linkedList;

	}

	// Detect loop in the linkedlist
	public static void detectLoopInTheLinkedList(SingleLinkedList linkedList) {

		Node startingNode = linkedList.headNode;
		Map<Node, Integer> nodeCnt = new LinkedHashMap<SingleLinkedList.Node, Integer>();
		boolean loopExists = false;
		while (startingNode != null) {
			nodeCnt.put(startingNode, 1);
			startingNode = startingNode.next;
			if (nodeCnt.containsKey(startingNode)) {
				loopExists = true;
				System.out.println(lengthOfLoop(nodeCnt, startingNode));
				break;
			}

		}
		if (loopExists) {
			System.out.println("Loop Exists");
		} else {
			System.out.println("Loop does not Exists");
		}

	}
	// Length of the loop

	public static int lengthOfLoop(Map<Node, Integer> nodeCnt, Node nextNode) {
		int cnt = 0;
		boolean falg = false;
		for (Node tempNode : nodeCnt.keySet()) {
			if (tempNode == nextNode || falg) {
				cnt++;
				falg = true;
			}
		}
		return cnt;
	}

	// to check whether list is palindrome or not (Ex : POP,AKA

	public static void palindromeCheck(SingleLinkedList linkedList) {
		int length = lengthOfLinkedListIterative(linkedList);
		int starting = 0;
		int end = length - 1;
		boolean flag = true;
		while (starting < end) {
			if (getNodeAtGivenPos(linkedList, starting) != getNodeAtGivenPos(linkedList, end)) {
				flag = false;
				break;
			}
			starting++;
			end--;
		}
		if (flag) {
			System.out.println("Given list is palindrome");
		} else {
			System.out.println("It is not an palindrome");
		}
	}

	// Remove duplicates from sorted list
	public static void removeDuplicatesInSortedList(SingleLinkedList linkedList) {
		Node temp = linkedList.headNode;
		while (temp.next != null) {
			if (temp.data == temp.next.data) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		printLinkedList(linkedList);

	}

	// Remove duplicates from unsortedlist
	public static void removeDuplicatesUnSortedList(SingleLinkedList linkedList) {
		Node temp = linkedList.headNode;
		Map<Integer, Integer> cntMap = new LinkedHashMap<>();
		cntMap.put(temp.data, 1);

		while (temp.next != null) {

			if (cntMap.containsKey(temp.next.data)) {
				temp.next = temp.next.next;
			} else {
				cntMap.put(temp.next.data, 1);
				temp = temp.next;
			}
		}
		printLinkedList(linkedList);

	}

	// Swap nodes in linkedlist with out swaping the data

	public static void swapListWithoutData(SingleLinkedList linkedList, int x, int y) {
		Node xPrevNode = null;
		Node xNextNode = null;
		Node yPrevNode = null;
		Node yNextNode = null;
		Node xCurrNode = null;
		Node yCurrNode = null;
		Node temp = linkedList.headNode;
		if (temp.data == x) {
			xCurrNode = temp;
			xNextNode = temp.next;
		}
		if (temp.data == y) {
			yCurrNode = temp;
			yNextNode = temp.next;
		}
		while (temp.next != null) {
			if (temp.next.data == x) {
				xCurrNode = temp.next;
				xNextNode = temp.next.next;
				xPrevNode = temp;
			}
			if (temp.next.data == y) {
				yCurrNode = temp.next;
				yNextNode = temp.next.next;
				yPrevNode = temp;
			}
			temp = temp.next;
		}

		if (xPrevNode == null) {
			yCurrNode.next = xNextNode;
			linkedList.headNode = yCurrNode;
			xCurrNode.next = yNextNode;
			yPrevNode.next = xCurrNode;
		} else if (yPrevNode == null) {
			xCurrNode.next = yNextNode;
			linkedList.headNode = xCurrNode;
			yCurrNode.next = xNextNode;
			xPrevNode.next = yCurrNode;
		} else {
			xCurrNode.next = yNextNode;
			yPrevNode.next = xCurrNode;
			yCurrNode.next = xNextNode;
			xPrevNode.next = yCurrNode;
		}

		printLinkedList(linkedList);

	}

	// Pairwise swappning in linkedlist

	public static void pairWiseSwapping(SingleLinkedList linkedList) {
		Node temp = linkedList.headNode;
		Node prevPrviousNode = null;
		boolean isHead = true;
		while (temp != null && temp.next != null) {
			Node prevNode = temp;
			Node curretNode = temp.next;
			Node curretTempNode = temp.next.next;
			Node nextNode = temp.next.next;
			if (isHead) {
				prevNode.next = nextNode;
				curretNode.next = prevNode;
				linkedList.headNode = curretNode;
				isHead = false;
			} else {
				prevNode.next = nextNode;
				curretNode.next = prevNode;
				prevPrviousNode.next = curretNode;
			}
			prevPrviousNode = prevNode;
			temp = curretTempNode;
		}
		printLinkedList(linkedList);
	}

	// Move last element to front
	public static void moveLastElementToFront(SingleLinkedList linkedList) {
		Node temp = linkedList.headNode;
		Node headNode = linkedList.headNode;
		Node prevNode = null;
		while (temp.next != null) {
			prevNode = temp;
			temp = temp.next;
		}
		temp.next = headNode.next;
		linkedList.headNode = temp;

		headNode.next = null;
		prevNode.next = headNode;

		printLinkedList(linkedList);
	}

	// Intersection of two linked-lists
	public static void intersecOfSortedLinkedLists(SingleLinkedList linkedList1, SingleLinkedList linkedLsit2) {
		Node firstListNode = linkedList1.headNode;
		Node secListNode = linkedLsit2.headNode;
		SingleLinkedList result = new SingleLinkedList();
		int cnt = 0;
		while (firstListNode != null && secListNode != null) {
			if (firstListNode.data == secListNode.data) {
				if (cnt == 0) {
					result.headNode = new Node(firstListNode.data);
					cnt++;
				} else {
					Node temp = result.headNode;
					while (temp.next != null) {
						temp = temp.next;
					}

					temp.next = new Node(firstListNode.data);
				}

				firstListNode = firstListNode.next;
				secListNode = secListNode.next;
			} else {
				if (firstListNode.data < secListNode.data) {
					firstListNode = firstListNode.next;
				} else {
					secListNode = secListNode.next;
				}
			}
		}

		printLinkedList(result);
	}

	//Merging point of two linkedlists
	public static int startInterSectionOfMergedLists(SingleLinkedList linkedList1, SingleLinkedList linkedLsit2) {

		Node temp = linkedList1.headNode;
		Map<Node, Node> cntMap = new LinkedHashMap<>();

		while (temp != null) {

			if (!cntMap.containsKey(temp)) {
				cntMap.put(temp, temp.next);
			}
			temp = temp.next;
		}

		Node temp2 = linkedLsit2.headNode;
		while (temp2 != null) {

			if (cntMap.containsKey(temp2)) {
				return temp2.data;
			}
			temp2 = temp2.next;
		}
		return 0;

	}

}
