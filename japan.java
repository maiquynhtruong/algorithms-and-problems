// http://www.spoj.com/problems/MSE06H/
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<int[]> bridges = new ArrayList<int[]>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
		for (int i = 0; i < k; i++) { 
			int east = sc.nextInt(), west = sc.nextInt();
			bridges.add(new int[] {east, west});
		}
		Collections.sort(bridges, new Comparator<int[]>() {
			public int compare(int[] bridge1, int[] bridge2) {
				if (bridge1[0] == bridge2[0]) return bridge2[1] - bridge1[1];
				else return bridge2[0] - bridge1[0];
			}
		});
		int[] BIT = new int[k];
		Ideone o = new Ideone();
		System.out.println(o.solve(k, bridges, BIT));
	}
	public int solve(int k, List<int[]> bridges, int[] BIT) {
		for (int i = 0; i < k; i++) {
			update(k, i, 1, BIT);
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += query(k, i, BIT);
		}
		return sum;
	}
	
	public void update(int k, int index, int value, int[] BIT) {
		while (index <= k) {
			BIT[index] += value;
			index += index & (-index);
		}
	}
	
	public int query(int k, int index, int[] BIT) {
		int ans = 0;
		while (index > 0) {
			ans += BIT[index];
			index -= index & (-index);
		}
		return ans;
	}
} 
