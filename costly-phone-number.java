//https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/costly-phone-number-december-easy-easy-medium/
public class Solution {
	public static void main(String args[]) {
		int[] w = new int[10];
		int[] c = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) { 
			w[i] = sc.nextInt();
			c[i] = Integer.MAX_INT;
		}
		int len = sc.nextInt();
		while (true) {
			boolean reduce = false;
			for (int a = 0; a <= 9; a++) 
				for (int b = a; b <= 9; b++) {
					int num = (a+b) % 10;
					if (c[num] > c[a] + c[b]) {
						reduce = true;
						c[num] = c[a] + c[b];
					}
				}
		}
		int ans = 0;
		for (int i = 0; i < len; i++) {
			int num = sc.nextInt();
			ans += c[num];
		}
		 System.out.println(num);
	}
}
