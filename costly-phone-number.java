//https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/costly-phone-number-december-easy-easy-medium/
public class Solution {
	public static void main(String args[]) {
		int[] w = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) 
			w[i] = sc.nextInt();
		int len = sc.nextInt();
		int[] num = new int[len];
		for (int i = 0; i < len; i++) {
			num[i] = sc.nextInt();
			dfs(w, 0, num[i]);
		}
		 
	}
	
	public void dfs(int[] w, int sum, int cur, int des) {
		if (cur == des && sum < w[des]) 
		for (int i = 0; i <= 9; i++) 
			if (w[i] + sum < w[des]) dfs(w, w[i] + sum, (i+cur) % 10, des);
			
	}
}
