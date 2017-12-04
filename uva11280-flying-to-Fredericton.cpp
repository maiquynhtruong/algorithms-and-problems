#include <bits/stdc++.h>
using namespace std;

struct edge {
	int u, v, c;
	edge (int uu, int vv, int cc) {
		u = uu, v = vv, c = cc;
	}
};
void findRoute() {
	for (int i = 0; i <= N; i++) {
		dist[i] = INF;
		minCost[i] = INF;
	}
	dist[1] = 0;
	for (int relax = 1; relax < N; relax++) {
		for (int i = 0; i < edges.size(); i++) {
			int u = edges[i].u, v = edges[i].v, c = edges[i].c;
			if (dist[u] != INF && dist[v] > dist[u] + c) {
				dist[v] = dist[u] + c;
			}
		}
		minCost[relax] = dist[N];
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> T;
	while (T--) {
		cin >> N;
		cin.ignore();
		for (int i = 1; i <= N; i++) {
			cin >> city;
			cities[city] = i;
		}
		cin >> M;
		for (int i = 0; i < M; i++) {
			cin >> from >> to >> cost;
			edges[i].u = cities[from];
			edges[i].v = cities[to];
			edges[i].c = cost;
		}
		findRoute();
		cin >> Q;
		for (int i = 0; i < Q; i++) {
			cin >> query;
			if (minCost[query] == INF) cout << "No satisfactory flights\n";
			else cout << "Total cost of flight(s) is " << minCost[query] << "\n";
		}
	}	
}