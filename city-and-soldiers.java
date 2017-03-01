// https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/practice-problems/algorithm/city-and-soldiers/description/
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
		int q = sc.nextInt();
		sc.nextLine();
		UF uf = new UF(n+1);
		for (int i = 0; i < q; i++) {
			int op = sc.nextInt();
			if (op == 1) {
				uf.union(sc.nextInt(), sc.nextInt());
			} else if (op == 2) {
				int a = sc.nextInt();
				int root = uf.find(a);
				uf.parent[root] = a;
				uf.parent[a] = a;
			} else {
				int leader = uf.find(sc.nextInt());
				System.out.println(leader);
			}
		}
	}
}
class UF {
	int parent[];
	public UF(int n) {
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) parent[i] = i;
	}
	public void union(int a, int b) {
		int u = parent[a];
		int v = parent[b];
		if (u != v) parent[u] = v;
	}
	public int find(int a) {
		while (a != parent[a]) a = parent[a];
		return a;
	}
}
