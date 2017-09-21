#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int t, n, m, k, P[105][105];
int main() {
	ifstream cin("area.inp");
	// freopen("trouble-of-13-dots.out","w",stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> t;
    while(t--) {
    	cin >> n >> m >> k;
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= m; j++) {
    			cin >> P[i][j];
    		}
    	}
    	
    }
}
