#include <bits/stdc++.h>
using namespace std;
int V = 100;
void floyd_warshall() {
	for (int k = 0; k < V; k++) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjMat[i][j] = min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
			}
		}	
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	while (cin >> a >> b) {
		if (a == 0 && b == 0) break;
		int adjMat[105][105];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjMat[i][j] = INF;		
			}
		}
		adjMat[a][b] = 1;
		while (cin >> a >> b) {
			if (a == 0 && b == 0) break;
			adjMat[a][b] = 1;
		}
		floyd_warshall();
		double average = 0.0;
		int connections = 0;
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i != j && adjMat[i][j] != INF) {
					connections++;
					average += adjMat[i][j];
				}
			}
		}
		cout << average / connections << "\n";
	}	
	return 0;
}