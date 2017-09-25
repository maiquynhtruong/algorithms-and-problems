#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int n, L[1005], W[1005], m = 0, dp[1005][6005];
int main() {
	// ifstream cin("easy-arithmetic.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	while (cin >> n && n > 0) {
		for (int i = 1; i <= n; i++) {
			cin >> W[i] >> L[i];
			if (W[i] + L[i] > m) m = W[i] + L[i];
		}
		// cout << "m= " << m << "\n";
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = -1000000;
			}
		}
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = dp[i-1][j];
				if (W[i] <= j && dp[i-1][j-W[i]] + 1 > dp[i][j]) {
					dp[i][j] = dp[i-1][j-W[i]] + 1;
					// cout << i << ", " << j << ", " << dp[i][j] << "\n";
				}
			}
		}
		// for (int i = 0; i <= n; i++) {
		// 	for (int j = 0; j <= m; j++) {
		// 		cout << dp[i][j] << " ";
		// 	}
		// 	cout << "\n";
		// }
		int res = dp[n][m];
		for (int j = 0; j <= m; j++) {
			if (res < dp[n][j]) res = dp[n][j];
		}
		cout << res << "\n";
	}   
	
}
