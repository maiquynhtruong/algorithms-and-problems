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


/** Another way to do it with BIT
The idea is to have a tree of possible sum. Each node will store the number of boxes containing less than or equal to the node's value
amount of coins.
**/

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
		int[] cnt = new int[n+1];
		for (int i = 1; i <= m; i++) {
			int l = sc.nextInt(), r = sc.nextInt();
			cnt[l]++; cnt[r+1]--;
		}
		System.out.println(Arrays.toString(cnt));
		int[] tree = new int[m+1];
		int[] arr = new int[n+1];
		long curSum = 0;
		for (int i = 1; i <= n; i++) {
			curSum += cnt[i];
			arr[i] += curSum;
		}
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i <= n; i++) {
			update(tree, arr[i], 1);
		}
		
		System.out.println(Arrays.toString(tree));
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int x= sc.nextInt();
			System.out.println(n-query(tree, x-1));
		}
	}
	
	public static void update(int[] tree, int index, int value) {
		for (int i = index; i < tree.length; i += (i & -i)) {
			tree[i] += value;
		}
	}
	
	public static int query(int[] tree, int index) {
		int ans = 0;
		for (int i = index; i > 0; i -= (i & -i)) {
			ans += tree[i];
		}
		return ans;
	}
}

