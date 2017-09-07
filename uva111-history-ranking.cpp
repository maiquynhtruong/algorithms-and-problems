#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = false;
int c[25], r[25], dp[25];
int n, ch = 0, rank;
int main() {
    ifstream cin("history-ranking.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> ch;
        c[ch] = i;
    }
    string line;
    cin.ignore();
    while(getline(cin, line)) {
        stringstrem ss(line);
        for (int i = 1; i <= n; i++) {
            ss >> r[i];
        }
        dp[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                if (c[r[j]] < c[r[i]] && dp[j]+1 > curMax) curMax = dp[j]+1;
            }
            dp[i] = curMax;
            if (curMax > max) max = curMax;
        }
        cout << max;
    }
}
