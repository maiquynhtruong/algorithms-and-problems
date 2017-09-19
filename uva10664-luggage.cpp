#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int m, n;
int main() {
	//ifstream cin("luggage.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> m;
    cin.ignore();
    while (m--) {
    	int dp[25][105][105], sc[25], n=0;
    	int sum=0, s;
    	string line;
    	getline(cin, line);
    	if (debug) cout << line << "\n";
    	stringstream stream(line);
    	while (stream >> s) {
    		sc[++n] = s;
    		sum += s;
    	}
    	if (debug) cout << "sum= " << sum << "\n";
    	if (sum % 2 != 0) {cout << "NO" << "\n"; continue;
    	} else sum /= 2;
    	for (int i = 0; i <= n; i++) for (int j = 0; j <= sum+5; j++) fill(dp[i][j], dp[i][j]+sum+5, 0);
	dp[0][0][0]=1;
    	for (int i = 0; i <= n; i++) {
    	     for (int w1 = 0; w1 <= sum; w1++) {
    	     	for (int w2 = 0; w2 <= sum; w2++) {
            	     if (sc[i] <= w1) dp[i][w1][w2]= dp[i][w1][w2] || dp[i-1][w1-sc[i]][w2];
            	     if (sc[i] <= w2) dp[i][w1][w2]= dp[i][w1][w2] || dp[i-1][w1][w2-sc[i]];
    	     	}
    	     }
    	} 
    	if (debug) {
	         for (int w1 = 0; w1 <= sum; w1++) {
	         	for (int w2 = 0; w2 <= sum; w2++) {
		    cout << dp[n][w1][w2] << " ";
	         	}
	         	cout << "\n";
	         }
    	}
    	if (dp[n][sum][sum] == 1) cout << "YES" << "\n";
    	else cout << "NO" << "\n";
    }
    return 0;
}
