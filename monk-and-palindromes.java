// https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/practice-problems/algorithm/monk-and-palindromes/description/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static int parent[];
	public int find(int a) {
		while (a != parent[a]) a = parent[a];
		return a;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) parent[i] = i;
		while (q-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			u = Math.min(u, v); v = Math.max(u, v);
			for (int i = u, j = v; i < j; i++, j--) {
				int a = parent[i];
				int b = parent[j];
				if (a != b) parent[a] = b;
			}
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			if (parent[i] == i) hs.add(i);
		}
		int ans = (int) Math.pow(10, hs.size());
		System.out.println(ans);
		
	}
}
