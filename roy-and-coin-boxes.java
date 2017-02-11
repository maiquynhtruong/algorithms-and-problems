// A problem from HackerEarth. Was looking for some problem related to BIT. The BIT tutorial got the link to this problem, but 
// this one turned out to be a DP instead of BIT. A bit disappointed, but a good problem to learn overall. 

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
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] cnt = new int[n];
		Arrays.fill(cnt, 0);
		for (int i = 0; i < m; i++) {
			int l = sc.nextInt(), r = sc.nextInt();
			cnt[l]++; cnt[r]--;
		}
		int[] tree = new int[1000000+1];
		Arrays.fill(tree, 0);
		int curSum = 0;
		for (int i = 0; i < n; i++) {
			curSum += cnt[i];
			tree[curSum]++;
		}
		for (long long i = 1; i <= 1000000; i++) {
			tree[i] += tree[i-1];
		}
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int x= sc.nextInt();
			System.out.println(n-tree[x-1]);
		}
	}
	
}
