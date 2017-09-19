#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int m, n;
int main() {
	ifstream cin("luggage.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> m;
    cin.ignore();
    while (m--) {
    	int dp[25][105], sc[25], n=0;
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
    	if (sum % 2 != 0) {
    		cout << "NO" << "\n"; continue;
    	} else sum /= 2;
        for (int i = 0; i <= n; i++) fill(dp[i], dp[i]+sum+5, 0);
    	for (int i = 1; i <= n; i++) {
    		for (int w = 0; w <= sum; w++) {
                if (sc[i] <= w) dp[i][w] = dp[i-1][w-sc[i]] || dp[i-1][w];
    		}
    	} 
    	if (dp[n][sum] == 1) cout << "YES" << "\n";
    	else cout << "NO" << "\n";
    }
    return 0;
}
