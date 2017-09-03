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
            neighbors[0].push_back(1);
            neighbors[1].push_back(0);
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
