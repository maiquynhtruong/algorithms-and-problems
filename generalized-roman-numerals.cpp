#include <bits/stdc++.h> 
#define MEM(a,x) memset(a,x,sizeof(a))  
using namespace std;
int n;
bool debug = true;
// unordered_set<int> dp[55][55];
set<int> dp[55][55];
map<char, int> romans = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}};
int tcase = 1;
int ret[10001000],tot;
void solve(int a, int b, int c) {
	for (auto first : dp[a][b]) {
		for (auto second : dp[b+1][c]) {
			int val;
			if (first < second) val = second - first;
			else val = first + second;
			dp[a][c].insert(val);
			// if (debug) cout << a << ", " << b << ", " << c << ". first= " << first << ", second= " << second << ", val= " << val << "\n";
		}
	}

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
    	vector<char> vec;
    	char c;
    	while (ss >> c) {
    		vec.push_back(c);
    	}
    	n = vec.size();
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= n; j++) {
    			dp[i][j].clear();
    		}
    	}
    	for (int i = 1; i <= n; i++) {
    		// if (debug) cout << romans[vec[i-1]] << " ";
    		dp[i][i].insert(romans[vec[i-1]]);
    	}
    	// if (debug) cout << "\n";
    	for (int len = 1; len <= n; len++) {
    		// if (debug) cout << "len: " << len << "\n";
    		for (int i = 1; i <= n-len; i++) {
    			for (int j = i; j < i+len; j++) {
    				solve(i, j, i+len);
    			}
    			// if (debug) cout << "\n";
    		}
    	}
    	tot = 0;
    	// cout << "Case " << tcase++ << ":";
    	printf("Case %d:", tcase++);
    	for (auto num : dp[1][n]) {
    		// cout << " " << num;
    		printf(" %d", num);
    		// ret[tot++] = num;
    	}
    	// sort(ret,ret+tot);
    	// for(int i = 0; i < tot; ++i) printf(" %d",ret[i]);
    	// cout << "\n";
    	printf("\n");
    }

}
