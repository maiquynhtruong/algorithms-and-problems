#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int m;
int main() {
	ifstream cin("luggage.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> m;
    cin.ignore();
    while (m--) {
    	int dp[25][105][105], sc[25], scInd=0;
    	int sum=0, s;
    	string line;
    	getline(cin, line);
    	if (debug) cout << line << "\n";
    	stringstream stream(line);
    	while (stream >> s) {
    		sc[++scInd] = s;
    		sum += s;
    	}
    	if (debug) cout << "sum= " << sum << "\n";
    	if (sum % 2 != 0) {
    		cout << "NO" << "\n"; continue;
    	}
    	for (int index = 0; index <= scInd; index++) {
    		dp[index][0][0] = 1;
    		for (int w1 = 1; w1 <= sum/2; w1++) {
    			for (int w2 = 1; w2 <= sum/2; w2++) {
    				if (w1 < sc[index] && w2 < sc[index]) {
    					dp[index][w1][w2] = false;
    				} else if (w1 < sc[index]) {
    					dp[index][w1][w2] = dp[index-1][w1][w2-sc[index]];
    				} else if (w2 < sc[index]) {
    					dp[index][w1][w2] = dp[index-1][w1-sc[index]][w2];
    				} else {
    					dp[index][w1][w2] = dp[index-1][w1-sc[index]][w2] || dp[index-1][w1][w2-sc[index]];
    				}
    			}
    		}
    	} 
    	if (debug) {
    		for (int index = 0; index <= scInd; index++) {
	    		for (int w1 = 0; w1 <= sum/2; w1++) {
	    			for (int w2 = 0; w2 <= sum/2; w2++) {
	    				cout << dp[index][w1][w2] << " ";
	    			}
	    			cout << "\n";
	    		}
    		}
    	}
    	if (dp[scInd][sum/2][sum/2] == 1) cout << "YES" << "\n";
    	else cout << "NO" << "\n";
    }
    return 0;
}
