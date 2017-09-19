#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int m, n, p[105], f[105], dp[105][10205];
int main() {
	// ifstream cin("diving-for-gold.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> m >> n) {
    	for (int i = 1; i <= n; i++) {
    		cin >> p[i] >> f[i];
    	}
    	for (int i = 1; i <= n; i++) {
    		for (int money = 0; money <= max(2000, m); money++) {
			dp[i][money] = dp[i-1][money];
			if (p[i] <= money && dp[i][money] < dp[i-1][money-p[i]] + f[i]) {
				dp[i][money] = dp[i-1][money-p[i]] + f[i];
			}
    		}
	            if (m > 1800) {
	                for (int money = 2001; money <= m+200; money++) {
	                    dp[i][money] = dp[i-1][money];
	                    if (p[i] <= money && dp[i-1][money-p[i]] > 0 && dp[i][money] < dp[i-1][money-p[i]] + f[i]) {
	                        dp[i][money] = dp[i-1][money-p[i]] + f[i];
	                    }
	                }   
	            }
    	}
    	if (m > 1800) m+= 200;
	cout << dp[n][m] << "\n";
    }
}
