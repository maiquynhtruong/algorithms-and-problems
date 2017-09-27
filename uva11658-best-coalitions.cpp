#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int n, x, p[105], dp[105][10005];
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
 	for (int i = 1; i <= n; i++) {
 		for (int j = 0; j <= 10005; j++) {
 			dp[i][j] = -10000;
 		}
 	}
 	dp[0][0] = 1;
 	for (int i = 1; i <= n; i++) {
 		for (int j = 0; j <= 10005; j++) {
 			
 			if (dp[i-1][j] >= 0) {
 				if (j + p[i] > 5000) dp[i][j+p[i]] = max(p[i]/(j+p[i]), dp[i-1][j]);	
 				else dp[i][j+p[i]] = p[i];
 			}
 		}
 	}
 	int res = p[x];
 	for (int j = 50; j <= 10005; j++) {
 		if (0 < dp[x][j]) {
 			cout << dp[x][j]/100 << "\n";
 			break;
 		}
 	}


}
