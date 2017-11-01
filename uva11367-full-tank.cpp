//https://github.com/morris821028/UVa/blob/master/volume113/11367%20-%20Full%20Tank.cpp
#include <bits/stdc++.h> 
#define LL long long 
#define pii pair<int, int>
#define mp make_pair
#define INF 1e9
using namespace std;
struct state{
	int fuel, city, cost;
	state(int c, int f, int co): fuel(f), city(c), cost(co) {}
	bool operator<(const state &a) const {
		return cost > a.cost;
	}
};
int dist[1005][105], S, E, C;
vector<pii> adj[1005];
void dijkstra() {
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j <= C; j++) dist[i][j] = INF;
	}
	priority_queue<state> pq; pq.push(state(S, 0, 0));
	dist[S][0] = 0;
	while (!pq.empty()) {
		struct state u = pq.top(); pq.pop();
		if (u.city == E) { return u.cost; }
		for (pii v : adj[u.city]) {
			if (u.fuel >= v.second) {
				if (dist[v.first][u.fuel-v.second] > dist[u.city][u.fuel]) {
					dist[v.first][u.fuel-v.second] = dist[u.city][u.fuel];
					pq.push(state(v.first, u.fuel-v.second, dist[u.city][u.fuel]));
				}
			}
		}
		if (u.fuel < C && dist[u.city][u.fuel] + p[u.city] < dist[u.city][u.fuel+1]) {
			dist[u.city][u.fuel+1] = dist[u.city][u.fuel] + p[u.city];
			pq.push(state(u.city, u.fuel+1, u.cost + p[u.city]));
		}
	}
	return -1;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
    	cin >> p[i]; adj[i].clear();
    }
    for (int i = 1; i <= M; i++) {
    	cin >> u >> v >> w;
    	adj[u].push_back(mp(v, w)); adj[v].push_back(mp(u, w));
    }
    cin >> Q;
    for (int q = 0; q < Q; q++) {
    	cin >> C >> S >> E;
    	int ans = dijkstra();
    	if (ans == -1) cout << "Impossible\n";
    	else cout << ans << "\n";	
    }
    
    return 0;
}
