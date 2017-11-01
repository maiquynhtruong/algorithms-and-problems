//https://tausiq.wordpress.com/2011/04/01/uva-11624-fire/
//https://github.com/morris821028/UVa/blob/master/volume116/11624%20-%20Fire.cpp
#include <bits/stdc++.h>
using namespace std;
int N, distF[1005][1005], distJ[1005][1005];
char grid[1005][1005];
typedef struct state {
	int x, y, t;
	state(int xx, int yy, int tt) {x = xx; y = yy; t = tt;}
} state; 
void bfsFire(int sx, int sy) {
	queue<state> q;
	q.push(mp(sx, sy));
	distF[sx][sy] = 0;
	while (!q.empty()) {
		state u = q.front(); q.pop();
		for (int d = 0; d < 4; d++) {
			int vx = u.x+dx[d], vy = u.y+dy[d];
			if (grid[vx][vy] == '#') continue;
			if (check(vx, vy)) {
				distF[vx][vy] = u.t+1;
				q.push(state(vx, vy, u.t+1));
			}
		}
	}
}
void bfsJohn(int sx, int sy) {
	queue<pii> q;
	q.push(mp(sx, sy));
	distJ[sx][sy] = 0;
	while (!q.empty()) {
		pii u = q.front(); q.pop();
		for (int d = 0; d < 4; d++) {
			int vx = u.x+dx[d], vy = u.y+dy[d];
			if (grid[vx][vy] == '#') continue;
			if (check(vx, vy)) {
				dist[vx][vy] = u.t+1;
				q.push(state(vx, vy, u.t+1));
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> test;
	int f = 0, j = 0;
	while (test--) {
		cin >> R >> C;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				cin >> grid[i][j];
				if (grid[i][j] == 'F') {siF = i, sjF = j;}
				if (grid[i][j] == 'J') {siJ = i; sjJ = j;}
			}
		}	
		bfsJohn(siJ, sjJ); bfsFire(siF, sjF);
		int minCost = 1e9;
		for (int i = 1; i <= C; i++) {
			if (distF[0][i] < distJ[0][i]) minCost = min(minCost, distJ[0][i]);
			if (distF[R-1][i] < distJ[R-1][i]) minCost = min(minCost, distJ[0][i]);
		}
		for (int i = 1; i <= R; i++) {
			if (distF[i][0] < distJ[i][0]) minCost = min(minCost, distJ[i][0]);
			if (distF[i][C-1] < distF[i][C-1]) minCost = min(minCost, distF[i][C-1]);
			if (minCost == 1e9) cout << "IMPOSSIBBLE\n.";
			else cout << minCost << "\n";
		}
	}
	
}
