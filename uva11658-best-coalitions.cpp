#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int n, x, p[105], dp[10005];
int main() {
	ifstream cin("best-coalitions.in");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> n >> x && n > 0 && x > 0) {
    	for (int i = 1; i <= n; i++) {
    		double t = 0;
    		cin >> t;
    		p[i] = t * 100;
    	}	
    }
 	for (int j = 0; j <= 10005; j++) {
 		dp[j] = -10000;
 	}
 	dp[0] = 1;
 	for (int i = 1; i <= n; i++) {
 		if (i == x) continue;
 		for (int j = 0; j <= 10005; j++) {
 			dp[j+p[i]] = dp[j] || dp[j+p[i]];
 		}
 	}
 	// int res = p[x];
 	for (int j = 50; j <= 10005; j++) {
 		if (0 < dp[j]) {
 			cout << p[x]/dp[j] << "\n";
 			break;
 		}
 	}
}
