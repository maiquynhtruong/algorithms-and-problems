//http://cathon.github.io/2014/12/05/UVA-314/
#include <bits/stdc++.h> 
#define LL long long 
using namespace std;
int sx, sy, ex, ey, grid[55][55], dx[]={-1, 0, 1, 0}, dy={0,-1,0,1};
bool visited[55][55][5];1
string direction;
struct state {
	int x, y, d, t;
	state(int xx, int yy, int dd): x(xx), y(yy), d(dd){}
};
bool check(struct state v) {
	if (v.x < 0 || v.x >= N || v.y < 0 || v.y >= M) return false;
	return true;
}
void bfs() {
	queue<struct state> q;
	struct state u, v;
	u.x = sx; u.y = sy; u.d = sd; u.t = st;
	q.push(u);
	
	while (!q.empty()) {
		u = q.front(); q.pop();
		for (int dir = 0; dir < 4; dir+=2) { // turn left and right
			v.x = u.x; v.y = u.y; v.d = (u.d+dir)%4; v.t = u.t+1;
			if (!visited[v.x][v.y][v.d]) q.push(v);
			visited[v.x][v.y][v.d] = true;
		}
		for (int k = 1; k <= 3; k++) {
			v.x = u.x + k*dx[u.d]; v.y = u.y + k*dy[u.d]; v.d=u.d; v.t = u.t+1;
			if (!check(v)) continue;	2
			if (grid[v.x][v.y]) break; // diameter is 1.6 so cannot move here even no obstacle
			if (v.x == ex && v.y == ey) return v.t;		
			if (!visited[v.x][v.y][v.d]) { q.push(mp(vx, vy)); }	
			visited[v.x][v.y][v.d] = true;
		}
	}
	return -1;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> N >> M) {
    	if (N == 0 && M == 0) break;
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= M; j++) {
    			cin >> grid[i][j];
    			if (grid[i][j]) {
    				grid[i][j+1] = grid[i][j-1] = grid[i+1][j+1] = 1;
    			}
    		}
    	}
    	cin >> sx >> sy >> ex >> ey >> direction;
    	if (direction == "north") sd = 0; 
    	else if (direction == "west") sd = 1;
    	else if (direction == "south") sd = 2;
    	else if (direction == "east") sd = 3;
    	int ans = bfs();
    	cout << ans << "\n";
    }
}
