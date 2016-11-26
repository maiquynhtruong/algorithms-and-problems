
// Problem: A student has M days to review N subjects. In his experience, reivewing subject j in i days will get him a score of A[i][j].
// Assuming A[i][j] >= 0 and A[i][j] < A[i+1][j], find X[j] (review days for subject j, with j = 1, 2,... m) such that sum(X[j]) = M
// and the student achieves the highest score (or sum(A[x[j]][i]) is maximum).
// Input file: First line: 2 positive integer M and N (0 <= N <= 50, 0 < N <= M <= 100)
// Next M lines, each line has N number indicating score the student will get if he review subject j in i days
// Output file: First line: Maximum score student can get
// Next N lines, each line has 2 number for the index of the subject and the number of days needed to review the subject
// http://ideone.com/gimIGT
import java.util.*;
class Ideone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
				// System.out.println(i + ", " + j + ", " + a[i][j]);
			}
		}
		int d[][] = new int[n+1][m+1];
		int days[][] = new int[n+1][m+1];
		int time[] = new int[n+1];
		for (int i = 1; i <= m; i++) {
			d[1][i] = a[i][1]; // review only one subject in i days
			days[1][i] = i;
			// System.out.println(d[1][i]);
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int day = 0;
				for (int k = 1; k <= j; k++) 
					if (d[i][j] < a[k][i] + d[i-1][j-k]) {
						d[i][j] = a[k][i] + d[i-1][j-k];
						day = k;
					}
				days[i][j] = day;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) 
				System.out.print(d[i][j] + " ");		
			System.out.println();
		}
		
		
		System.out.println(d[n][m]);
		int j = m;
		for (int i = n; i > 1; i--) {
			time[i] = days[i][j];
			j = j - days[i][j];
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(i + ", " + time[i]);
		}
		return;
	}	
	
}