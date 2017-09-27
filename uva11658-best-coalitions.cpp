#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int n, x, p[105], dp[10005];
int main() {
	// ifstream cin("best-coalitions.in");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> n >> x && n > 0 && x > 0) {
    	for (int i = 1; i <= n; i++) {
    		double t = 0;
    		cin >> t;
    		p[i] = t * 100;
    		cout << i << " " << p[i] << " ";
    	}	
 	for (int j = 0; j <= 10000; j++) {
 		dp[j] = -10000;
 	}
 	dp[0] = 1;
 	for (int i = 1; i <= n; i++) {
 		if (i == x) continue;
 		for (int j = 0; j <= 10000-p[i]; j++) {
 		// for (int j = 10000-p[i]; j >= 0; j--) {
 			dp[j+p[i]] = dp[j] || dp[j+p[i]];
 		}
 	}
 	cout << "\n p[" << x << "]= " << p[x] << "\n";
 	for (int j = 5000; j <= 10000; j++) {
 		if (0 < dp[j]) {
 			cout << j << " ";
 			cout << max(p[x]/100.0, (100.0*p[x])/j) << "\n";
 			break;
 		}
 	}
    }
}
