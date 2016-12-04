// http://www.geeksforgeeks.org/find-number-of-islands/
// http://ideone.com/q12Q61#stdin

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	static int[][] M = new int[][]{  
		{1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    };
    static final int r = M.length, c = M[0].length;
    static int[][] vis = new int[r][c];
	
	static boolean goodToGo(int i, int j) {
		// System.out.println("i= " + i + ", j= " + j);
		if (i >= 0 && i < r && j >=0 && j < c && 
		M[i][j]==1 && vis[i][j]== 0) return true; 
		else return false;
	}
	static void dfs(int i, int j) {
		int[] row = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
		int[] col = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
		vis[i][j] = 1;
		
		for (int k = 0; k < row.length; k++)
			if (goodToGo(i + row[k], j + col[k])) {
				
			// if (k == 0) {
				// System.out.println("row: " + (i + row[k]) + ", col: " + (j + col[k]));
				dfs(i + row[k], j + col[k]);
			}
	}
	static int countIslands(int[][] M) {
		int cnt = 0;
		for (int i = 0; i < M.length; i++)
			for (int j = 0; j < M[0].length; j++) vis[i][j] = 0;
		for (int i = 0; i < M.length; i++)
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j]==1 && vis[i][j]==0) {cnt++; dfs(i, j);}
			}
		return cnt;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
 
  	System.out.println("Number of islands is:" + countIslands(M));
	}
}
