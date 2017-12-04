// elegant solution: https://github.com/morris821028/UVa/blob/master/volume109/10967%20-%20The%20Great%20Escape%5BAccept%5D.cpp
// and http://blog.csdn.net/chenchaoflight/article/details/8757813
#include <bits/stdc++.h>
using namespace std;
vector<char> grid[];
int ans;
struct state {
	int x, y, c;
	struct state(int xi, int yi, int ci) {
		x = xi; y = yi; c = ci;
	}
	bool operator<(const state &other) const {
		return c > other.c;
	}
};
bool isOutOfBounds(int x, int y) {
	return !(x < 0 || x >= M || y < 0 || y >= N);
}
int rotations(char d, int di) {
	if (d == 'N') { // d == 0
		if (di == 0) return 0; else if (di == 1 || di == 3) return 1; else if (di == 2) return 2;
	}
	if (d == 'E') { // d == 1
		if (di == 1) return 0; else if (di == 2 || di == 0) return 1; else if (di == 3) return 2;
	}
	if (d == 'S') { // d == 2
		if (di == 2) return 0; else if (di == 1 || di == 3) return 1; else if (di == 0) return 2;
	}
	if (d == 'W') { // d == 3
		if (di == 3) return 0; else if (di == 2 || di == 0) return 1; else if (di == 1) return 2;
	}
}
void dijkstra(int xs, int ys, int xe, int ye) {
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			dist[i][j] = INF; 
			visited[i][j] = false;
		}
	}
	ans = INF;
	priority_queue<state> q;
	q.push(state(xs, ys, 0));
	dist[xs][ys] = 0;
	while (!q.empty()) {
		int curX = q.front().x, curY = q.front().y, curC = q.front().c;
		if (visited[nxtX][nxtY]) continue;
		visited[nxtX][nxtY] = true;
		if (curX == xe && curY == xy) ans = min(ans, curC);
		if (grid[curX][curY] == '#' || isOutOfBounds(nxtX, nxtY)) continue;
		if (grid[curX][curY] == '.') {
			for (int i = 0; i < 4; i++) {
				int nxtX = curX + dirX[i], nxtY = curY + dirY[i];
				if (grid[nxtX][nxtY] == '#' || isOutOfBounds(nxtX, nxtY)) continue;
				if (grid[nxtX][nxtY] == '.' || grid[nxtX][nxtY] == 'N' && i == 0 || grid[nxtX][nxtY] == 'E' && i == 1 || grid[nxtX][nxtY] == 'S' && i == 2 || grid[nxtX][nxtY] == 'W' && i == 3) {
					if (dist[nxtX][nxtY] > dist[curX][curY] + 1) {
						dist[nxtX][nxtY] = dist[curX][curY] + 1;
						q.push(state(nxtX, nxtY, dist[nxtX][nxtY]));
					}
				}
			}	
		} else { // rotating door
			for (int i = 0; i < 4; i++) {
				int nxtX = curX + dirX[i], nxtY = curY + dirY[i], cost = D[curX][curY]*rotations(grid[curX][curY], i);
				if (grid[nxtX][nxtY] == '#' || isOutOfBounds(nxtX, nxtY)) continue;
				if (grid[nxtX][nxtY] == '.' || grid[nxtX][nxtY] == 'N' && i == 0 || grid[nxtX][nxtY] == 'E' && i == 1 || grid[nxtX][nxtY] == 'S' && i == 2 || grid[nxtX][nxtY] == 'W' && i == 3) {{
					if (dist[nxtX][nxtY] > dist[curX][curY] + 1 + cost) {
						dist[nxtX][nxtY] = dist[curX][curY] + 1 + cost;
						q.push(state(nxtX, nxtY, dist[nxtX][nxtY]));
					}
				}
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> testNum; 
	while (testNum--) {
		cin >> M >> N;
		for (int i = 0; i < M; i++) {
			getline(cin, grid[i]);
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] != '.' && grid[i][j] != '#') {
					cin >> D[i][j];
				}
			}
		}
		dijkstra(M-1, 0, 0, N-1);

	}
}