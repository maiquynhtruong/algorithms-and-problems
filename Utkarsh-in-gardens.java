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
		int a[][] = new int[n+1][n+1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		int d[][] = new int[n+1][n+1];
		for (int i = 1; i <= n; i++)
			for (int j = i+1; j <= n; j++) {
				int cnt = 0;
				for (int k = 1; k <= n; k++) 
					if (a[i][k]==1 && a[k][j]==1) cnt++;
				d[i][j] += cnt;
			}
		int ans = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++) {
				ans += d[i][j]*(d[i][j] - 1)/2;
			}
		System.out.println(ans/2);
	}
}
