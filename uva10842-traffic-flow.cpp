#include <bits/stdc++.h> 
#define LL long long 
#define pii pair<int, int>
using namespace std;
bool debug = false;
int N, n, m, cost, minCost = 10^9;
vector<pii> adj[105];
priority_queue<pii> pq;
void process(int u) {
	vistied[u] = true;
	for (pii v : adj[u]) {
		if (!vistied[v.first]) pq.push_back(make_pair(v.second, v.first));
	}
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n >> m;
    process(0);
    for (int i = 0; i < m; i++) {
    	int u, v, c; cin >> u >> v >> c;
    	adj[u].push_back(make_pair(v, c));
    	adj[v].push_back(make_pair(u, c));
    }
    while (!pq.empty()) {
    	pii next = pq.top(); pq.pop();
    	int w = next.first, v = next.second;
    	if (!vistied[v]) {
    		minCost = min(minCost, w);
    		cost += w; process(v);
    	}
    }

    cout << minCost << "\n";
}
