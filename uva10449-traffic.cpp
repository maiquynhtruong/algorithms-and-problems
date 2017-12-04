#include <bits/stdc++.h>
using namespace std;
// first style called SPFA (shortest path faster algorithm)
void ford_bellman() {
	for (int i = 0; i <= N; i++) dist[i] = INF;
	dist[1] = 0;
	queue<int> q; 
	q.push(1);
	int in_queue[N]; in_queue[1] = 1;
	while (!q.empty()) {
		int u = q.front(); q.pop(); in_queue[u] = 0;
		for (int i = 0; i < roads[u].size(); i++) {
			int v = roads[u][i].first, w = roads[u][i].second;
			if (dist[v] > dist[u] + w) {
				dist[v] = dist[u] + w;
				if (!in_queue[v]) {
					if (++cntEnterQueue[v] >= N) { // graph has negative cycle
						queue<int> negQueue; // store the negative cycle
						negQueue.push(v);
						negCycle[v] = 1;
						while (!negQueue.empty()) {
							int cur = negQueue.front(); negQueue.pop();
							dist[cur] = -INF; // mark any vertex in the cycle as negative infinity distance
							for (int j = 0; j < roads[cur]; j++) {
								int nxt = roads[cur][j].first;
								if (negCycle[nxt] == 0) {
									negCycle[nxt] = 1; // mark that vertex in a negative cycle
									negQueue.push(nxt);
								}
							}
						}
					}
					if (negCycle[v] == 0) {
						in_queue[v] = 1;
						q.push(v);	
					}
				}
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	while (cin >> N) {
		for (int i = 1; i <= N; i++) {
			cin >> junc[i];
		}
		cin >> R;
		for (int i = 0; i < R; i++) {
			cin >> u >> v;
			int f = junc[v]-junc[u], b = junc[u]-junc[v];
			roads[u].push_back(mp(v, f*f*f));
			roads[v].push_back(mp(u, b*b*b));
		}
		cin >> Q;
		ford_bellman();
		for (int i = 0; i < Q; i++) {
			cin >> end;
			if (end < 0 || end > N || dist[end] < 3 || dist[end] == INF) cout << "?\n";
			else cout << dist[end] << "\n";
		}
	}
}

// second style using struct edge
struct edge {
	int u, v, c;
	edge(int _u, int _v, int _c) {
		u = _u; v = _v; c = _c;
	}
}

void ford_bellman_edge() {
	for (int i = 0; i <= N; i++) dist[i] = INF;
	dist[1] = 0;
	for (int k = 0; k < N-1; k++) {
		bool isUpdated = false;
		for (int i = 0; i < R; i++) {
			if (dist[edges[i].u] != INF && dist[edges[i].v] > dist[edges[i].u] + edges[i].c) {
				dist[edges[i].v] > dist[edges[i].u] + edges[i].c;
				isUpdated = true;
			}
		}
		if (!isUpdated) break;
	}
	// when you detect an edge on a negative cycle in the Nth relaxation, it means that all vetices reachable from these two vetex (on this edge) can be reduce to -infinity
	// so this looks for that edge and mark those reachable from it -INF
	for (int i = 0; i < R; i++) {
		if (dist[edges[i].u] != INF && dist[edges[i].v] > dist[edges[i].u] + edges[i].c) {
			dist[edges[i].v] = -INF;
		}
	}
}
struct edge edges[R];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	while (cin >> N) {
		for (int i = 1; i <= N; i++) {
			cin >> junc[i];
		}
		cin >> R;
		for (int i = 0; i < R; i++) {
			cin >> edges[i].u >> edges[i].v;
			int f = junc[v]-junc[u];
			edges[i].c = f*f*f;
		}
		cin >> Q;
		ford_bellman_edge();
		for (int i = 0; i < Q; i++) {
			cin >> end;
			if (dist[end] < 3 || dist[end] == INF) cout << "?\n";
			else cout << dist[end] << "\n";
		}
	}
}