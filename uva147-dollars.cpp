#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = true;
double amount;
int a, denominations = 11;
long dp[30005];
int c[12] = {0, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
int main() {
    ifstream cin("dollars.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    while (cin >> amount && amount > 0) {
    	a = amount*100;
        // if(debug) for (int j = 1; j <= denominations; j++) cout << c[j] << ", ";
    	for (int j = 0; j <= denominations; j++) dp[c[j]] = 1;
    	for (int i = 1; i <= a; i++) {
    		for (int j = 1; j <= denominations; j++) {
    			if (c[j] < i && i%c[j] == 0 && dp[i-c[j]] > 0) {
                    
                    dp[i] += dp[i-c[j]];
                    if (debug) cout << i << " " << c[j] << " " << dp[i-c[j]] << " " << dp[i] << "\n";
                }
    		}
    	}
        if (debug) cout << "ans: ";
    	cout << a << " " << dp[a] << "\n";
    }
}
