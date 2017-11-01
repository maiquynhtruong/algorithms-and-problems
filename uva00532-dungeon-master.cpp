#include <bits/stdc++.h> 
#define LL long long 
using namespace std;
int R, C, L;
int grid[35][35][35], dx[] = {-1, 0, 1, 0, 0, 0}, dy[] = {0, -1, 0, 1, 0, 0}, dz[] = {0, 0, 0, 0, -1, 1};
bool check(vector<int> v) {
	if (v[0] < 0 || v[0] >= L || v[1] < 0 || v[1] >= R || v[2] < 0 || v[2] >= C) return false;
	if (ch[v[0]][v[1]][v[2]] == '#') return false;
	return true;
}
void bfs() {
	queue<vector<int>> q;
	vector<int> start; start.push_back(sl); start.push_back(si); start.push_back(sj); 
    q.push(start);
	map<vector<int>, int> dist;
	dist[start] = 0;
	while (!q.empty()) {
		vector<int> cur = q.front(); q.pop();
		for (int d = 0; d < 6; d++) {
			vector<int> next; next.push_back(cur[0]+dx[d]); next.push_back(cur[1]+dy[d]); next.push_back(cur[2]+dz[d]);
			if (!check(next)) continue;
			if (dist[next] > dist[cur]+1) {
				dist[next] = dist[cur]+1;
				if (next[0] == el && next[1] == ei && next[2] == ej) {return dist[next]; }
				q.push(next);
			}
		}
	}
	return -1;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> L >> R >> C) {
    	if (L == 0 && R == 0 && C == 0) break;
    	for (int l = 0; l < L; l++) {
    		for (int i = 0; i < R; i++) {
    			for (int j = 0; j < C; j++) {
    				cin >> ch[l][i][j];
    				vector<int> point; point.push_back(l); point.push_back(i); point.push_back(j);
    				if (ch[l][i][j] == 'S') {
    					sl = l, si = i, sj = j;
    					dist[point] = 0;
    				else if (ch[l][i][j] == 'E') {
    					el = l, ei = i, ej = j;
    					dist[point] = INF;
    				} else {
    					dist[point] = INF;
    				}
    			}
    		}
    	} 	
    	int ans = bfs();
    	if (ans != -1) cout << "Escaped in " << ans << " minute(s).\n";
    	else cout << "Trapped!\n";
    }
    return 0;
}
