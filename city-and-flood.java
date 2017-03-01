/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		UF uf = new UF(n);
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			uf.union(a, b);
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			hs.add(uf.find(i));
		}
		System.out.println(hs.size());
	}
}

class UF{
	int[] parent;
	
	public UF(int n) {
		this.parent = new int[n+1];
		for (int i = 1; i <= n; i++) parent[i] = i;
	}
	public void union(int i, int j) {
		// System.out.println("i= " + i + ", j= " + j);
		int u = find(i);
		int v = find(j);
		// System.out.println("u= " + u + ", v= " + v);
		if (u == v) return;
		parent[u] = v;
	}
	public int find(int i) {
		while (parent[i] != i) i = parent[i];
		return i;
	}
}
