// https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/happy-vertices/
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
		int n = sc.nextInt(), m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
		}
		for (int i = 0; i < m; i++) 
			if (!visited[i]) dfs(i);
	}
	int static cnt = 0;
	public static void dfs(int u) {
		int edges = 0, children = 0;
		for (int i = 0; i < n; i++) {
			edges++;
			if (!visited[i] && a[u][i]) {
				children++;
				dfs(i);
			}
		}
		if (children > edges - children) {
			cnt++;
		}
	}
}
