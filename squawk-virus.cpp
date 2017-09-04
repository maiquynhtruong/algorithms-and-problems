#include <iostream>
#include <vector>
using namespace std;
int a[11][101];
vector< vector<int> > neighbors(10);
int main() {
	int n, m, s, time;
	scanf("%d %d %d %d", &n, &m, &s, &time);
        for (int link = 1; link <= m; link++) {
            int u, v;
            scanf("%d %d", &u, &v);
            neighbors[u].push_back(v);
            neighbors[v].push_back(u);
        }
        a[0][s] = 1;
	for (int t = 1; t <= time; t++) {
            for (int user = 0; user < n; user++) {
                if (a[t-1][user] > 0) {
                    for (int u = 0; u < neighbors[user].size(); u++) {                 
                        a[t][neighbors[user][u]] += a[t-1][user];
                    }
                }
                printf("%d ", a[t][user]);
            }
            printf("\n");

        }
        printf("\n");
        int ans = 0;
        for (int u = 0; u < n; u++) {
            ans += a[time][u];
            printf("%d ", a[time][u]);
        }
        printf("\n");
        printf("%d\n", ans);
}
=====================================================Better version=========================================================
#include <bits/stdc++.h> // for all the libraries
using namespace std;
long long a[11][101]; // should declare globally
vector<int> neighbors[101]; // declare as array for fixed length and vector for dynamic length
int n, m, s, tim; // declare these globally in case writing more methods

int main() {
    ifstream cin("squawk.inp"); // take input from a file in the same directory
    ios_base::sync_with_stdio(false); // these two lines will make cin, cout run as fast as scanf and printf
    cin.tie(NULL); // this one too 
    cin >> n >> m >> s >> tim; // use cin so don't have to worry about the format of the input
    for (int lnk = 1; lnk <= m; lnk++) {
        int u, v;
        cin >> u >> v;
        //scanf("%d %d", &u, &v);
        neighbors[u].push_back(v);
        neighbors[v].push_back(u);
    }
    a[0][s] = 1;
	for (int t = 1; t <= tim; t++) {
        for (int user = 0; user < n; user++) {
            if (a[t-1][user] > 0) {
                for (int u = 0; u < neighbors[user].size(); u++) {                 
                    a[t][neighbors[user][u]] += a[t-1][user];
                }
            }
        }
    }
    long long ans = 0;
    for (int u = 0; u < n; u++) {
        ans += a[tim][u];
    }
    cout << ans << "\n";
}
