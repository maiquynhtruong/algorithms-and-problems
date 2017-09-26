#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int n, L[1005], W[1005], m = 0, dp[6005], inf = 100000;
int main() {
	// ifstream cin("easy-arithmetic.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	while (cin >> n && n > 0) {
		for (int i = 1; i <= n; i++) {
			cin >> W[i] >> L[i];
			if (W[i] + L[i] > m) m = W[i] + L[i];
		}
		for (int j = 0; j <= m; j++) {
			dp[j] = -1;
		}
		dp[0] = inf;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j >= 0; j--) {
				dp[j+1] = max(dp[j+1], min(dp[j]-W[i], L[i]));
			}
		}
		int res = m;
		for (int j = m; j >= 0; j--) {
			if (dp[j] == -1) res--;
			else break;
		}
		cout << res << "\n";
	}   
	
}
