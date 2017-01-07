/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = new int[];
		System.out.println(getAnotherNumber1(arr));
		System.out.println(getAnotherNumber2(arr));
	}
	
	public static int getAnotherNumber1(int[] arr) {
		int n = arr.length;
		if (n == Integer.MAX_VALUE+1) return null;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			set.offer(arr[i]);
		}
		for (int i = 0; i <= n; i++) {
			if (!set.contains(i))
				return i;
		}
		return null;
	}
	
	public static int getAnotherNumber2(int[] arr) {
		int n = arr.length;
		if (n == Integer.MAX_VALUE+1) return null;
		int[] arr2 = new int[n+1];
		for (int i = 0; i < n; i++) {
			arr2[arr[i] % (n+1)] = arr[i];
		}
		for (int i = 0; i < n+1; i++) {
			if (arr2[i] == 0) 
				return i;
		}
	}
}
