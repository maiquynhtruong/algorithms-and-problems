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
		System.out.println(skylines);
	}
	
	public static List<int[]> getSkyLines(int low, int high, int[][] skyscrappers) {
		List<int[]> list = new ArrayList<int[]>();
		if (low > high) {
			return list;
		} else if (low == high) {
			int point1[] = new int[2];
			point1[0] = skyscrappers[low][0];
			point1[1] = skyscrappers[low][1];
			int point2[] = new int[2];
			point2[0] = skyscrappers[low][2];
			point2[1] = 0;
			list.add(point1);
			list.add(point2);
			return list;
		} else {
			int mid = (low + high) / 2;
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
			int skyline[] = new int[2];
			if (arr1[0] == arr2[0]) {
				// compare the heights of two buildings
				skyline[0] = arr1[0];
				skyline[1] = Math.max(arr1[1], arr2[1]);
				skylines.add(skyline);
				building0 = arr1[1];
				building1 = arr2[1];
				skylines.remove(0);
				skylines.remove(0);
			} else if (arr1[0] < arr2[0]) {
				skyline[0] = arr1[0];
				skyline[1] = Math.max(arr1[1], building1);
				building0 = arr1[1];
				skylines.add(skyline);
				skylines.remove(0);
			} else {
				skyline[0] = arr2[0];
				skyline[1] = Math.min(arr2[1], building0);
				building1 = arr2[1];
				skylines.add(skyline);
				skylines.remove(0);
			}
			
		}
		if (!skylines1.isEmpty()) skylines.addAll(skylines1);
		if (!skylines2.isEmpty()) skylines.addAll(skylines2);
		
		// remove points of same heights
		// for (int[] skyline : skylines) {
		// 	if 
		// }
		return skylines;
	}
}
