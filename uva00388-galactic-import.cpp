//http://cathon.github.io/2014/12/05/UVA-314/
#include <bits/stdc++.h> 
#define LL long long 
using namespace std;
bool visited[55][55];
string conns;
double dist[130], v[130], val;
int grid[130][130];
int bfs() {
	queue<char> q;
	q.push('*');
	dist['*'] = 0;
	while (!q.empty()) {
		char u = q.front(); q.pop();
		visited[u] = true;
		for (char c = 'A'; c <= 'Z'; c++) {
			if (grid[u][c] && dist[c] > dist[u]+1) {
				dist[c] = dist[u]+1;
				q.push(c);
			}
		}			
	}
	double maxImp = 0.0;
	int maxInd = 0;
	for (char c = 'A'; c <= 'Z'; c++) {
		double d = v[c] - (v[c]*0.05*(dist[c]-1));
		if (maxImp < d) {
			maxImp = d;
			maxInd = c;
		}
	}
	return maxInd;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    while (cin >> N) {
    	for (int i = 1; i <= N; i++) {
			cin >> name >> val >> conns;
			for (int c = 0; c < conns.size(); c++) {
				if (conns[c] == '*') {
					grid[name]['*'] = 1; grid['*'][name] = 1;
				} else {
					grid[name][conns[c]] = 1;
					grid[conns[c]][name] = 1;
				}
			}
			val[name] = v*100.0;
			dist[name] = INF;
    	}
    	cout << "Import from " << bfs() << "\n";
    }
}
