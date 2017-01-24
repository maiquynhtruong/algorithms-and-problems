/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static int[] arr;
	static int[] tree;
	public static void main (String[] args) throws java.lang.Exception
	{
		arr = new int[]{18,17,13,19,15,11,20,12,33,25};
		int n = arr.length;
		tree = new int[2*n];
		buildTree(0, 0, n-1);
	}
	// l, r: the range in the arr (0 <= l < r <= n-1) that tree[i] covers
	// call this method as buildTree(arr, 0, 0, n-1);
	public static void buildTree(int treeIndex, int l, 
	int r) {
		if (l == r) {
			tree[treeIndex] = arr[l];
		} else {
			int mid = (l+r)/2;
			buildTree(2*treeIndex+1, l, mid);
			buildTree(2*treeIndex+2, mid+1, r);
			tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];
		}
	}
	// l, r: range in arr (0 <= l < r <= n-1) being covered. low, high: query range
	// call this method as query(0, 0, n-1, i, j)
	public static int query(int treeIndex, int l, 
	int r, int low, int high) {
		if (low > r || high < l) {
			return 0;
		} 	
		if (low <= l && r <= high) { // segment completely inside query range
			return tree[treeIndex];
		}
		int mid = (l+r)/2;
		int left = query(2*treeIndex+1, l, mid, low, high);
		int right = query(2*treeIndex+2, mid+1, r, low, high);
		return left + right;
	}
	// call this method as update(0, 0, n-1, i, val);
	// Here you want to update the value at index i with value val.
	public static void update(int treeIndex, int l, int r, 
	int arrIndex, int val) {
		if (l == r) {
			arr[arrIndex] = val;
			tree[treeIndex] = val;
		} else {
			int mid = (l+r)/2;
			if (arrIndex > mid) {
				update(2*treeIndex+1, l, mid, arrIndex, val);
			} else {
				update(2*treeIndex+2, mid+1, r, arrIndex, val);
			}
			tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];
		}
	}
}
