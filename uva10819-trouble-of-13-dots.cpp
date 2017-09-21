#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int m, n, dp[10205][105], p[105], f[105], neg = 20000000;
int main() {
	// ifstream cin("trouble-of-13-dots.inp");
	// freopen("trouble-of-13-dots.out","w",stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (!cin.eof()) {
    	cin >> m >> n;
    	int total = 0;
    	// cout << "Test " << ++test << ":\n" << "m= " << m << " n= " << n << "\n";
    	m += 200;
    	if (cin.eof()) break;
    	for (int i = 1; i <= n; i++) {
    		cin >> p[i] >> f[i];
    		total += p[i];
    		for (int j = 0; j <= m; j++) {
    			dp[j][i] = -neg;
    		}
    		// cout << clothes[i].first << " " << clothes[i].second << "\n";
    	}

    	for (int i = 0; i <= n; i++) {
    		total += p[i];
    		for (int j = 0; j <= m; j++) {
    			dp[j][i] = -neg;
    		}
    		// cout << clothes[i].first << " " << clothes[i].second << "\n";
    	}
    	
    	dp[0][0]=0;
    	
    	for (int i = 1; i <= n; i++) {
    		for (int money = 0; money <= min(m, total); money++) {
				if (p[i] <= money) dp[money][i] = max(dp[money][i-1], dp[money-p[i]][i-1] + f[i]);
				else dp[money][i] = dp[money][i-1];
    		}
    	}

    	m -= 200;
    	int result = 0;
    	for (int money = 0; money <= m; money++) result = max(result, dp[money][n]);
    	for (int money = 2001; money <= m+200; money++) result = max(result, dp[money][n]);
		cout << result << "\n";
    }
}
