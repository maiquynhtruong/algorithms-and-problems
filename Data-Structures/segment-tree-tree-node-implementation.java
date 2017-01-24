/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class SegmentTreeNode {
		int start, end; // range that the node covers
		SegmentTreeNode left, right;
		int sum;
		SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = new int[] {1, 3, 5};
		SegmentTreeNode root = build(arr, 0, arr.length-1);
		System.out.println(query(root, 0, 2));
		update(root, 1, 2);
		System.out.println(query(root, 0, 2));
	}
	
	public static SegmentTreeNode build(int[] arr, int start, int end) {
		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start == end) {
			root.sum = arr[start];
		} else {
			int mid = (start + end) / 2;
			root.left = build(arr, start, mid);
			root.right = build(arr, mid+1, end);
			root.sum = root.left.sum + root.right.sum;
		}
		System.out.println("start= " + start + ", end= " + end + 
		", sum= " + root.sum);
		return root;
	}
	
	public static void update(SegmentTreeNode root, int i, int val) {
		System.out.println("start= " + root.start + ", end= " + root.end + 
		", sum= " + root.sum);
		if (root.start == root.end) {
			root.sum = val;
		} else {
			int mid = (root.start + root.end) / 2;
			if (mid >= i) {
				update(root.left, val, i);
			} else {
				update(root.right, val, i);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}
	
	public static int query(SegmentTreeNode root, int left, int right) {
		if (root.start > right || root.end < left) {
			return 0;
		} 
		if (root.end == right && root.start == left) {
			return root.sum;
		} 
		int mid = (root.start + root.end) / 2;
		int leftSum = query(root.left, left, mid);
		int rightSum = query(root.right, mid+1, right);
		return leftSum + rightSum;
	}
}
