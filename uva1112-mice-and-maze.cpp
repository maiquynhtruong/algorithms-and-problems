#include <bits/stdc++.h> 
#define LL long long 
#define INF 1e9
using namespace std;
int test, N, E, T, M;
priority_queue<pii, vector<pii>, greater<pii>> pq;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> test;
    while (test--) {
    	cin >> N >> E >> T >> M;
    	for (int i = 1; i <= M; i++) {
    		cin >> a >> b >> w;
    		adj[a].push_back(mp(w, b));
    	}
    	for (int i = 1; i <= N; i++) { dist[i] = INF; }
    	dist[E] = 0;
    	pq.push();
    	while (!pq.empty()) {
    		pii pu = pq.top(); pq.pop();
    		int d = pu.first, u = pu.second;
    		if (d > dist[u]) continue;
    		for (int i = 0; i < adj[u].size(); i++) {
    			pii v = adj[u][i];
    			if (dist[v.first] > dist[u] + v.second) {
    				dist[v.first] = dist[u] + v.second;
    				pq.push(mp(dist[v.first], v.first));
    			}
    		}
    	}
    	int cnt = 0;
    	for (int i = 1; i <= N; i++) {
    		if (dist[i] <= T) cnt++;
    	}
    	cout << cnt << "\n";;
    }
}
