#include <bits/stdc++.h>
using namespace std;
int N;
double walkS = 1, trainS = 4; 
struct state {
	int s, d;
	bool operator<(const state &other) const {
		return d < other.d;
	}
	state(int st, double dd) {
		s = st; d = dd;
	}
}
double distance(int s, int e) {
	return sqrt((xtr[s] - xtr[e])*(xtr[s] - xtr[e]) + (ytr[s] - ytr[e])*(ytr[s] - ytr[e]))*60/10000;
}
int dijkstra() {
	dist[0] = 0.0;
	priority_queue<state> pq; 
	pq.push(state(sx, 0.0));
	while(!pq.empty() && train--) { // stations[0] connects with 1 so we need to force it to go further
		int u = pq.top().s;
		double ud = pq.top().d; pq.pop();
		if (u == 1) return ud;
		if (ud > dist[u]) continue;
		for (int i = 0; i < stations[u].size(); i++) {
			double vw = stations[u][i].first;
			int v = stations[u][i].second;
			if (dist[v] < dist[u] + ud) {
				dist[v] = dist[u] + ud;
				pq.push(state(v, vw + ud));
			}
		}
	}
	return -1;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> test;
	while (test--) {		
		cin >> xtr[0] >> ytr[0] >> xtr[1] >> ytr[1];
		double d = distance(0, 1)/walkS;
		stations[0].pb(mp(1, d));
		stations[1].pb(mp(0, d));
		train = 2;
		string lines;
		while (getline(cin, lines)) {
			istringstream sin(lines) {
				int trainLine = 0;
				while (sin >> xtr[train] >> ytr[train]) {
					if (xtr[train] == -1 && ytr[train] == -1) {
						break;
					}
					if (trainLine > 0) {
						d = distance(train, train-1)/trainS;
						stations[train-1].pb(mp(train, d)); 
						stations[train].pb(mp(train-1, d));
					}
					for (int i = 0; i < train; i++) {
						d = distance(train, i)/walkS;
						stations[train].pb(mp(i, d)); 
						stations[i].pb(mp(train, d));	
					}
					train++; trainLine++;
				}
			}
		}
	}
}
