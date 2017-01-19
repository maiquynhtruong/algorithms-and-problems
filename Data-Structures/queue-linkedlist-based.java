/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class QueueLinkedList<Item> implements Iterable<Item>
{
	int N = 0; // number of items
	class Node {
		Node next;
		Item item;
		Node(Item item) {
			this.item = item;
		}
	}
	Node first = null, last = null;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
	public int size() {
		return N;
	}
	/**
	 * Add item to end of list*/
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node(item);
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	public Item dequeue() {
		Item res = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return res;
	}
	public boolean isEmpty() {
		return N == 0;
		// return first == null; // either way
	}
}
