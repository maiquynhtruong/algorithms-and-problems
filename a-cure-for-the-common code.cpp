#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = false;
bool checkRepeat(string s, int len, int i) {
	int s1 = i - len, e1 = i, s2 = i-2*len, e2 = i-1;
	if (s < len) return false;
	while (e2 > s2) {
		if (s[e2] != s[e1]) return false;
		e2--; e1--;
	}
	return true;
}
int main() {
    ifstream cin("romans_numerals.inp");
    // freopen("romans_numerals.out","w",stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    // cin.ignore();
    string str;
    while (getline(cin, str) && str[0] != '0') {
    	// if (debug) cout << str << "\n";
    	stringstream ss(str);
    	vector<char> vec; char c;
    	while (ss >> c) vec.push_back(c);
    	n = vec.size();
    	int dp[n][n]; // minimum encoding for substring str(i, j)
    	for (int i = 1; i <= n; i++) dp[i][i] = 1;
    	for (int len = 1; len <= n/2; i++) {
	    	for (int i = len; i <= n; i++) {
    			if (checkRepeat(vec, len, i)) {
    				dp[len][i] = dp[len][i-len] + 1;
    			}
	    	}

	    }
}
