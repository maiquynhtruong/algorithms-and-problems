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
		for (int i = 0; i < k; i++) 
		// System.out.println("i= " + i + ", east= " + bridges.get(i)[0] + ", west= " + bridges.get(i)[1]);
		// System.out.println();
		Collections.sort(bridges, new Comparator<int[]>() {
			public int compare(int[] bridge1, int[] bridge2) {
				if (bridge1[0] == bridge2[0]) return -(bridge2[1] - bridge1[1]);
				else return -(bridge2[0] - bridge1[0]);
			}
		});
		for (int i = 0; i < k; i++) 
		System.out.println("i= " + i + ", east= " + bridges.get(i)[0] + ", west= " + bridges.get(i)[1]);
		int[] BIT = new int[20];
		Ideone o = new Ideone();
		System.out.println(o.solve(m, k, bridges, BIT));
	}
	public int solve(int m, int k, List<int[]> bridges, int[] BIT) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			System.out.println("i= " + i + ", west= " + bridges.get(i)[1]);
			System.out.println("Pre-update: " + Arrays.toString(BIT));
			update(bridges.get(i)[1], m, BIT);
			System.out.println("Post-update: " + Arrays.toString(BIT));
			int sumM = query(m, BIT);
			int sumI = query(bridges.get(i)[1], BIT);
			sum += sumM - sumI;
			System.out.println("sum= " + sum + ", sumM= " + sumM + ", sumI= " + sumI);
			
		}
		return sum;
	}
	
	public void update(int index, int max, int[] BIT) {
		while (index <= max) {
			BIT[index] += 1;
			index += index & (-index);
		}
	}
	
	public int query(int index, int[] BIT) {
		int ans = 0;
		while (index > 0) {
			ans += BIT[index];
			index -= index & (-index);
		}
		return ans;
	}
} 
