/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ResizeableStack<Item> implements Iterable<Item>
{
	Item[] arr = (Item[]) new Object[1];
	int N = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
		// Implement a stack using array
	}
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) 
			temp[i] = arr[i];
		arr = temp;
	}
	private void push(Item item) {
		if (N == arr.length) resize(N*2);
		arr[N++] = item;
	}
	private Item pop() {
		Item res = arr[--N];
		arr[N] = null;
		if (N > 0 && N == arr.length / 4) resize(arr.length / 2);
		return res;
	}
	public Iterator<Item> iterator() {
		return new ResizeableStackIterator();
	}
	private class ResizeableStackIterator<Item> implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() {return i < N; }
		public Item next() {return arr[--i];}
		public void remove() {}
	}
	
}
