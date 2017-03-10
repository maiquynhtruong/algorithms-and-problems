/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	int size[], parent[];
	public static void union(int a, int b) {
		int u = find(a);
		int v = find(b);
		if (u == v) return;
		if (size[u] > size[v]) {
			parent[v] = u;
			size[u] += size[v];
		} else {
			parent[u] = v;
			size[v] += size[u];
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		size = new int[n];
		parent = new int[n];
		for (int i = 0; i < n; i++) size[i] = 1; 
		int m1 = sc.nextInt();
		while (m1--) {
			int a = sc.nextInt(), b = sc.nextInt();
			union(a,b);
		}
		int m2 = sc.nextInt();
		while (m2--) {
			int a = sc.nextInt(), b = sc.nextInt();
			if (find(a) == find(b)) {
				size[find(a)] = size[find(b)] = 0;
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) ans = Math.max(ans, size[i]);
		System.out.println(ans);
	}
}
