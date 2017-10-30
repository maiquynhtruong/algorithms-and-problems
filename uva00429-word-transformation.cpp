#include <bits/stdc++.h> 
using namespace std;
#define pii pair<int, int>
#define INF 1e9
bool debug = true;
string strs[205], f, s;
vector<pair<string, string>> words;
map<string, vector<string>> adj;
map<string, int> dist;
int sz, test;
int countDiff(string a, string b) {
	if (a.size() == b.size()) {
		int cnt = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a[i] != b[i]) cnt++;
		}
		return cnt;
	}
	return max(a.size(), b.size());
}
int main() {
    ifstream cin("input.inp");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> test;
    while (test--) {
    	while (cin >> strs[sz] && strs[sz][0] != '*') sz++;
    	while (cin >> f >> s) {
    		words.push_back(make_pair(f, s));
    	}
    	for (int i = 0; i < sz; i++) {
    		for (int j = i+1; j < sz; j++) {
    			if (countDiff(strs[i], strs[j]) == 1) {
    				adj[strs[i]].push_back(strs[j]); adj[strs[j]].push_back(strs[i]);
    			} 
    		}
    	}
    	for (int w = 0; w < words.size(); w++) {
    		string start = words[w].first, target = words[w].second;
    		dist[start] = 0;
    		queue<string> q; q.push(start);
    		while (!q.empty()) {
    			string fWord = q.front(); q.pop();
    			for (int next = 0; next < adj[fWord].size(); next++) {
    				string nWord = adj[fWord][next];
    				if (dist[nWord] == INF) {
    					dist[nWord] = dist[fWord] + 1;
    					if (nWord == target) {cout << start << " " << target << " " << dist[nWord] << "\n"; return 0;}
    					q.push(nWord);
    				}
    			}
    		}	
    	}
    	
    }
}
