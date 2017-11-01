#include <bits/stdc++.h> 
using namespace std;
bool debug = false;
int n, d, test, dis[505][505];
char c;
vector<string> keys;
void process(int v) {
	visited[v] = true;
	for (int i = 0; i < n; i++) {
		if (i != v && !visited[i]) pq.push(make_pair(dis[v][i], i));
	}
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> test;
    while (--test) {
    	cin >> n;
    	for (int i = 0; i < n; i++) {
    		string s = "";
    		for (int j = 0; j < 4; j++) {cin >> c; s += c;}
    		keys.push_back(s);
    	}
    	for (int i = 0; i < n; i++) {
    		for (int j = i; j < n; j++) {
    			int cost = 0;
    			for (int d = 0; d < 4; d++) {
    				int minDis = min(abs(keys[i][d] - keys[j][d]), 10 - abs(keys[i][d]-keys[j][d]));
    				cost += minDis;
    			}
    			dis[i][j] = cost; dis[j][i] = cost;
    		}
    	}
    }
}
