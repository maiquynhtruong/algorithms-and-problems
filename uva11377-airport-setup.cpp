#include <bits/stdc++.h>
using namespace std;
int bfs(int start, int end) {
	queue<pii> que;
	que.push_back(mp(airports[start], start));
	int dist[N];
	for (int i = 0; i <= N; i++) dist[i] = -1e8 + 9;
	dist[start] = 0;
	while (!que.empty()) {
		int city = que.front().first;
		que.pop();
		if (city == end) return dist[end];
		for (int c = 0; c < cities[city].size(); c++) {
			int nxt = cities[city].[c];
			if (dist[nxt] > dist[city] + airports[nxt]) {
				dist[nxt] = dist[city] + airports[nxt];
				que.push(nxt);
			}
		}
	}
	return -1;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> testNum;
	while (testNum--) {
		cin >> N >> M >> K;
		int airports[N] = {0};
		for (int i = 1; i <= K; i++) {
			cin >> c;
			airports[c] = 1;
		}
		for (int i = 1; i <= M; i++) {
			int a, b; cin >> a >> b;
			cities[a].push_back(b);
			cities[b].push_back(a);	
		}
		cin >> Q;
		for (int i = 1; i <= Q; i++) {
			int x, y; cin >> x >> y;
			if (x == y) cout << "0\n";
			else {
				int ans = bfs(x, y);
				cout << ans << "\n";				
			}
			cout << "\n";
		}
	}
}