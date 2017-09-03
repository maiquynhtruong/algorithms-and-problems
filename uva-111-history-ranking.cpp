#include <iostream>
int c[21], r[21];
int main() {
    int n, ch = 0, rank;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &ch);
        c[ch] = i;
    }
    while(scanf("%d", &r[1]) == 1) {
        for (int i = 2; i <= n; i++) {
            scanf("%d", &r[i]);
        }
        int dp[n+1];
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
        printf("highest is %d", max);
    }
}
