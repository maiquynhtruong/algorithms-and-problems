#include <bits/stdc++.h>
using namespace std;
int N, K, f, T[10], elevators[10][105];
struct state {
	int floor, time;
	state(int f, int t) {
		floor = f;
		time = t;
	}
	bool operator<(const state other) const {
		return t < other.t;
	}
}
int dijkstra(priority_queue<state> pq, int startElevator) {
	dist[0] = 0;
	pq.push(state(0, 0));
	while(!pq.empty()) {
		int time = pq.top().time, floor = pq.top().floor;
		pq.pop();
		if (floor == K) return dist[floor];
		if (time > dist[floor]) continue;
		for (int nxt = 0; nxt <= elevators[floor].size(); nxt++) {
			pii nxtFloor = elevators[floor][nxt];
			int wt = nxtFloor.first, nxtF = nxtFloor.second;
			if (dist[nxtF] < dist[floor] + switchTime + wt) {
				dist[nxtF] = dist[floor] + switchTime + wt;
				pq.push(state(nxt, dist[nxtF]));
			}
		}
	}
	return dist[K];
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	while (cin >> N >> K) {
		for (int i = 1; i <= N; i++) {
			cin >> T[i];
		}
		for (int i = 1; i <= N; i++) {
			string fstr; 
			cin >> fstr;
			istringstream sin(fstr);
			int fnum = 0;
			while (sin >> stops[fnum++]); fnum--;
			for (int f = 0; f < fnum; f++) {
				for (int fn = f; fn < fnum; fn++) {
					elevators[stops[f]].pb(mp(fn, T[i]*(stops[fn]-stops[f])));
					elevators[stops[fn]].pb(mp(f, T[i]*(stops[f]-stops[fn])));
				}
			}
		}
		int ans = INF;
		ans = dijkstra();
		if (ans == INF) cout << "IMPOSSIBLE\n"; 
		else cout << ans << "\n";
	}
}
