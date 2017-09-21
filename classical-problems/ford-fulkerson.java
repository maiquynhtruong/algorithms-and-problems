import java.util.*;
import java.lang.*;
import java.io.*;

class MaxFlow {

	static final int V = 6; 
	// find maximal flow in the network with source s and sink t
	int fordFulkerson(int graph[][], int s, int t) {
		int u, v;
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
