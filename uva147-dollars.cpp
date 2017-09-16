#include <bits/stdc++.h> 
using namespace std;
#define N 30005
// global variables
bool debug = false;
double amount;
int denominations = 11;
long long dp[N];
int c[12] = {0, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
int main() {
    ifstream cin("dollars.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    dp[0]=1;
    for (int j = 1; j <= denominations; j++) {
        for (int i = c[j]; i <= N; i++) {
            dp[i] += dp[i-c[j]];
        }
        if (debug) {
            for (int i = 1; i <= N; i++) cout << i << " ";
            cout << "\n";
            for (int i = 1; i <= N; i++) cout << dp[i] << " ";
            cout << "\n";    
        }
        
    }
    cout << fixed << right << showpoint;
    while (cin >> amount && amount > 0) { 
        unsigned int a = (unsigned) ((amount+0.001)*100);
    	cout << setw(6) << setprecision(2) << amount << setw(17) << dp[a] << "\n";
    }
}
