#include <bits/stdc++.h>
using namespace std;
int N, testCase, M;
void bellman_ford(int start) {
	vector<int> dist[N];
	dist[start] = 0;
	for (int i = 0; i < N-1; i++) {
		for (int u = 0; u < N; u++) {
			for (int j = 0; j < adj[u].size(); j++) {
				pii v = adj[u][j];
				dist[v.first] = min(dist[v.first], dist[u] + v.second);
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		cin >> x >> y >> t;
		adj[x].push_back(mp(y, t));
	}
	bellman_ford(0);
	bool hasNegCycle = false;
	for (int u = 0; u < N; u++) {
		for (int j = 0; j < adj[u].size(); j++) {
			pii v = adj[u][j];
			if (dist[v.first] > dist[u] + v.second) {
				hasNegCycle = true;
				break;
			}
		}
	}
	if (hasNegCycle) {
		cout << "possible\n";
	} else {
		cout << "not possible\n";
	}
	return 0;
}