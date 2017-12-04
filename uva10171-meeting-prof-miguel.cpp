#include <bits/stdc++.h>
using namespace std;
char age, direction, x, y;
int young[27][27], old[27][27];
int cost, u, v;
void floyd_warshall(int age) {
	for (int k = 0; k < N; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				young[i][j] = min(young[i][j], young[i][k] + young[k][j]);
				old[i][j] = min(old[i][j], old[i][k] + old[k][j]);
			}
		}	
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	while (cin >> N) {
		if (N == 0) break;
		int adjMat[105][105];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				old[i][j] = INF;		
				young[i][j] = INF;
			}
			old[i][i] = young[i][i] = 0;
		}
		for (int i = 0; i < N; i++) {
			cin >> age >> direction >> x >> y >> cost;
			int u = x - 'A', v = y - 'A';
			if (u == v) continue;
			if (age == 'Y') {
				young[u][v] = cost;
				if (direction == 'B') young[v][u] = cost;
			} else {
				old[u][v] = cost;
				if (direction == 'B') old[v][u] = cost;
			}
		}
		cin >> me >> prof;
		floyd_warshall();
		int ans = INF;
		for (int i = 0; i < N; i++) {
			ans = min(ans, adjMat[me][i] + adjMat[prof][i]);
		}
		if (ans == INF) {
			cout << "You will never meet.\n";
		} else {
			cout << ans;
			for (int i = 0; i < N; i++) {
				int meRoute = adjMat[me][i], profRoute = adjMat[prof][i];
				if (meRoute + profRoute == ans) cout << " " << char(i + 'A'); 
			}
			cout << "\n";
		}
	}
	return 0;
}