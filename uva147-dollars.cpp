#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = false;
double amount;
int a, denominations = 12, dp[30005];
int c[12] = {0, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
int main() {
    //ifstream cin("dollars.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    while (cin >> amount && amount != 0) {
    	a = amount*100;
    	for (int j = 1; j <= denominations; j++) dp[c[j]] = 1;
    	for (int i = 1; i <= a; i++) {
    		for (int j = 1; j <= denominations; j++) {
    			if (c[j] <= i && dp[i-c[j]] > 0) dp[i]++;
    		}
    	}
    	cout << dp[a] << "\n";
    }
}
