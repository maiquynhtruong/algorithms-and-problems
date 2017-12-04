// http://lbv-pc.blogspot.com/2012/10/highest-paid-toll.html
#include <bits/stdc++.h>
using namespace std;
int dist[2][N+5];
void dijkstra(int dir, int start, vector<pii> roads) {
	for (int i = 1; i <= N; i++) dist[dir][i] = 1e9;
	priority_queue<int> que;
	que.push(mp(0, start));
	dist[dir][start] = 0;
	while (!que.empty()) {
		int toll = que.top().first, city = que.top().second;
		que.pop();
		if (dist[dir][city] < toll) continue;
		for (int i = 0; i < roads[city].size(); i++) {
			int nxt = roads[city][i].first, nxtToll = roads[city][i].second;
			if (dist[dir][nxt] > nxtToll + toll) {
				dist[dir][nxt] = nxtToll + toll;
				que.push(mp(dist[dir][nxt], nxt));
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> testNum;
	while (testNum--) {
		cin >> N >> M >> S >> T >> P;
		for (int i = 0; i < M; i++) {
			int u, v, c;
			cin >> u >> v >> c;
			roads[u].push_back(mp(v, c));
			reversed[v].push_back(mp(u, c));
		}
		dijkstra(0, S, T, roads);
		dijkstra(1, T, S, reversed);
		maxToll = -1;
		for (int i = 0; i < N; i++) {
			for (for (int j = 0; j < roads[i].size(); j++)) {
				int nxt = roads[i][j].first, toll = roads[i][j].second;
				if (dist[0][i] + toll + dist[1][nxt] <= P) {
					maxToll = max(maxToll, toll);
				}
			}
		}
		cout << maxToll << "\n";
	}
}