/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Edge implements Comparable<Edge>{
	int u, v, w;
	public Edge (int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public int compareTo(Edge other) {
		return this.w - other.w;
	}
}
class Ideone
{
	static int[] parent;
	static Edge[] edges;
	public static void union(int u, int v) {
		int p_u = find(u);
		int p_v = find(v);
		if (p_u == p_v) return;
		parent[p_u] = p_v;
	}
	public static int find(int u) {
		while (parent[u] != u) u = parent[u];
		return u;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // vertices
		int m = sc.nextInt(); // edges
		parent = new int[n];
		edges = new Edge[m];
		for (int i = 0; i < n; i++) parent[i] = i;
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			edges[i] = new Edge(u, v, w);
		}
		Arrays.sort(edges);
		int minCost = 0;
		for (int i = 0; i < m; i++) {
			int u = edges[i].u;
			int v = edges[i].v;
			int w = edges[i].w;
			if (find(u) != find(v)) { // doesn't make a cycle
				minCost += w;
				union(u, v);
			}
		}
	}
}
