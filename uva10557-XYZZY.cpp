#include <bits/stdc++.h>
using namespace std;

bool canReachDest(int cur) {
	if (cur == N) return true;
	visited[cur] = true;
	bool destReachable = false;
	for (int i = 0; i < conn[cur].size(); i++) {
		if (!visited[conn[cur][i]]) {
			destReachable |= canReachDest(conn[cur][i]);
		}
	}
	return destReachable;
}

bool ford_bellman() {
	for (int i = 0; i <= N; i++) dist[i] = 0;
	dist[1] = 100;
	for (int relax = 0; relax < N-1; relax++) {
		for (int u = 1; u <= N; u++) {
			for (int i = 0; i < conn[u].size(); ++i) {
				int v = conn[u][i];
				if (dist[u] > 0 && dist[v] < dist[u] + energy[v]) {
					dist[v] = dist[u] + energy[v];
				}
			}
		}
	}
	bool hasPositiveCycle = false, destReachable = false;
	for (int u = 1; u <= N; u++) {
		for (int i = 0; i < conn[u].size(); ++i) {
			int v = conn[u][i];
			if (dist[u] > 0 && dist[v] < dist[u] + energy[v]) {
				// hasPositiveCycle = true;
				// destReachable = canReachDest(v);
				// if (hasPositiveCycle && destReachable) return true;
				if (canReachDest(v)) return true;
			}
		}
	}
	return false;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	while (cin >> N) {
		if (N == -1) break;
		for (int i = 1; i <= N; i++) {
			cin >> energy[i];
			cin >> R;
			for (int j = 0; j < R; j++) {
				cin >> nxtRoom;
				conn[i].push_back(nxtRoom);
			}
		}
		bool destReachable = ford_bellman();
		if (dist[N] > 0 || destReachable) cout << "winnable\n";
		else cout << "hopeless\n";
	}
}