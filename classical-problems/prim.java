/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	
	int[][] neighbors; // neighbors vertices with weights
	int[] parent; // preceding node in the tree
	int[] dist; // shortest distance to any vertex in MST
	boolean[] visited; // true if the vertex has been considered
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // edges
		int n = sc.nextInt(); // vertices
		parent = new int[n];
		neighbors = new int[n][n];
		// PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			int w = sc.nextInt();
			neighbors[u][v] = w;
			neighbors[v][u] = w;
		}
		for (int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
		dist[s] = 0;
		for (int i = 0; i < dist.length; i++) {
			int next = minVertex(); // the smallest vertex in non-MST subset
			visited[next] = true; // next has been included in MST
			for (int v = 0; v < dist.length; v++) { 
				if (neigbors[next][v] && !visited[v]) {
					if (dist[v] > neighbors[next][v]) { // gradually assigning best-known shortest distance from 
									// v to MST
						dist[v] = neighbors[next][v];
						parent[v] = next;
					}
				}
			}
			
		}
		
	}
	
	public static int minVertex() {//int[] dist, boolean[] visited) {
		int w = Integer.MAX_VALUE;
		int i = -1;
		for (int v = 0; v < dist.length; v++) {
			if (!visited[v] && dist[v] < w) {
				w = dist[v];
				i = v;
			}
		}
		return i;
	}
}
