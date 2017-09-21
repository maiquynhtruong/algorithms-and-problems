import java.util.*;
import java.lang.*;
import java.io.*;

class MaxFlow {

	static final int V = 6; 
	 /* Returns true if there is a path from source 's' to sink
      't' in residual graph. Also fills parent[] to store the
      path */
	int bfs(int graph[][], int s, int t, int[] parent) {
		boolean visited[] = new boolean[V];	
		for (int i = 0; i < V; i++) visited[i] = false;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s] = -1
		while (queue.size() > 0) {
			int u = queue.poll();
			for (int v = 0; v < V; v++) {
				if (visited[v] == false && graph[u][v] > 0) {
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}
		// If we reached sink in BFS starting from source, then
        	// return true, else false
        	return (visited[t] == true);
		
	}	
		// find maximal flow in the network with source s and sink t
	int fordFulkerson(int graph[][], int s, int t) {
		int resGraph[][] = new int[V][V];
		
		// Create a residual graph and fill the residual graph
		// with given capacities in the original graph as
		// residual capacities in residual graph

		// Residual graph where rGraph[i][j] indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is not)
		for (int u = 0; u < V; u++) {
			for (int v = 0; v < V; v++) {
				rGraph[u][v] = graph[u][v];	
			}
		}
		int parent = new int[V]; // This array is filled by BFS and to store path
		int maxFlow = 0;
		
		// Augment the flow while tere is path from source to sink
		while (bfs(rGraph, s, t, parent) {
			int pathFlow = Integer.MAX_VALUE;
		    // Find minimum residual capacity of the edhes along the path filled by BFS. Or we can say
		    // find the maximum flow through the path found.
			for (int v = t ; v != s; v = parent[v]) {
				int u = parent[v];
				pathFlow = min(pathFlow, rGraph[u][v]);
			}
			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				rGraph[u][v] += pathFlow;
				rGraph[v][u] -= pathFlow
			}
			maxFlow += pathFlow;
		}
		return maxFlow;
	}

	public static void main(String args[]) {
        int graph[][] = new int[][] { {0, 16, 13, 0, 0, 0},
                                     {0, 0, 10, 12, 0, 0},
                                     {0, 4, 0, 0, 14, 0},
                                     {0, 0, 9, 0, 0, 20},
                                     {0, 0, 0, 7, 0, 4},
                                     {0, 0, 0, 0, 0, 0}
	};
	MaxFlow m = new MaxFlow();
	System.out.println("Maximal Flow is " m.fordFulkerson(graph, 0, 5));
	}
}
