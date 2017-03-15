/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	
	int[][] neighbors; // neighbors vertices with weights
	int[] parent;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // edges
		int n = sc.nextInt(); // vertices
		parent = new int[n];
		neighbors = new int[n][n];
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			int w = sc.nextInt();
			neighbors[u][v] = w;
			neighbors[v][u] = w;
		}
		while (!queue.empty()) {
			int v = queue.pop();
			
		}
	}
}
