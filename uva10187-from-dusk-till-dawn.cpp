//https://yousefhadder.wordpress.com/2014/07/05/10187-from-dusk-till-dawn/
// excellent technique to learn
#include <bits/stdc++.h>
using namespace std;
map<string, int> stops;
vector<state> routes[105];
int ind, testCase = 0, testNum;	
struct state {
	int startT, endT, endD;
	state(int eD, int sT, int eT) {
		endD = ed; startT = sT; endT = eT;
	}
}
int distance(int prevEnd int curStart) {
	if (prevEnd == -1) return 0;
	if (prevEnd == curStart) return 0;
	if (prevEnd >= 18 && prevEnd <= 24) {
		return !(curStart > prevEnd && curStart <= 24 || curStart < 6);
	}
	if (prevEnd >= 1 && prevEnd <= 6) {
		return !(curStart > prevEnd && curStart <= 6);
	} 
}
int bfs(int src, int des) {
	queue<pair<int, int>> q;
	vector<int> dist(105, 1e9)l
	dist[src] = 0;
	q.push(make_pair(src, -1));
	while (!q.empty()) {
		int u = q.front().first, uPrev = q.front().second;
		q.pop();
		for (int i = 0; i < routes[u].size(); i++) {
			state v = routes[u][i];
			int nxtStop = v.endD, startStop = v.startT, endStop = v.endT;
			if (dist[nxtStop] > dist[u] + distance(uPrev, startStop)) {
				dist[nxtStop] = dist[u] + distance(uPrev, startStop);
				q.push(make_pair(nxtStop, endStop));
			}
		}	
	}
	
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> testNum;
	while (testNum--) {
		cin >> N;
		ind = 0;
		for (int i = 1; i <= N; i++) {
			cin >> startD >> endD >> startT >> endT;
			endT = (startT + endT) % 24;
			if ((startT >= 6 && startT < 18) || (endT > 6 && endT <= 18)) continue;
			if (!stops[startD]) {
				stops[startD] = ++ind;
			} 
			if (!stops[endD]) {
				stops[endD] = ++ind;
			}
			routes[stops[startD]].push_back(state(stops[endD], startT, endT));
		}
		cin >> start >> goal;
		cout << "Test Case " << ++testCase << ".\n";
		if (start == goal) {
			cout << "Vladimir needs 0 litre(s) of blood." << "\n";
		} else {
			int ans = bfs(stops[start], stops[end]);
			if (ans == -1) {
				cout << "There is no route Vladimir can take.\n";
			} else {
				cout << "Vladimir needs " << ans << " litre(s) of blood.\n";
			}
		}
	}
}

/*
struct state {
	int startT, endT;
	string endD;
	state(string eD, int sT, int eT) {
		endD = ed; startT = sT; endT = eT;
	}
}
int dijkstra(priority_queue<state> pq, string des) {
	dist[dest] = 0;
	while(!pq.empty()) {
		string curStop = pq.top().endD;
		int curEndT = pq.top().endT;
		pq.pop();
		if (curStop == goal) return dist[curStop]/24;
		for (int nxt = 0; nxt <= adj[curStop].size(); nxt++) {
			state nxtD = adj[eDest][nxt];
			int nxtEndT = nxtD.endT, nxtStartT = nxtD.startT, nxtDur = nxtD.endT - nxtD.startT;
			string nxtStop = nxtD.endD;
			if (nxtStartT >= curEndT % 24)  {
				if (dist[nxtStop] > dist[curStop] + nxtStartT - curEndT + nxtDur) {
					dist[nxtStop] = dist[curStop] + nxtStartT - curEndT + nxtDur;
					pq.push(state(nxtStop, nxtStartT, nxtEndT));
				}
			} else {
				if (dist[nxtStop] > dist[curStop] + 24 + nxtStartT - curEndT + nxtDur) {
					dist[nxtStop], dist[curStop] + 24 + nxtStartT - curEndT + nxtDur;
					pq.push(state(nxtStop, nxtStartT, nxtEndT));
				}
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
		cin >> N;
		for (int i = 1; i <= N; i++) {
			cin >> startD >> endD >> startT >> endT;
			int endT += startT;
			if (startT >= 18 && (endT % 24 <= 6)) adj[startD].push_back(state(endD, startT, endT));
		}
		cin >> start >> goal;
		for (int i = 0; i < adj[start].size(); i++) {
			priority_queue<state> pq;
			state s = adj[start][i];
			pq.push(state(s.endD, s.startT, s.endT));
			ans = min(ans, dijkstra(pq, s.endD));
		}
	}
}
*/
