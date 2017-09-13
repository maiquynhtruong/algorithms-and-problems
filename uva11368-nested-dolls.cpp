#include <bits/stdc++.h> 
using namespace std;
bool debug = true;
int m, testcases, car;
int LIS[20005], dolls[20005][3];
int main() {
    ifstream cin("nested_dolls.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> testcases;
    while (testcases--) {
    	cin >> m;
    	for (int i = 1; i <= m; i++) {
    		int w, h;
    		cin >> w >> h;
    		dolls[i][1] = w; dolls[i][2] = h;
    	}
    	sort(dolls, dolls+m);
    	LIS[1] = 1;
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j < i; j++) {
    			if (dolls[j][2] < dolls[i][2] && LIS[j]+1 > LIS[i]) {
    				LIS[i] = LIS[j]+1;
    			}
    		}
    	}
    	sort(LIS, LIS+m);
    	int ans = 0, i = 1;
    	while (m > 0) {
    		ans++;
    		m -= LIS[i++];
    	}
    	cout << ans << "\n";
    }

}
