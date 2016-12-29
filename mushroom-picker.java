/**
An exercise to learn about prefix sum
https://codility.com/media/train/3-PrefixSums.pdf
**/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] a = new int[]{2,3,7,5,1,3,9};
		int k = 4, m = 6;
		System.out.println(maxMushroom(a, k, m));
	}
	
	public static int calSum(int[] prefix, int left, int right) {
		return prefix[right] - prefix[left];
	}
	
	public static int maxMushroom(int[] a, int k, int m) {
		int[] prefix = new int[a.length];
		prefix[0] = a[0];
		for (int i = 1; i < a.length; i++) prefix[i] = prefix[i-1] + a[i];
		int res = 0;
		for (int i = 0; i < Math.min(m, k); i++) {
			int left = k - i;
			int right = Math.min(Math.max(k + m - 2*i, k), a.length-1);
			res = Math.max(res, calSum(prefix, left, right));
		}
		for (int i = 0; i < Math.min(a.length-k, m+1); i++) {
			int left = Math.max(0, Math.min(k - (m - 2*i), k));
			int right = k + i;
			res = Math.max(res, calSum(prefix, left, right));
		}
		return res;
	}
}
