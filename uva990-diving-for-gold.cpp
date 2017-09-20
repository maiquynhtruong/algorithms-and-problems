#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int ti, w, n, d[35], v[35], dp[35][1005];
int main() {
	//ifstream cin("diving-for-gold.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> ti >> w) {
    	cin >> n;
    	for (int i = 1; i <= n; i++) {
    		cin >> d[i] >> v[i];
    		if (debug) cout << d[i] << " " << v[i] << "\n";
    	}
    	for (int i = 0; i <= n; i++) fill(dp[i], dp[i]+ti+5, 0);
    	for (int i = 1; i <= n; i++) {
    		for (int t = 0; t <= ti; t++) {
    			dp[i][t] = dp[i-1][t];
    			if (w*d[i]*3 <= t && dp[i-1][t-3*w*d[i]] + v[i] > dp[i][t]) {
    				dp[i][t] = dp[i-1][t-3*w*d[i]] + v[i];
    			}
    		}
    	}
    	if (debug) {

    		for (int i = 1; i <= n; i++) {
    			for (int t = 0; t <= ti; t++) {
    				cout << dp[i][t] << " ";
    			}
    			cout << "\n";
    		}
    	}
    	int i = n, t = ti, sum = 0;
    	vector<pair<int, int> > treasures;
    	while (i > 0) {
    		if (dp[i][t] != dp[i-1][t]) {
    			if (debug) cout << d[i] << " " << v[i] << "\n";
    			treasures.push_back(make_pair(d[i], v[i]));
    			t -= 3*w*d[i];
    		}
    		i--;
    	}
    	cout << dp[n][ti] << "\n" << treasures.size() << "\n";
    	for (int tr = treasures.size()-1; tr >= 0; tr--) {
    		cout << treasures[tr].first << " " << treasures[tr].second << "\n";
    	}
    }
}
