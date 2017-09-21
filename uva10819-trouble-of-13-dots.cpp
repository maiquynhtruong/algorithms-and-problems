#include <bits/stdc++.h> 
#define MEM(a,x) memset(a,x,sizeof(a))  
using namespace std;
int n;
bool debug = true;
string filename = "common_code";
bool checkRepeating(string s, int len, int i) {
	int prev = i - len;
	if (prev < len) return false;
	for (int p1 = i, int p2 = prev; p1 >= prev+1; p1--, p2--) {
		if (s[p1] != s[p2]) return false;
	}
	return true;
}
int main() {
    ifstream cin(filename+".inp");
    // freopen(filename+".out","w",stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    string str;
    while (getline(cin, str) && str[0] != '0') {
    	if (debug) cout << str << "\n";
    	stringstream ss(str);
    	vector<char> vec;
    	char c;
    	while (ss >> c) {
    		vec.push_back(c);
    	}
    	n = vec.size();
    	for (int i = 1; i <= n; i++)
    		for (int j = 1; j <= n; j++)
    			dp[i][j] = 1;
    	for (int len = 1; len < n; len++) { 
	    	for (int i = 1; i+len <= n; i++) {
	    		// for (int j = i; j <= i+len; j++) {
	    		if (checkRepeating(dp, len, i)) dp[len][i] = dp[len][i-len] +1;
	    		// }
	    	}
	    }
    }
}
