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
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (uf.find(i) == i) cnt++;
		}
		System.out.println(cnt);
	}
}

class UF{
	int[] parent;
	
	public UF(int n) {
		this.parent = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;
	}
	public void union(int i, int j) {
		int u = find(i);
		int v = find(j);
		if (u == v) return;
		parent[u] = v;
	}
	public int find(int i) {
		while (find(i) != i) i = find(i);
		return i;
	}
}
