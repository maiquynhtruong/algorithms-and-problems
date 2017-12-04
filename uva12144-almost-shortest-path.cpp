//https://github.com/Hikari9/UVa/blob/master/12144%20-%20Almost%20Shortest%20Path.cpp
#include <bits/stdc++.h>
using namespace std;
int dist[N+5];
void dijkstra(int start, int end) {
	for (int i = 1; i <= N; i++) dist[i] = 1e9;
	priority_queue<int> que;
	que.push(mp(0, start));
	dist[start] = 0;
	while (!que.empty()) {
		int price = que.top().first, cur = que.top().second;
		que.pop();
		if (dist[cur] < price) continue;
		for (int i = 0; i < roads[cur].size(); i++) {
			int nxt = roads[cur][i].first, nxtPrice = roads[cur][i].second;
			if (dist[nxt] > nxtPrice + price) {
				dist[nxt] = nxtPrice + price;
				parents[nxt].clear();
				parents[nxt].push_back(cur);
				que.push(mp(dist[nxt], nxt));
			} else if (dist[nxt] == nxtPrice + price) {
				parents[nxt].push_back(cur);
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	while (cin >> N >> M) {
		if (N == 0 && M == 0) break;
		cin >> S >> D;
		for (int i = 0; i < M; i++) {
			int u, v, p;
			cin >> u >> v >> p;
			roads[u].push_back(mp(v, p));
		}
		parents[S] = NULL;
		dijkstra(S, D);
		int node = D;
		queue<int> q;
		while (!q.empty()) {
			int cur = q.front(); 
			q.pop();
			for (int i = 0; i < parents[cur].size(); i++) {
				q.push(parents[cur][i]);
				roads[parents[cur][i]].remove(cur);
			}
		}
		// run dijkstra again
		int len = dijkstra(S, D);
		cout << len << "\n";
	}
}