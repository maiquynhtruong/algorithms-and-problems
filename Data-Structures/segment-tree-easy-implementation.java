

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	static int n = 16;
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = new int[2*n];
		for (int i = n; i < 2*n; i++) arr[i] = i - n;
		build(arr);
      	System.out.println(query(arr, 3, 11));
		modify(arr, 0, 4);
		System.out.println(query(arr, 3, 11));
	}
	
	public static void build(int[] arr) {
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = arr[i<<1] + arr[i<<1|1];
		}
	}
	
	/**
	 * Nodes are stored in continuous indices starting with n. Element with index
	 * i corresponds to node with index i+n
	 * Update is just updating the parents of the given node
	 * p^1 turns 2*i to 2*i+1 and vice versa, so it is the second child of the parent
	 **/
	 // set value at position p
	public static void modify(int[] arr, int p, int v) {
		for (arr[p += n] = v; p > 1; p >>= 1) arr[p>>1] = arr[p] + arr[p^1];
	}
	
  /**
  General idea is the following. If l, the left interval border, is odd (which is equivalent to l&1) 
  then l is the right child of its parent. Then our interval includes node l but doesn't include its 
  parent. So we add t[l] and move to the right of l's parent by setting l = (l + 1) / 2. If l is even, 
  it is the left child, and the interval includes its parent as well (unless the right border interferes), 
  so we just move to it by setting l = l / 2. Similar argumentation is applied to the right border.
  We stop once borders meet.
  **/
	public static int query(int[] arr, int l, int r) {
		int res = 0;
		for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
			if (l % 2 == 1) res += arr[l++];
			if (r % 2 == 1) res += arr[--r];
		}
		return res;
	}
}
