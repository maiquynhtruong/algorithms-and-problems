#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int m, n, p[4005], f[4005], v[35], dp[35][1005];
int main() {
	ifstream cin("diving-for-gold.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> m >> n) {
    	if (m >= 2000) m += 200;
    	for (int i = 1; i <= n; i++) {
    		cin >> p[i] >> f[i];
    	}
    	for (int i = 1; i <= n) {
    		for (int money = 0; money <= m; money++) {
    			if (p[i] <= money) {
    				dp[i][money] = dp[i-1][money];
    				if (dp[i-1][money] < dp[i-1][money-p[i]]) {
    					dp[i][money] = dp[i-1][money-p[i]];
    				}
    			}
    		}
    	}
    }
}
