//http://codeforces.com/gym/101498/problem/D
#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int test, a, b, cnt = 0, pr = 0, cur = 0;
int dp[5][10010];

int main() {
// 	ifstream cin("counting-paths.in");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> test; 
    while (test--) {
    	cin >> a >> b;
    	for (int len = 0; len <= 2; len++) {
    		for (int change = 0; change <= b; change++) {
    			dp[len][change] = 0;
    		}
    	}
    	dp[0][0] = 1; cur = 1; pr = 0;
    	for (int len = 1; len <= a; len++) {
    		for (int change = 0; change <= b; change++) {
    			if (change < len) {
    				dp[cur][change] = dp[pr][change];
    				if (change > 0) dp[cur][change] += dp[pr][change-1];
    				// cout << dp[cur][change] << " ";
    			}
    		}
    		cur = !cur;
    		pr = !pr;
    		// cout << "\n";
    	}
    	// for (int change = 0; change <= b; change++) {cout << dp[cur][change] << " "; }
    	// cout << "\n";
    	// for (int change = 0; change <= b; change++) {cout << dp[pr][change] << " "; }
    	// cout << "\n";
    	int ans = dp[pr][b];
    	cout << ans*2 << "\n";
    }
}
