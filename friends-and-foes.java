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
		int m1 = sc.nextInt();
		while (m1--) {
			int a = sc.nextInt(), b = sc.nextInt();
			union(a,b);
		}
		int m2 = sc.nextInt();
		while (m2--) {
			int a = sc.nextInt(), b = sc.nextInt();
			if (find(a) == find(b)) {
				
			}
		}
	}
}
