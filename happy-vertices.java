// https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/happy-vertices/
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/*
The problem is simple implementation of DFS while maintaining a count of children 
of the vertices visited. Let u be a vertex and v be its child. Then, check if 
children[v]>children[u].This way, check for each vertex while traversing the graph in DFS.
One important thing to note that actually there are many trees in the input(a graph with 
no cycles and self loops is a tree). That means , you have to apply DFS for each of these trees.
*/
class Ideone
{
	static int[] parent;
	static int[] children;
	static boolean[] visited;
	static List<List<Integer>> nodes;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		nodes = new ArrayList<List<Integer>>();
		parent = new int[n+1];
		children = new int[n+1];
		visited = new boolean[n+1];
		for (int i = 0; i <= n; i++) nodes.add(new ArrayList<Integer>());
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			nodes.get(x-1).add(y-1);
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				parent[i] = -1;
				dfs(i);
			}
		}
		int cnt = 0;
		for (int i = 0; i <= n; i++)
			if (parent[i] != -1)
				if (children[i] > children[parent[i]]) cnt++;
		System.out.println(cnt);
	}
	public static void dfs(int u) {
		visited[u] = true;
		for (int v : nodes.get(u)) {
			if (!visited[v]) {
				children[u]++;
				parent[v] = u;
				dfs(v);
			}
		}
	}
}
