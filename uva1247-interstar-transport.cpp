#include <bits/stdc++.h>
using namespace std;
int V = 27;
int parent[27][27];
void floyd_warshall() {
	for (int k = 0; k < V; k++) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (adjMat[i][j] < adjMat[i][k] + adjMat[k][j]) {
					adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
					parent[i][j] = parent[k][j];
				}
			}
		}	
	}
}
void printPath(int i, int j) {
	if (i != j) printPath(i, parent[i][j]);
	cout << char(j + 'A') << " ";
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> S >> P;
	int adjMat[105][105];
	for (int i = 0; i < V; i++) {
		for (int j = 0; j < V; j++) {
			adjMat[i][j] = INF;		
			parent[i][j] = i;
			parent[j][i] = j;
		}
	}
	for (int i = 0; i < P; i++) {
		cin >> s >> e >> d;
		int u = s - 'A', v = e - 'A';
		adjMat[u][v] = d;
		adjMat[v][u] = d;
	}
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> s >> e;
		int u = s - 'A', v = e - 'A';
		if (schedule[u] == 1 && schedule[v] == 1) {
			printPath(u, v);
		} else if (schedule[u] == 1) {
			for (int i = 0; i < V; i++) {
				if (adjMat[u][i])
			}
		} else if (schedule[v] == 1) {

		} else {

		}
		cout << "\n";
	}
}