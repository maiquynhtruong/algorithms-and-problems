/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int sum = 0;
		int[] nums = new int[] {1, 4, 5, 7, 10, 3};
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 == 0) {
			System.out.println(isSubsetSum(nums, nums.length, sum / 2));
		} else {
			System.out.println(false);
		}
	}
	
	public static boolean isSubsetSum(int[] nums, int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if ( n == 0 && sum != 0) {
			return false;
		}
		if (nums[n-1] > sum) {
			return isSubsetSum(nums, n-1, sum);
		} else {
			return isSubsetSum(nums, n-1, sum - nums[n-1]) || isSubsetSum(nums, n-1, sum);
		}
	}
}
