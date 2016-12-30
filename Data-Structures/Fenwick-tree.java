/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Fenwick f = new Fenwick();
		int[] a = new int[];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			f.update(i, a[i]);
		}
		System.out.println("sum of first 10 elements: " + f.query(10));
		System.out.println("sum of elements from 2 to 7: " + f.query(7) - f.query(2-1));
	}
	
	class Fenwick{
		int N;
		int[] BIT;
		public Fenwick(int n) {
			N = n;
			BIT = new int[N];
		}
		
		/** 
		 * Add val to x and other sums that include x
		 * O(logN)
		 **/
		void update(int x, int val) {
			for (; x <= N; x += x&-x) {
				BIT[x] += val;
			}
		}
		/**
		 * Query the sum of x elements
		 * O(logN)
		 **/
		int query(int x) {
			int sum = 0;
			for (; x > 0; x -= x&-x) {
				sum += BIT[x];
			}
			return sum;
		}
	}
}
