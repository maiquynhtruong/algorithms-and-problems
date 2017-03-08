// https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/practice-problems/algorithm/marriage-problem/editorial/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	int parent[], women[], men[], size[];
	public void union(int a, int b) {
		int u = find(a);
		int v = find(b);
		if (u == v) return;
		if (size[u] > size[v]) {
			parent[v] = u;
			women[u] += women[v];
			men[u] += men[v];
			size[u] += size[v];
		} else {
			parent[u] = v;
			women[v] += women[u];
			men[v] += men[u];
			size[v] += size[u];
		}
	}
	public int find(int a) {
		while (parent[a] != a) {
			a = parent[a];
		}
		return a;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt(), q1 = sc.nextInt();
		parent = new int[x+y]; men = new int[x+y]; women = new int[x+y]; size = new int[x+y];
		for (int i = 0; i < x+y; i++) {
			parent[i] = i;
			size[i] = 1;
			women[i] = 0;
			men[i] = 0;
			if (i < x) men[i] = 1;
			else women[i] = 1;
		}
		while(q1--) {
			a = sc.nextInt(); b = sc.nextInt();
			union(a, b);
		}
		int q2 = sc.nextInt();
		while(q2--) {
			a = sc.nextInt()+x; b = sc.nextInt()+x;
			union(a, b);
		}
		int q3 = sc.nextInt();
		while(q3--) {
			a = sc.nextInt(); b = sc.nextInt()+x;
			union(a, b);
		}
		HashMap<Integer, LinkedList<Integer>> cc = new HashMap<Integer, LinkedList<Integer>>();
		int ans = 0;
		for (for int i = 0; i < x; i++) {
			ans += (y - women[find(i)]);
		}
		System.out.println(ans);
	}
}
