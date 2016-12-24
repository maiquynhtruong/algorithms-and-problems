/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
	
	void build (int node, int start, int end) 
	{
		if (start == end) 
		{
			tree[node] = A[start];
		}
		int mid = (start + end) / 2;
		build (2 * node, start, mid);
		build (2 * node + 1, mid + 1, end);
		tree[node] = tree[2 * node] + tree[2 * node + 1];
	}
	
	void update (int node, int start, int end, int idx, int val) 
	{
		if (start == end) 
		{
			A[idx] += val;
			tree[node] += val;
		}
		
		int mid = (start + end) / 2;
		if (start <= idx && idx <= mid)
		{
			update(2 * node, start, mid, idx, val);
		} else {
			update(2 * node + 1, mid + 1, end, idx, val);
		}
		tree[node] = tree[2 * node] + tree[2 * node + 1];
	}
	
	int query (int node, int start, int end, int l, int r) 
	{
		if (r < start && l > end) 
		{
			return 0;
		} else if (l >= start && r <= end) 
		{
			return tree[node];
		}
		int mid = (start + end) / 2;
		int p1 = query (2 * node, start, mid, l, r);
		int p2 = query (2 * node + 1, mid + 1, end, l, r);
		return p1 + p2;
	}
}
