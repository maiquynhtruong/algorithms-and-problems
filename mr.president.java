// https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/mr-president/
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Edge {
	int u, v, w;
	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
}
class Ideone
{
	static int[] parent;
	static void union(int u, int v) {
		int a = find(u);
		int b = find(v);
		if (a == b) return;
		parent[a] = b;
		
	}
	static int find(int u) {
		while (parent[u] != u) u = parent[u];
		return u;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // vertices
		int m = sc.nextInt(); // edges
		Edges[] edges = new Edges[m+1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(); 
			int b = sc.nextInt();
			int w = sc.nextInt();
			edges[i] = new Edge(a, b, w);
		}
		Collections.sort
	}
}
