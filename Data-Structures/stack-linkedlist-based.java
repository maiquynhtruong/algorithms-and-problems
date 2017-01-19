/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Stack<Item> implements Iterable<Item>
{
	private Node head;
	private int N;
	class Node {
		Item item;
		Node next;
		public Node(Item item) {this.item = item;}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
	public void push(Item item) {
		Node temp = new Node(item);
		temp.next = head;
		head = temp;
		N++;
	}
	public Item pop() {
		N--;
		Item res = head.item;
		head = head.next;
		return res;
	}
	private class StackIterator<Item> implements Iterator {
		int i = N;
		Node cur = head;
		public boolean hasNext() {return i < N; }
		public Item next() {
			i++;
			Item res = cur.item;
			cur = cur.next;
			return res;
		}
		public void remove() {}
	}
}
