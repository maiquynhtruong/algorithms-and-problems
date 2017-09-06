#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int m;
int n=0, sum=0;
int dp[25][105][105];
int distribute(int sc[25], int index, int w1, int w2) {
    if (dp[index][w1][w2] != -1) return dp[index][w1][w2];
    bool res;
    if (debug) cout << index << ". " << sc[index] << ", " << w1 << ", " << w2 << "\n";
    if (index > n) {
        if (w1 != sum/2 || w2 != sum/2) res = false;
        else res = true;
    }
    else if (sc[index]+w1 > sum/2 && sc[index]+w2 > sum/2) res = false;
    else if (sc[index]+w1 > sum/2) res = distribute(sc, index+1, w1, w2+sc[index]);
    else if (sc[index]+w2 > sum/2) res = distribute(sc, index+1, w1+sc[index], w2);
    else res = distribute(sc, index+1, w1+sc[index], w2) || distribute(sc, index+1, w1, w2+sc[index]);
    dp[index][w1][w2] = res;
    return res;

}
int main() {
    //ifstream cin("luggage.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> m;
    cin.ignore();
    while (m--) {
        sum=0, n=0;
        int s, sc[25];
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
        }
        memset(&dp[0][0][0], -1, sizeof(dp));
        int ans = distribute(sc, 1, 0, 0) || distribute(sc, 1, 0, 0);
        if (ans==1) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}

/**
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
**/
