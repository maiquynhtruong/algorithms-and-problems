// https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/practice-problems/algorithm/marriage-problem/editorial/

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
		x = sc.nextInt(), y = sc.nextInt(), q1 = sc.nextInt();
		while(q1--) {
			a = sc.nextInt(); b = sc.nextInt();
			union(a, b);
		}
		while(q2--) {
			a = sc.nextInt()+x; b = sc.nextInt()+x;
			union(a, b);
		}
		while(q3--) {
			a = sc.nextInt(); b = sc.nextInt()+x;
			union(a, b);
		}
		HashMap<Integer, LinkedList<Integer>> cc = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < x+y; i++) {
			if (!cc.containsKey(parent[i])) cc.put(parent[i], new LinkedList<Integer>());
			if (i <= x) cc.get(parent[i]).get(0)++;
			else cc.get(parent[i]).get(1)++;
		}
		int ans = 0;
		for (ListList<Integer> ll : cc) {
			ans += ll.get(0) * (y - ll.get(1));
		}
		System.out.println(ans);
	}
}
