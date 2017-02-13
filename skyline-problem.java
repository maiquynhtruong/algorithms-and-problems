/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n = 5;
		int[][] skyscrappers = {
			{2,9,10},
			{3,6,15},
			{5,12,12},
			{13,16,10},
			{15,17,5}
		};
		List<int[]> skylines = getSkyLines(0, skyscrappers.length-1, skyscrappers);
		for (int[] skyline : skylines) {
			System.out.println(skyline[0] + ", " + skyline[1]);
		}
	}
	
	public static List<int[]> getSkyLines(int low, int high, int[][] skyscrappers) {
		List<int[]> list = new ArrayList<int[]>();
		if (low > high) {
			return list;
		} else if (low == high) {
			list.add(new int[] {skyscrappers[low][0], skyscrappers[low][2]});
			list.add(new int[] {skyscrappers[low][1], 0});
			return list;
		} else {
			int mid = (low + high) / 2;
			System.out.println(Arrays.toString(skyscrappers[mid]));
			List<int[]> skylines1 = getSkyLines(low, mid, skyscrappers);
			List<int[]> skylines2 = getSkyLines(mid+1, high, skyscrappers);
			
			return mergeSkyLines(skylines1, skylines2);
		}
	}
	
	public static List<int[]> mergeSkyLines(List<int[]> skylines1, List<int[]> skylines2) {
		int building0 = 0, building1 = 0;
		List<int[]> skylines = new ArrayList<int[]>();
		while (!skylines1.isEmpty() && !skylines2.isEmpty()) {
			int[] arr1 = skylines1.get(0);
			int[] arr2 = skylines2.get(0);
			int[] skyline;
			if (arr1[0] == arr2[0]) {
				// compare the heights of two buildings
				skyline = new int[] {arr1[0], Math.max(arr1[1], arr2[1])};
				skylines.add(skyline);
				building0 = arr1[1];
				building1 = arr2[1];
				skylines1.remove(0);
				skylines2.remove(0);
			} else if (arr1[0] < arr2[0]) {
				skyline = new int[] {arr1[0], Math.max(arr1[1], building1)};
				building0 = arr1[1];
				skylines.add(skyline);
				skylines1.remove(0);
			} else {
				skyline = new int[] {arr2[0], Math.min(arr2[1], building0)};
				building1 = arr2[1];
				skylines.add(skyline);
				skylines2.remove(0);
			}
			
		}
		if (!skylines1.isEmpty()) skylines.addAll(skylines1);
		if (!skylines2.isEmpty()) skylines.addAll(skylines2);
		return skylines;
	}
}
