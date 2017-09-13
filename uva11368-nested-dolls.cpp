#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int m, testcases, car;
int LIS[20005], cnt[20005];
int main() {
    //ifstream cin("nested_dolls.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> testcases;
    while (testcases--) {
    	cin >> m;
	vector< pair<int, int> > dolls;
    	dolls.push_back(make_pair(0, 0));
    	for (int i = 1; i <= m; i++) {
    		int w, h;
    		cin >> w >> h;
    		dolls.push_back(make_pair(w, h));
    		LIS[i] = 1; cnt[i] = 0;
    	}
    	
    	if (debug) {
    		for (int i = 1; i <= m; i++) 
    		cout << "(" << dolls[i].first << ", " << dolls[i].second << ") ";
    		cout << "\n";
    	}
    	sort(dolls.begin(), dolls.end());
    	LIS[1] = 1;
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j < i; j++) {
    			if (dolls[j].first < dolls[i].first && 
    			dolls[j].second < dolls[i].second && 
    			LIS[j]+1 > LIS[i]) {
    				LIS[i] = LIS[j]+1;
    			}
    		}
    	}
    	if (debug) {
    		for (int i = 1; i <= m; i++) cout << LIS[i] << " ";
    		cout << "\n";
    	}
    	sort(LIS, LIS+m);
    	for (int i = 1; i <= m; i++) cnt[LIS[i]]++;
    	if (debug) {
    		for (int i = 1; i <= m; i++) cout << cnt[i] << " ";
    		cout << "\n";
    	}
    	int ans = 0, num = m;
    	while (num > 0) {
	    	ans++;
	    	for (int i = 1; i <= m; i++) {
	    		if (cnt[i] > 0) {num--; cnt[i]--;}
	    	}
    	}
    	cout << ans << "\n";
    }

}
