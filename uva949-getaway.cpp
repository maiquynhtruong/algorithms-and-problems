#include <bits/stdc++.h> 
#define LL long long 
using namespace std;
struct state{
	int cx, cy, time;
	state(int x, int y, int t) {
		cx = x; cy = y; time = t;
	}
	bool operator<(const state &a) const {
		return time > a.time;
	}
};
int grid[105][105], dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};
bool visited[105][105];
bool check(int x, int y) {
	if (x < 0 || x > NV || y < 0 || y > NH || visited[x][y] || !grid[x][y]) return false;
	return true;
}
int bfs() {
	visited[0][0] = true;
	priority_queue<state> pq;
	pq.push(state(0, 0, 0));
	while (!pq.empty()) {
		int ux = pq.top().cx, uy = pq.top().cy, ut = pq.top().time; pq.pop();
		if (ux == NV-1 && uy == NH) return ut;
		for (int k = 0; k < 4; k++) { 
			int vx = ux+dx[k], vy = uy+dy[k];
			if (!check(vx, vy)) continue;
			if (monitor[vx][vy] == ut) {
				pq.push(state(ux, uy, ut+1));
			} else {
				visited[vx][vy] = 1;
				pq.push(state(vx, vy, ut+1));
			}
		}
	}
	return INF;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> NV >> NH) {
    	cin >> R;
    	for (int i = 0; i < NV; i++) {
    		for (int j = 0; j < NH; j++) {
    			visited[i][j] = false;
    			for (int k = 0; k < 4; k++) grid[i][j][k] = 1;
    		}
    	}
    	for (int i = 1; i <= R; i++) {
    		cin >> x1 >> y1 >> x2 >> y2;
    		for (int k = 0; k < 4; k++) {
    			if (x1+dx[k] == x2 && y1+dy[k] == y2) {
    				grid[x1][y1][k] = 0;
    			}
    		}    		
    	}
    	cin >> M;
    	for (int i = 1; i <= M; i++) {
    		cin >> t >> x >> y;
    		monitor[x][y] = t;
    	}
    }
    cout << bfs() << "\n";
}
